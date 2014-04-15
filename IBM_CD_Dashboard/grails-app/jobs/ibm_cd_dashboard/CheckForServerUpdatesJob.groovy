package ibm_cd_dashboard

import grails.util.Holders
import org.codehaus.groovy.grails.commons.ApplicationHolder

import java.sql.Timestamp



class CheckForServerUpdatesJob {

       static triggers = {
        cron name: 'cronTrigger', cronExpression: " 0/120 * * * * ?" //every 2 mins
        //cron name: 'cronTrigger', cronExpression: "0 0 0/2 1/1 * ? *" //every 2 hours
    }

    def rtcService = ApplicationHolder.application.mainContext.RTCService
    def domainService = ApplicationHolder.application.mainContext.RTCService


    def execute() {
        println("Quartz Job Execution!")
        def serverLastModified = new Timestamp(rtcService.checkServerLastUpdate().getTime())
        def lastModified = Holders.getGrailsApplication().config.DomainLastModified
        log.info("Cron Job - Checking server in sync with local database")

        if (serverLastModified > Holders.getGrailsApplication().config.DomainLastModified) {
            //Update the domain with the new information from the server. Only update those after the DomainLastModified time.
            log.info("Updating domain objects. Domain last modified ${lastModified}")
            domainService.updateDomain(lastModified);
            log.info("Domain objects updated. Domain last modified set to ${lastModified}")

        } else {
            log.info("Domain up to date.")
        }
    }
}
