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
            def user
            def userProfile
            def teams = []
            def allTeams = Team.getAll()
            if (springSecurityService.isLoggedIn()) {
                user = User.get(springSecurityService.principal.id)
                userProfile = user.getUserProfile()
                log.info("Getting subscribed teams for ${user}.")
                for (team in allTeams) {
                    if (userProfile.projects.contains(team.teamId)) {
                        teams.add(team)
                        print(team.teamId)
                    }
                }
            } else {
                log.info("Getting all teams from local database.")
                for (team in allTeams) {
                    teams.add(team)
                    print(team.teamId)
                }
                log.info("Teams returned: ${allTeams}")
            }

            [teams: teams]
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
            if (config.DomainLastModified < config.ServerLastModified && Team.count() > 0) {  //If last modified date < newest entry in server DB
                println("Domain < Server - No action implemented")
                redirect(controller: "team", action: "index")

                //TODO implement case scenario
            } else if (Team.count() < 1) { //if Database empty
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
            //domainService.deleteAllTeamData() // Delete everything
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
        def builds = team.getBuilds().sort { a, b -> a.modified <=> b.modified }
        def jsonTimes = []
        builds.each {
            def timeMap = [
                    name: it.getName(),
                    time: it.getBuildTimeInMillis(),
                    modified: it.getModified()
            ]
            jsonTimes.add(timeMap)
        }
        [team: team, avgBuildTime: builds.buildTimeInMillis.sum { it } / builds.count { it }, jsonTimes: jsonTimes]
    }
}
