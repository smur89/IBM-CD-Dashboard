package ibm_cd_dashboard

import com.ibm.team.repository.common.IContributor

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
    }

    static hasMany = [builds: Build] // Cascade save to Build

    String teamId //String
    String teamName //String
    List<IContributor> teamMembers //List<IContributor>
}
