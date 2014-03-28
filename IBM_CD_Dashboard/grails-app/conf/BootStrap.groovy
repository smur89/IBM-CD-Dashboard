import com.ibm.team.build.common.model.BuildState
import com.ibm.team.build.common.model.BuildStatus
import com.ibm.team.repository.common.model.impl.ContributorImpl
import com.ibm.team.workitem.common.model.WorkItemTypes
import ibm_cd_dashboard.Build
import ibm_cd_dashboard.Role
import ibm_cd_dashboard.Team
import ibm_cd_dashboard.User
import ibm_cd_dashboard.UserProfile
import ibm_cd_dashboard.UserRole
import ibm_cd_dashboard.WorkItem
import org.codehaus.groovy.grails.commons.ApplicationHolder

import java.sql.Timestamp

class BootStrap {
    def domainService = ApplicationHolder.application.mainContext.DomainService

    def init = { servletContext ->
        def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
        def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

        def testUser = new User(username: 'user', password: 'password', userProfile: new UserProfile())
        testUser.save(flush: true, failOnError: true)
        UserRole.create testUser, userRole, true

        def testAdmin = new User(username: 'admin', password: 'password', userProfile: new UserProfile(projects: ["_7WLmoJMtEeOGtNGDGcm9bw"]))
        testAdmin.save(flush: true, failOnError: true)
        UserRole.create testAdmin, adminRole, true

        assert User.count() == 2
        assert Role.count() == 2
        assert UserProfile.count() == 2
        assert UserRole.count() == 2

        bootstrapBuilds()
        domainService.populateTeams()
    }
    def destroy = {
    }

    def randomTimeStamp(){
        long offset = Timestamp.valueOf("2012-10-01 00:00:00").getTime();
        long end = Timestamp.valueOf("2014-06-01 00:00:00").getTime();
        long diff = end - offset + 1;
        Timestamp rand = new Timestamp(offset + (long)(Math.random() * diff));
        return rand
    }

    def bootstrapBuilds(){
        domainService.deleteAllTeamData()

        def randomId = new Random()
        def randomTime = new Random()
        println("Bootstrapping Teams...")

        for (int i = 0; i < randomId.nextInt(50); i++){
            Team newTeam = new Team(teamId: "_BSTID"<<randomId.nextInt(),
                    teamName: "BootstrapTeam"<<i ,
                    teamMembers: [new ContributorImpl(emailAddress: "bootstrap1"<<i<<"@cddashboard.com", name: "Bootstrap1"<<i),
                            new ContributorImpl(emailAddress: "bootstrap2"<<i<<"@cddashboard.com", name: "Bootstrap2"<<i),
                            new ContributorImpl(emailAddress: "bootstrap3"<<i<<"@cddashboard.com", name: "Bootstrap3"<<i)]
            )
            println("Teams " << newTeam.teamId)
            def buildStates = BuildState.values()
            def buildStatus = BuildStatus.values()
            def workItemTypes = [WorkItemTypes.DEFECT, WorkItemTypes.TASK]

            for (int j = 0; j < randomId.nextInt(60); j++){

                Build newBuild = new Build(buildId: "_BSBID"<<randomId.nextInt()<<i<<j,
                        name: "_BSBuildName"<<i<<j,
                        buildDefinitionId: "bootstrap.build.injection",
                        buildTimeInMillis: randomTime.nextInt(1000000),
                        startTime: randomTime.nextInt(1000000),
                        buildStatus: buildStatus[randomId.nextInt(4)],
                        buildState: buildStates[randomId.nextInt(5)],
                        modified: new Date(randomTimeStamp().getTime())
                )
                newTeam.addToBuilds(newBuild)

                for (int k = 0; k < randomId.nextInt(100); k++){
                    WorkItem newWorkItem = new WorkItem(
                            workItemId: newBuild.buildId<<"_BSWIID"<<randomId.nextInt()<<i<<j<<k,
                            modified: new Date(),
                            creationDate: randomTimeStamp(),
                            resolutionDate: randomTimeStamp(),
                            duration: randomTime.nextInt(100000),
                            type: workItemTypes.get(randomId.nextInt(2))
                    )
                    newBuild.addToWorkItems(newWorkItem)
                    newTeam.addToBuilds(newBuild)
                }
            }
            newTeam.save(flush:true, failOnError: true)
        }
    }
}
