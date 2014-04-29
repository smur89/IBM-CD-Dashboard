package ibm_cd_dashboard

import groovyx.net.http.ContentType
import groovyx.net.http.RESTClient
import org.apache.http.conn.scheme.Scheme
import org.apache.http.conn.ssl.SSLSocketFactory

import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import java.security.SecureRandom
import java.security.cert.X509Certificate

/**
 * DELETE ME!
 */
class RtcTestController {

    def index() {
        def http = new RESTClient('https://localhost:9443')
        http.auth.basic 'smur89', 'smur89'

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
                }] as TrustManager[], new SecureRandom())
        def sf = new SSLSocketFactory(sslContext, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER)
        def httpsScheme = new Scheme("https", sf, 443)
        http.client.connectionManager.schemeRegistry.register(httpsScheme)
        def myXML = []




        def xml = http.get(path: '/qm/oslc_qm/catalog', contentType: ContentType.XML,)
                { resp, xml ->
                    println resp.status
                    xml.each {  // iterate over each XML 'status' element in the response:
                        println it
                        myXML.add(xml)
                    }
                }

        def text = new XmlSlurper()

        //def t = XML.parse(new FileInputStream(res), "UTF-8")

        // perform a GET request, expecting JSON response data
        /*http.request( GET, XML) {
            uri.path = '/ccm/oslc/workitems/catalog'
            headers.'Accept' =  'application/x-oslc-cm-change-request+xml'

            // response handler for a success response code:
            response.success = { resp, xml ->
                println resp.statusLine

                xml.each {
                    println it
                    myXML = xml
                }
            }

            // handler for any failure status code:
            response.failure = { resp -> println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}" }
        }*/
        [returnedXML: myXML]

    }


}
