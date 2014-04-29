import com.ibm.team.build.common.model.BuildState
import com.ibm.team.build.common.model.BuildStatus
import com.ibm.team.repository.common.model.impl.ContributorImpl
import com.ibm.team.workitem.common.internal.setup.builders.DefaultIdentifiers
import com.ibm.team.workitem.common.model.WorkItemTypes
import ibm_cd_dashboard.Build
import ibm_cd_dashboard.BuildTestMetrics
import ibm_cd_dashboard.Contributor
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
        //domainService.deleteAllTeamData()
        log.info("Server Startup initialisation")
        if(User.count() == 0 || Role.count() == 0){
            log.info("No Users or Roles, Bootstrapping default users: 'user' and 'admin'")
            addUserAndAdmin()
        }
        if(Team.count() == 0){
            log.info("No Teams, Bootstrapping Team, Build and WorkItem Data")
            bootstrapBuilds()
            domainService.populateTeams()
        }
        log.info("Initialisation complete")
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

    def addUserAndAdmin(){

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
    }

    def bootstrapBuilds(){

        def randomId = new Random()
        def randomTime = new Random()
        log.info("Bootstrapping Teams...")

        for (int i = 0; i < randomId.nextInt(50); i++){
            Team newTeam = new Team(teamId: "_BSTID"<<randomId.nextLong(),
                    teamName: "BootstrapTeam"<<i ,
                    teamMembers: [new Contributor(email: "bootstrap1"<<i<<"@cddashboard.com", name: "Bootstrap1"<<i, userId: "BootstrapUser1"<<i),
                            new Contributor(email: "bootstrap2"<<i<<"@cddashboard.com", name: "Bootstrap2"<<i, userId: "BootstrapUser2"<<i),
                            new Contributor(email: "bootstrap3"<<i<<"@cddashboard.com", name: "Bootstrap3"<<i, userId: "BootstrapUser3"<<i)]
            )
            newTeam.save(flush: true, failOnError: true)
            log.info("Created Teams " << newTeam.teamId)
            def buildStates = BuildState.values()
            def buildStatus = BuildStatus.values()
            def severities = [DefaultIdentifiers.Severity.BLOCKER.toString(), DefaultIdentifiers.Severity.NORMAL.toString(),
                    DefaultIdentifiers.Severity.CRITICAL.toString(), DefaultIdentifiers.Severity.MAJOR.toString(),
                    DefaultIdentifiers.Severity.MINOR.toString(), DefaultIdentifiers.Severity.UNASSIGNED.toString()]
            def workItemTypes = [WorkItemTypes.DEFECT, WorkItemTypes.TASK]

            for (int j = 0; j < randomId.nextInt(60); j++){
                Build newBuild = new Build(buildId: "_BSBID"<<randomId.nextInt()<<i<<j,
                        name: "_BSBuildName"<<i<<j,
                        team: newTeam,
                        buildDefinitionId: "bootstrap.build.injection",
                        buildTimeInMillis: randomTime.nextInt(1000000),
                        startTime: randomTime.nextInt(1000000),
                        buildStatus: buildStatus[randomId.nextInt(4)],
                        buildState: buildStates[randomId.nextInt(5)],
                        modified: new Date(randomTimeStamp().getTime()),
                        testResults: new BuildTestMetrics(commitPhaseTestingTime: randomTime.nextInt(60000))  //Commit Phase test Times should be ~5mins/300000ms (According to IBM documentation)
                )
                newBuild.save(flush: true, failOnError: true)
                newTeam.addToBuilds(newBuild)

                for (int k = 0; k < randomId.nextInt(100); k++){
                    WorkItem newWorkItem = new WorkItem(
                            workItemId: newBuild.buildId<<"_BSWIID"<<randomId.nextInt()<<i<<j<<k,
                            buildOwner: newBuild,
                            modified: new Date(),
                            creationDate: randomTimeStamp(),
                            resolutionDate: randomTimeStamp(),
                            duration: randomTime.nextInt(100000),
                            type: workItemTypes.get(randomId.nextInt(2)),
                            severity: severities.get(randomId.nextInt(5))
                    )
                    newWorkItem.save(flush: true, failOnError: true)
                    newBuild.addToWorkItems(newWorkItem)
                    newTeam.addToBuilds(newBuild)
                }
            }
            //newTeam.save(flush:true, failOnError: true)
        }
    }
}
