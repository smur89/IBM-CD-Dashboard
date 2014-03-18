package ibm_cd_dashboard

class Build {

    // use buildID as the primary key
    static mapping = {
        id generator: 'assigned'
        id name: 'buildId'
        name defaultValue: "'N/A'"
    }
    static constraints = {
        buildId nullable: false
        buildId unique: true
        buildId blank: false
        workItems nullable: true
        name nullable: true

        workItems cascade: 'none'

    }

    static belongsTo = [team: Team] // Cascade delete from Team
    static hasMany = [workItems: WorkItem] // Cascade save to workItems
    //static mappedBy = [workItems: 'buildOwner']

    String buildId                //String
    String name                   //String
    String buildDefinitionId      //String
    long buildTimeInMillis        //long
    long startTime                //Date
    String buildStatus            //buildStatus
    String buildState             //buildState
    Date modified                 //Date
}
