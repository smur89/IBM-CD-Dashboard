package ibm_cd_dashboard

class UserProfile {

    static belongsTo = [user:User]

    List projects
    static hasMany = [ projects: String ]


    static constraints = {
    }

    static mapping = {
    }

}
