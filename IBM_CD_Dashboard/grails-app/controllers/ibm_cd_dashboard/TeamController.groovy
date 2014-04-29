package ibm_cd_dashboard

import grails.util.Holders
import org.apache.commons.logging.LogFactory
import org.codehaus.groovy.grails.commons.ApplicationHolder

import java.sql.SQLException

/**
 * Controls all logic and requests relating to the Team domain model
 *
 * @author  Shane Murphy
 * @version 1.0
 * @since   2014-05-07
 */
class TeamController {
    private static final log = LogFactory.getLog(this)
    def springSecurityService

    def domainService = ApplicationHolder.application.mainContext.DomainService

    /**
     * In the case that the user is logged in, a list of the users subscribed teams are displayed.
     * Otherwise, a list of all teams are displayed. This list includes charts displaying the
     * breakdown of defects within the project and the build time and test time of the project.
     * These are passed to the view to be displayed in alphabetical ordering.
     */
    def index() {
        try {
            def user, userProfile
            def teams = []
            def allTeams = Team.getAll()
            if (springSecurityService.isLoggedIn()) {
                user = User.get(springSecurityService.principal.id)
                log.info("Getting subscribed teams for ${user}.")
                user.getUserProfile().projects.each {
                    teams.add(Team.get(it.toString()))
                }
            } else {
                log.info("Getting all teams from local database.")
                for (team in allTeams) {
                    teams.add(team)
                }
                log.info("Teams returned: ${allTeams}")
            }
            [teams: teams.sort { a, b -> a.teamName <=> b.teamName }]

        } catch (SQLException sqle) {
            log.error("SQL Exception in checkState(): ${sqle.getMessage()}")
        } catch (Exception e) {
            log.error("Exception in index(): ${e.getMessage()}")
        }
    }

    /**
     * Method used on request of the root directory to check the current state
     * as compared with the remote RTC server. Redirects to appropriate method.
     */
    def checkState() {
        log.info("Checking State.")
        def config = Holders.getGrailsApplication().config
        try {
            if (config.DomainLastModified < config.ServerLastModified && Team.count() > 0) {  //If last modified date < newest entry in server DB
                log.info("Domain needs to be Updated")
                domainService.updateDomain(config.DomainLastModified)
            } else if (Team.count() < 1) { //if Database empty
                log.info("Redirect to setup, ")
                redirect(action: "setup")
            } else { // database up to date
                log.info("Database up to date.")
                redirect(action: index())
            }
        } catch (SQLException sqle) {
            log.error("SQL Exception in checkState(): ${sqle.getMessage()}")
        } catch (Exception e) {
            log.error("Exception in checkState(): ${e.getMessage()}")
        }
    }

    /**
     * Method to set up the domain if there is no data in it currently.
     * This uses the DomainService populateTeams method to populate the
     * domain and then redirects to the index page once populated.
     */
    def setup() {
        try {
            //domainService.deleteAllTeamData() // Delete everything
            domainService.populateTeams()     // repopulate
            redirect(index())
        } catch (SQLException sqle) {
            log.error("SQL Exception in checkState(): ${e.getMessage()}")
        } catch (Exception e) {
            log.error("Exception in setup(): ${e.getMessage()}")
        }
    }

    /**
     * Show a list of all Teams
     */
    def allTeams() {
        [teams: Team.getAll()]
    }

    /**
     * Gets a list of builds associated with the team ID received as a parameter
     * sorts these by the last modified, so it can be represented on a graph in
     * a logical way. Passes this as a json object to the view. Also calculates
     * the average build time and passes this to the view, along with the Team
     * object, for display purposes.
     *
     * @param The Team object to be displayed
     */
    def teamInfo() {
        def team
        def builds
        def jsonTimes
        float avgBuildTime
        try {
            team = Team.get(params.id)
            builds = team.getBuilds().sort { a, b -> a.modified <=> b.modified }
            jsonTimes = []
            builds.each {
                def timeMap = [
                        name: it.getName(),
                        time: it.getBuildTimeInMillis(),
                        modified: it.getModified()
                ]
                jsonTimes.add(timeMap)
            }
            avgBuildTime = builds?.buildTimeInMillis?.sum { it } / builds?.count { it }
        } catch (SQLException sqle) {
            log.error("SQL Exception in checkState(): ${sqle.getMessage()}")
        } catch (Exception e) {
            log.error("Exception in checkState(): ${e.getMessage()}")
        }
        [team: team, avgBuildTime: avgBuildTime, jsonTimes: jsonTimes]
    }
}

//