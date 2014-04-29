package ibm_cd_dashboard

/*
    In Rational Team Concert, project areas define the process used by everything they include.
    The initial process definition and description are provided by a process template.
    It defines roles, the permissions and process behavior for artifacts owned by the
    project area and it's enclosed teams.
 */
class Team {
    // use teamID as the primary key
    static mapping = {
        id generator: 'assigned'
        id name: 'teamId'
    }
    static constraints = {
        teamId nullable: false
        teamId blank: false
        teamId unique: true

        builds nullable: true
    }
    String teamId //String
    String teamName //String
    List teamMembers

    static hasMany = [builds: Build, teamMembers: Contributor] // Cascade save to Build



    //ArrayList<Contributor> teamMembers //List<IContributor>
}
