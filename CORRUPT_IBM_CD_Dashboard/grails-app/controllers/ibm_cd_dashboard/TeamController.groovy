package ibm_cd_dashboard

import grails.util.Holders
import org.apache.commons.logging.LogFactory
import org.codehaus.groovy.grails.commons.ApplicationHolder

class TeamController {
    private static final log = LogFactory.getLog(this)
    def springSecurityService

    def domainService = ApplicationHolder.application.mainContext.DomainService

    def index() { //teamInfo
        try {
            def username = null
            if(springSecurityService.isLoggedIn()){
                username = (User.get(springSecurityService.principal.id).username)
            }


            log.info("Getting all teams from local database.")
            def allTeams = Team.getAll()
            log.info("Teams returned: ${allTeams}")

            [teams: allTeams]
        }
        catch (Exception e) {
            log.error("Index Exception in index(): ${e.getMessage()} \n ${e.printStackTrace()}")
            println("Index Exception : ${e.getMessage()}")
        }
    }

    def checkState() {
        println("Checking State.")
        def config = Holders.getGrailsApplication().config
        try {
            if(config.DomainLastModified < config.ServerLastModified && Team.count()>0) {  //If last modified date < newest entry in server DB

            } else if (Team.count()<1){ //if Database empty
                println("Redirect to setup, ")
                redirect(controller: "team", action: "setup")
            } else {  // database up to date
                println("Database up to date.")
                redirect(index())
            }
        } catch (Exception e) {
            log.error("Index Exception in checkState(): ${e.getMessage()} \n ${e.printStackTrace()}")
            println("Index Exception : ${e.getMessage()}")
        }
    }

    def setup() {
        try {
            domainService.deleteAllTeamData() // Delete everything
            domainService.populateTeams()     // repopulate
            redirect(index())
        } catch (Exception e) {
            log.error("Index Exception in setup(): ${e.getMessage()} \n ${e.printStackTrace()}")
            println("Index Exception : ${e.getMessage()}")
        }
    }

    def allTeams() {
        [teams: Team.getAll()]
    }

    def teamInfo() {
        // Calculate average build time
        def team = Team.get(params.id)
        def builds = team.getBuilds()
        def jsonTimes = []
        builds.each {
            def timeMap = [
                    name: it.getName(),
                    time: it.getBuildTimeInMillis(),
                    modified: it.getModified()
            ]
            jsonTimes.add(timeMap)
        }
        println(team.getTeamMembers())

        [team: team, avgBuildTime: builds.buildTimeInMillis.sum { it } / builds.count { it }, jsonTimes: jsonTimes.sort {a, b -> a.modified <=> b.modified}]
    }
}
