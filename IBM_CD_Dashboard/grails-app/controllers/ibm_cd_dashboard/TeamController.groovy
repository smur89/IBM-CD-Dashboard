package ibm_cd_dashboard

import org.codehaus.groovy.grails.commons.ApplicationHolder

class TeamController {


    //def rtcService = ApplicationHolder.application.mainContext.RTCBuildService
    def domainService = ApplicationHolder.application.mainContext.DomainService

    def index(){ //teamInfo
        try{
            def allTeams = Team.getAll()

            [teams:allTeams]
        }
        catch (Exception e){
            println("Index Exception : " << e.printStackTrace())
        }
    }

    def setup(){
        try{
            domainService.deleteAllTeamData() // Delete everything
            domainService.populateTeams()     // repopulate
        } catch (Exception e){
            println("Index Exception : " << e.printStackTrace())
        }
        redirect(index())
    }

    def allTeams(){
        [teams:Team.getAll()]
    }

    def teamInfo(){
        // Calculate average build time
        def team = Team.get(params.id)
        def builds = team.getBuilds()
        [team:team, avgBuildTime:builds.buildTimeInMillis.sum{it} / builds.count {it}]
    }
}
