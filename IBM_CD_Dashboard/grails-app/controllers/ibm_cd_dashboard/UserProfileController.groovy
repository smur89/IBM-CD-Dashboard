package ibm_cd_dashboard

import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured(['ROLE_USER', 'ROLE_ADMIN'])
class UserProfileController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def springSecurityService

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond UserProfile.list(params), model: [userProfileInstanceCount: UserProfile.count()]
    }

    def show() {
        UserProfile userProfileInstance = User.get(springSecurityService.principal.id).getUserProfile()
        [userProjectList:userProfileInstance.projects]
        println("Show Projects " << userProfileInstance.projects)
        respond userProfileInstance

    }

    @Transactional
    def save(UserProfile userProfileInstance) {
        if (userProfileInstance == null) {
            notFound()
            return
        }

        if (userProfileInstance.hasErrors()) {
            respond userProfileInstance.errors, view: 'create'
            return
        }

        userProfileInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'userProfileInstance.label', default: 'UserProfile'), userProfileInstance.id])
                redirect userProfileInstance
            }
            '*' { respond userProfileInstance, [status: CREATED] }
        }
    }

    def edit(UserProfile userProfileInstance) {
        respond userProfileInstance
    }

    @Transactional
    def update(UserProfile userProfileInstance) {
        println("PARAMS" << params.checkbox)

        for(def team in Team.all){
            if(params.checkbox."${team.teamId}") {
                userProfileInstance.projects.add(team.getTeamId())
                userProfileInstance.save(flush:true)
                println("INSERT " << team.getTeamId())
                println(userProfileInstance.projects)
            }
        }
        if (userProfileInstance == null) {
            notFound()
            return
        }

        if (userProfileInstance.hasErrors()) {
            respond userProfileInstance.errors, view: 'edit'
            return
        }

        userProfileInstance.user.save(flush: true)

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'UserProfile.label', default: 'UserProfile'), userProfileInstance.id])
                redirect userProfileInstance
            }
            '*' { respond userProfileInstance, [status: OK] }
        }
    }

    @Transactional
    def updateTwo() {
        def user = User.get(springSecurityService.principal.id)
        UserProfile userProfileInstance = user.getUserProfile()

        if (userProfileInstance == null) {
            notFound()
            return
        }

        if (userProfileInstance.hasErrors()) {
            respond userProfileInstance.errors, view: 'edit'
            return
        }

        for(Team team in Team.getAll()){
            if(params.checkbox."${team.teamId}") {
                if(userProfileInstance.projects == null){
                    userProfileInstance.projects = new ArrayList<>()
                }
                userProfileInstance.projects.add(team.teamId)
                println("INSERT " << team.getTeamId())
                if (!userProfileInstance.save(flush: true, failOnError: true)){
                    println("NULL")
                    println("Errors " << user.errors.allErrors)
                }
            }
        }

        println("proj " << userProfileInstance.projects)

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'UserProfile.label', default: 'UserProfile'), userProfileInstance.id])
                redirect userProfileInstance
            }
            '*' { respond userProfileInstance, [status: OK] }
        }
    }



    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'userProfileInstance.label', default: 'UserProfile'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
