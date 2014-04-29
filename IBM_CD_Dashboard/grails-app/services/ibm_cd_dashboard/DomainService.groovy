package ibm_cd_dashboard

import com.ibm.team.build.common.model.IBuildResult
import com.ibm.team.process.common.IProjectArea
import com.ibm.team.workitem.common.model.IWorkItem
import grails.transaction.Transactional
import grails.util.Holders
import org.codehaus.groovy.grails.commons.ApplicationHolder
import org.springframework.dao.DuplicateKeyException

import java.sql.Timestamp

/**
 * This Service is responsible for handling the manipulation of data for the Domain objects.
 *
 * @author Shane Murphy
 * @version 1.0
 * @since 2014-05-07
 */
@Transactional
class DomainService {

    def rtcService = ApplicationHolder.application.mainContext.RTCService

    /**
     * Check the server for updates after the passed in param lastUpdate.
     * After determining which projects have been modified after this time,
     * update the domain to emcompass these modifications.
     *
     * @param lastUpdate
     * @return
     */
    def updateDomain(Timestamp lastUpdate) {
        //TODO Refactor this, it's not even finished yet and it's becoming unwieldy

        def projectsToUpdate = identifyOutOfDateProjects(lastUpdate)
        projectsToUpdate.each {
            def teamId = it.getItemId().toString().substring(6, it.getItemId().toString().length() - 1) //Remove [UUID and ] from the string
            // If this team doesn't already exist, we need to add it.
            def team
            if (!Team.exists(teamId)) {
                log.info("Creating Team " << teamId)
                team = new Team(teamId: teamId,
                        teamName: it.getName())
                team.save(flush: true, failOnError: true)
            } else {
                team = Team.get(teamId)
            }

            def builds = rtcService.getProjectBuildResults(it)
            builds.each {
                def buildId = it.getItemId().toString().substring(6, it.getItemId().toString().length() - 1)
                // If this build doesn't already exist, we need to add it.
                if (it.modified() > lastUpdate) {
                    if (!Build.exists(buildId)) {
                        def newBuild = createNewBuildObject(team, it)
                        newBuild.save(failOnError: true)
                        log.info("Created build " << buildId)
                        populateWorkItems(it)
                    } else {
                        //If the build was last updated after the last time the server was updated.
                        if (it.modified() > lastUpdate) {
                            def thisBuild = Build.get(buildId)
                            def workItems = rtcService.getBuildWorkItems(it)
                            workItems.each {
                                def workItemId = it.getItemId().toString().substring(6, it.getItemId().toString().length() - 1)
                                def buildWorkId = buildId << workItemId  // concatenate buildId and workItemId to get unique key identifier
                                //If this workItem doesn't exist in the local database, we need to add it.
                                if (!WorkItem.exists(buildWorkId)) {
                                    def newWorkItem = createNewWorkItemObject(thisBuild, it)
                                    log.info("Created workitem " << workItemId << " modified: " << it.modified())
                                    thisBuild.addToWorkItems(newWorkItem)
                                } else {
                                    def workItem = WorkItem.get(workItemId)
                                    workItem.modified = it.modified()
                                    workItem.resolutionDate = it.getResolutionDate()
                                    workItem.duration = it.getDuration()
                                    workItem.type = it.getWorkItemType()
                                    workItem.severity = it.getSeverity().toString()
                                    workItem.save()
                                }
                            }
                            def build = Build.get(buildId)
                            build.name it.getLabel()
                            build.modified = it.modified()
                            build.buildDefinitionId = rtcService.getBuildDefinition(it.buildDefinition).getId()
                            build.buildTimeInMillis = it.getBuildTimeTaken()
                            build.startTime = it.getBuildStartTime()
                            build.buildStatus = it.getStatus()
                            build.buildState = it.getState()
                            build.save()
                        }
                    }
                }
            }
        }
        Holders.getGrailsApplication().config.DomainLastModified = new Date()

    }

/**
 * Gets a list of projects that have been updated after the pased in parameter time
 *
 * @param lastUpdate timestamp after which projects are deemed out of date
 * @return list of projects to be updated
 */
    def identifyOutOfDateProjects(Timestamp lastUpdate) {
        def projects = rtcService.getAllProjects();
        //Get Project Areas that need to be updated.
        log.info("identifying projects")
        List<IProjectArea> projectsToUpdate = new ArrayList<IProjectArea>();
        projects.each {
            if (it.modified() > lastUpdate) {
                projectsToUpdate.add(it)
                log.info("To be updated: " << it.name)
            }
        }
        return projectsToUpdate
    }

/**
 * Deletes all domain data. Database will be empty.
 */
    def deleteAllTeamData() {
        if (Team.count() > 0) {
            Team.getAll().each {
                it.getBuilds().each {
                    it.delete()
                }
                it.delete()
            }
        }
        assert (Team.count() == 0)
        log.info("Deleted All Teams")
    }

/**
 * This is only called on initial startup to populate an empty database.
 * Pulls in all teams and related data from the RTC server using the RTSService
 * and adds the information to the domain database.
 *
 * @return serverLastUpdate lastTime the server was updated
 */
    def populateTeams() {
        try {
            log.info("Populating Teams")
            List<IProjectArea> allActiveProjects = rtcService.getActiveProjects()
            def i = 1
            // For each project create a new team object
            for (project in allActiveProjects) {
                def newTeam
                def projId = project.getItemId().toString().substring(6, project.getItemId().toString().length() - 1) //Remove [UUID and ] from the string
                def users = new ArrayList<Contributor>()
                project.getMembers().each {
                    def user = rtcService.getContributor(it)
                    users.add(new Contributor(email: user.getEmailAddress(), name: user.getName(), userId: user.userId))
                }

                newTeam = new Team(teamId: projId,
                        teamName: project.getName(),
                        teamMembers: users)
                log.info("Populating Builds for it ${i++} of ${allActiveProjects.count { it }}... (${projId})")
                populateBuilds(newTeam, project)

                newTeam.save(flush: true)
                List<IBuildResult> buildResults = rtcService.getProjectBuildResults(project)
                buildResults.each {
                    populateWorkItems(it)
                }
                newTeam.save(flush: true)
                def grailsApplication = Holders.getGrailsApplication()
                grailsApplication.config.DomainLastModified = new Date().toTimestamp()
                rtcService.checkServerLastUpdate()
            }
        } catch (DuplicateKeyException dke) {
            log.error("${new Date()}: Duplicate Key Exception (New it): ${dke.getMessage()}")
        } catch (NullPointerException npe) {
            log.error("${new Date()}: Null Pointer in populateTeams(): ${npe.getMessage()}")
        } finally {
            log.info("${new Date()}: Database Loaded and Ready")
        }
    }

/**
 * Adds the appropriate Builds to the Team object.
 *
 * @param newTeam The newly created Team to add the builds to
 * @param project The area on the RTC Server which relates to the team
 */
    def populateBuilds(Team newTeam, IProjectArea project) {
        //For each it associated with this it create a new it and add it to the team builds
        List<IBuildResult> buildResults = rtcService.getProjectBuildResults(project)
        buildResults.each {
            def newBuild = createNewBuildObject(newTeam, it)
            newTeam.addToBuilds(newBuild)
        }
    }

/**
 * Adds the appropriate WorkItems to the build object
 *
 * @param build The newly created Build to add the WorkItems to.
 * @return
 */
    def populateWorkItems(IBuildResult build) {
        def buildId = build.getItemId().toString().substring(6, build.getItemId().toString().length() - 1)
        def thisBuild = Build.get(buildId)
        def buildWorkItems = rtcService.getBuildWorkItems(build)
        if (buildWorkItems != null) {
            buildWorkItems.each {
                def newWorkItem = createNewWorkItemObject(thisBuild, it)
                thisBuild.addToWorkItems(newWorkItem)
            }
        }
    }

/**
 * Method to handle the creation of a Build object from a BuildResult returned from the server
 *
 * @param newTeam The Team to create this Build under
 * @param build The BuildResult containing the required information to create a Build Object
 * @return newBuild The Newly Created Build Object
 */
    def createNewBuildObject(Team newTeam, IBuildResult build) {
        def randomTime = new Random()
        def buildId = build.getItemId().toString().substring(6, build.getItemId().toString().length() - 1)
        log.info("Creating creating new build for database. Build ID: " << buildId)
        def newBuild = new Build(buildId: buildId,
                team: newTeam,
                name: build.getLabel(),
                modified: build.modified(),
                buildDefinitionId: rtcService.getBuildDefinition(build.buildDefinition).getId(),
                buildTimeInMillis: build.getBuildTimeTaken(),
                startTime: build.getBuildStartTime(),
                buildStatus: build.getStatus(),
                buildState: build.getState(),
                testResults: new BuildTestMetrics(commitPhaseTestingTime: randomTime.nextInt(60000)
                ))
        return newBuild
    }

/**
 * Method to handle the creation of a WorkItem object from a IWorkItem returned from the server
 *
 * @param thisBuild The Build which is to 'own' this WorkItem
 * @param workItem The WorkItem from the server containing all required information to create the WorkItem object
 * @return newWorkItem the newly created WorkItem Object
 */
    def createNewWorkItemObject(Build thisBuild, IWorkItem workItem) {
        def workItemId = workItem.getItemId().toString().substring(6, workItem.getItemId().toString().length() - 1)
        def buildWorkId = thisBuild.getBuildId() << workItemId  // concatenate buildId and workItemId to get unique key identifier
        log.info("Creating creating new workitem for database. WorkItem ID: " << workItemId)
        def newWorkItem = new WorkItem(workItemId: buildWorkId,
                buildOwner: thisBuild,
                modified: workItem.modified(),
                creationDate: workItem.getCreationDate(),
                resolutionDate: workItem.getResolutionDate(),
                duration: workItem.getDuration(),
                type: workItem.getWorkItemType(),
                severity: workItem.getSeverity().toString()
        )
        return newWorkItem
    }

}
