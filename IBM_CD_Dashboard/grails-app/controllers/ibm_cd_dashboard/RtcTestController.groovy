package ibm_cd_dashboard

import com.ibm.team.build.common.model.IBuildResult
import com.ibm.team.process.common.IProjectArea
import com.ibm.team.workitem.common.internal.model.WorkItem
import com.ibm.team.workitem.common.internal.query.ResolvingQueryResultIterator
import groovy.util.slurpersupport.NodeChild
import org.codehaus.groovy.grails.commons.ApplicationHolder
import groovyx.net.http.RESTClient
import groovyx.net.http.*
import javax.net.ssl.X509TrustManager
import javax.net.ssl.SSLContext
import java.security.cert.X509Certificate
import javax.net.ssl.TrustManager
import java.security.SecureRandom
import org.apache.http.conn.ssl.SSLSocketFactory
import org.apache.http.conn.scheme.Scheme

class RtcTestController {

    def rest() {
        def http = new RESTClient( 'https://localhost:9443' )
        http.auth.basic 'smur89', 'smur89'


        //Ignore the SSL Certificates
        def sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, [
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        null
                    }
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                    }
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                    }
                } ] as TrustManager[], new SecureRandom())
        def sf = new SSLSocketFactory(sslContext, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER)
        def httpsScheme = new Scheme("https", sf, 443)
        http.client.connectionManager.schemeRegistry.register( httpsScheme )


//        def returnedXML = []
//        def res = http.get( path: '/ccm/oslc/workitems/catalog', contentType: ContentType.XML,
//        ){ resp, xml ->
//            println resp.status
//            xml.each {  // iterate over each XML 'status' element in the response:
//                println it
//                returnedXML.add(xml.title)
//            }
//        }

        def returnedXML = []
        def res = http.get( path: 'qm/oslc_qm/catalog', contentType: ContentType.XML,
        ){ HttpResponseDecorator resp, NodeChild xml ->
            println xml
            xml.entry.each { it -> // iterate over each XML 'status' element in the response:
                println "Entry: " << it
                returnedXML.add(xml)
            }
        }

        [returnedXML: returnedXML]

    }

    def rtcService = ApplicationHolder.application.mainContext.RTCBuildService
    def domainService = ApplicationHolder.application.mainContext.DomainService

    def Index(){
        List<IProjectArea> allProjects = rtcService.getAllProjects()
        def allBuildResults = rtcService.getAllBuildResults()
        def workItems = []
        int i = 0
        def projectMembers = [:]

        /*
        for each project get the it's members, store in a map with the project contextId and pass tot he view to be displayed
         */
        for(project in allProjects){
            projectMembers.put(project.contextId, (rtcService.getProjectMembers(allProjects[i++])))
            workItems.add(rtcService.getProjectWorkItems(project))
        }

        i = 0;
        def workItemSummarys = [:]

        for(ResolvingQueryResultIterator iter in workItems)
        {

            for(iter; iter.hasNext(null); )
            {

                WorkItem wI = (WorkItem) iter.next(null).getItem()
                println(wI)
                workItemSummarys.put(wI.getSummary(), wI.getContextId())
            }
        }

        [allProjects: allProjects, projectMembers: projectMembers,  allBuildResults: allBuildResults, workItemSummarys: workItemSummarys]
    }
}
