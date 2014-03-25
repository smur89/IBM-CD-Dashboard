import ibm_cd_dashboard.Role
import ibm_cd_dashboard.User
import ibm_cd_dashboard.UserProfile
import ibm_cd_dashboard.UserProfile
import ibm_cd_dashboard.UserRole

class BootStrap {

    def init = { servletContext ->
        def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
        def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

        def testUser = new User(username: 'me', password: 'password', userProfile: new UserProfile(projects: null, version: null))
        testUser.save(flush: true, failOnError: true)
        UserRole.create testUser, adminRole, true

        assert User.count() == 1
        assert Role.count() == 2
        assert UserRole.count() == 1
    }
    def destroy = {
    }
}
