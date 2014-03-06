package ibm_cd_dashboard

import grails.util.Holders
import org.codehaus.groovy.grails.commons.ApplicationHolder



class CheckForServerUpdatesJob {

       static triggers = {
        cron name: 'cronTrigger', cronExpression: " 0/5 * * * * ?" //every 5 seconds
//        cron name: 'cronTrigger', cronExpression: "0 0 0/2 1/1 * ? *" //every 2 hours
    }

    def rtcService = ApplicationHolder.application.mainContext.RTCService

    def execute() {
        println("Quartz Job Execution!")
        def timeServerUpdated = rtcService.checkServerLastUpdate()
        log.info("Server Checked on: ${new Date()}")
        def lastModified = Holders.getGrailsApplication().config.DomainLastModified

        if (timeServerUpdated > Holders.getGrailsApplication().config.DomainLastModified) {
            //Update the domain with the new information from the server. Only update those after the DomainLastModified time.
            log.info("Updating domain objects. Domain last modified ${lastModified}")
            DomainService.updateDomain(lastModified);
            log.info("Domain objects updated. Domain last modified set to ${lastModified}")

        }
    }
}
