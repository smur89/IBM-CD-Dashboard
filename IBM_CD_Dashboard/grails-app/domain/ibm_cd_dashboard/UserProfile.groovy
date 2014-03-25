package ibm_cd_dashboard

class UserProfile {

    static belongsTo = [user:User]

    static constraints = {
    }

    static mapping = {

    }

    List<String> projects
}
