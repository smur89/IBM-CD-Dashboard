package ibm_cd_dashboard

import grails.util.Holders
import org.codehaus.groovy.grails.commons.ApplicationHolder

import java.sql.Timestamp

/**
 * Class that controls the Cron Job to check the last modified time of the RTC Server.
 * If the Server has been last modified more recently than the Dashboard Domain Server
 * then the Cron Job triggers an Update to take place to bring the Domain in line with
 * the server.
 */
class CheckForServerUpdatesJob {

    static triggers = {
        cron name: 'cronTrigger', cronExpression: " 0/120 * * * * ?" //every 2 mins
        //cron name: 'cronTrigger', cronExpression: "0 0 0/2 1/1 * ? *" //every 2 hours
    }

    def rtcService = ApplicationHolder.application.mainContext.RTCService
    def domainService = ApplicationHolder.application.mainContext.RTCService

    /**
     * Method checks if the Domain and Server are in sync based on the time stamps
     * and if they are not, it triggers an update method to be called.
     */
    def execute() {
        def serverLastModified = new Timestamp(rtcService.checkServerLastUpdate().getTime())
        def lastModified = new Timestamp(Holders.getGrailsApplication().config.DomainLastModified.getTime())
        log.info("Cron Job - Checking server in sync with local database")

        if (serverLastModified > Holders.getGrailsApplication().config.DomainLastModified) {
            log.info("Updating domain objects. Domain last modified ${lastModified}")
            //Update the domain with the new information from the server. Only update those after the DomainLastModified time.
            domainService.updateDomain(lastModified);
            log.info("Domain objects updated. Domain last modified set to ${lastModified}")
        } else {
            log.info("Domain up to date.")
        }
    }
}
