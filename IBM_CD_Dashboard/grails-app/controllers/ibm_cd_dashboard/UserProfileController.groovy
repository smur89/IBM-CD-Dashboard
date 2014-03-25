package ibm_cd_dashboard



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UserProfileController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond UserProfile.list(params), model: [userProfileInstanceCount: UserProfile.count()]
    }

    def show(UserProfile userProfileInstance) {
        respond userProfileInstance
    }

    def create() {
        respond new UserProfile(params)
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
        if (userProfileInstance == null) {
            notFound()
            return
        }

        if (userProfileInstance.hasErrors()) {
            respond userProfileInstance.errors, view: 'edit'
            return
        }

        userProfileInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'UserProfile.label', default: 'UserProfile'), userProfileInstance.id])
                redirect userProfileInstance
            }
            '*' { respond userProfileInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(UserProfile userProfileInstance) {

        if (userProfileInstance == null) {
            notFound()
            return
        }

        userProfileInstance.delete flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'UserProfile.label', default: 'UserProfile'), userProfileInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
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
