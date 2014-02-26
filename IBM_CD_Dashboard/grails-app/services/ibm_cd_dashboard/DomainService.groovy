package ibm_cd_dashboard

import com.ibm.team.build.common.model.IBuildResult
import com.ibm.team.process.common.IProjectArea
import grails.transaction.Transactional
import org.codehaus.groovy.grails.commons.ApplicationHolder
import org.codehaus.groovy.grails.commons.ConfigurationHolder
import org.springframework.dao.DuplicateKeyException
import grails.util.Holders

import java.sql.Timestamp


@Transactional
class DomainService {

    def rtcService = ApplicationHolder.application.mainContext.RTCBuildService //Todo: would be nice to remove this dependancy in code refactor

    def deleteAllTeamData() {
        if (Team.count() > 0) {
            for (team in Team.getAll()) {
                for (build in team.getBuilds()) {
                    build.delete()
                }
                team.delete(flush: true)
            }
        }
        assert (Team.count() == 0)
        println("Deleted")
    }

    def serverLastModified(){
        rtcService.updateServerLastModified()
    }

    def populateTeams() {
        try {
            List<IProjectArea> allActiveProjects = rtcService.getActiveProjects()
            def i = 1
            // For Each project, create a new team object
            for (project in allActiveProjects) {
                def newTeam
                def projId = project.getItemId().toString().substring(6, project.getItemId().toString().length() - 1) //Remove [UUID and ] from the string
                def projMems = rtcService.getProjectMembers(project)
                println("projMems ${projMems[1]}")
                newTeam = new Team(teamId: projId,
                        teamName: project.getName(),
                        teamMembers: projMems ) // todo: team members always assigned as null

                println("Populating Builds for project ${i++} of ${allActiveProjects.count { it }}... (${projId})")
                populateBuilds(newTeam, project)
                ConfigurationHolder.getConfig().getProperty("updateServerLastModified")

                print("Saving...")
                if (!newTeam.save()) {
                    newTeam.errors.each {
                        println it
                    }
                }

                println("Populating WorkItems...")
                populateWorkItems(project)

                print("Saving...")
                if (!newTeam.save()) {
                    newTeam.errors.each {
                        println it
                    }
                }

                println("Workitems count: ${WorkItem.count()}")

                def grailsApplication = Holders.getGrailsApplication()
                grailsApplication.config.DomainLastModified = new Date().toTimestamp()
                serverLastModified()

            }
        } catch (DuplicateKeyException dke) {
            println("Duplicate Key Exception (New workItem)")
        } catch (NullPointerException npe) {
            println("Null Pointer in populateTeams() : " << npe.printStackTrace())
        } finally {
            println("Done. Database ready")
        }
    }

    def populateBuilds(Team newTeam, IProjectArea project) {
        //For each build associated with this project create a new build and add it to the team builds
        List<IBuildResult> buildResults = rtcService.getProjectBuildResults(project)
        for (build in buildResults) {
            def newBuild
            def buildId = build.getItemId().toString().substring(6, build.getItemId().toString().length() - 1)
            newBuild = new Build(buildId: buildId,
                    team: newTeam,
                    name: build.getLabel(),
                    modified: build.modified(),
                    buildDefinitionId: rtcService.getBuildDefinition(build.buildDefinition).getId(),
                    buildTimeInMillis: build.getBuildTimeTaken(),
                    startTime: build.getBuildStartTime(),
                    buildStatus: build.getStatus(),
                    buildState: build.getState())
            newTeam.addToBuilds(newBuild)
        }
    }

    def populateWorkItems(IProjectArea project) {
        List<IBuildResult> buildResults = rtcService.getProjectBuildResults(project)
        for (build in buildResults) {
            def buildId = build.getItemId().toString().substring(6, build.getItemId().toString().length() - 1)
            def thisBuild = Build.get(buildId)

            def buildWorkItems = rtcService.getBuildWorkItems(build)
            if (buildWorkItems != null) {
                for (workItem in buildWorkItems) {
                    def workItemId = workItem.getItemId().toString().substring(6, workItem.getItemId().toString().length() - 1)
                    def buildWorkId = buildId << workItemId  // concatenate buildId and workItemId to get unique key identifier
//                    println(workItem.workItemType)
                    def newWorkItem = new WorkItem(workItemId: buildWorkId,
                            buildOwner: thisBuild,
                            modified: workItem.modified(),
                            creationDate: workItem.getCreationDate(),
                            resolutionDate: workItem.getResolutionDate(),
                            duration: workItem.getDuration(),
                            type: workItem.getWorkItemType(),
                    )
                    //newWorkItem.addToBuilds(thisBuild)
                    thisBuild.addToWorkItems(newWorkItem)

//                    if (!newWorkItem.save(flush: true)) {
//                        newWorkItem.errors.each {
//                            println it
//                        }
//                    }
//                    newWorkItem.addToBuilds(thisBuild)
//                    thisBuild.addToWorkItems(newWorkItem)
//                    thisBuild.save(flush: true)

                }
            }
        }
    }
}
