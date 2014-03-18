package ibm_cd_dashboard

import java.sql.Timestamp


class WorkItem {

    static mapping = {
        id generator: 'assigned'
        id name: 'workItemId' // Use workItemId as the primary key
    }
    static constraints = {
        //workItemId nullable: false
        //workItemId blank: false
        //workItemId unique: true
        //builds(nullable: true)

    }

    static belongsTo = [buildOwner:Build] // Cascade delete from Build class
    //static hasMany = [builds: Build]

    String workItemId            //String
    Date modified           //Timestamp
    Timestamp creationDate       //Timestamp
    Timestamp resolutionDate     //Timestamp
    long duration                //long
    String type

}
