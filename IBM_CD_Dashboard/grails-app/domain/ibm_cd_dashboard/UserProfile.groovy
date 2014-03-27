package ibm_cd_dashboard

class UserProfile {

    static belongsTo = [user:User]
    public List<String> projects

    static constraints = {
    }

    static mapping = {
    }

}
