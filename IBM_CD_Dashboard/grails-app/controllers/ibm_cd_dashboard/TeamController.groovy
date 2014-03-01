package ibm_cd_dashboard

import com.google.gson.Gson
import grails.converters.JSON
import grails.util.Holders
import org.apache.commons.logging.LogFactory
import org.codehaus.groovy.grails.commons.ApplicationHolder
import org.codehaus.groovy.grails.web.json.JSONObject

class TeamController {
    private static final log = LogFactory.getLog(this)

    //def rtcService = ApplicationHolder.application.mainContext.RTCService
    def domainService = ApplicationHolder.application.mainContext.DomainService

    def index() { //teamInfo
        try {
            log.info("Getting all teams from local database.")
            def allTeams = Team.getAll()
            log.info("Teams returned: ${allTeams}")

            [teams: allTeams]
        }
        catch (Exception e) {
            println("Index Exception : " << e.printStackTrace())
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
            println("Index Exception : " << e.printStackTrace())
        }
    }

    def setup() {
        try {
            domainService.deleteAllTeamData() // Delete everything
            domainService.populateTeams()     // repopulate
            redirect(index())
        } catch (Exception e) {
            println("Index Exception : " << e.printStackTrace())
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

        //println(jsonTimes)
        [team: team, avgBuildTime: builds.buildTimeInMillis.sum { it } / builds.count { it }, jsonTimes: jsonTimes.sort {a, b -> a.modified <=> b.modified}]
    }
}
