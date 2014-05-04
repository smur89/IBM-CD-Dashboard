import ibm_cd_dashboard.Team
import  com.ibm.team.build.common.model.BuildState
import  com.ibm.team.workitem.common.model.WorkItemTypes
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_IBM_CD_Dashboard_teamindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/team/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('apiImport','gvisualization',4,[:],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("application")],-1)
printHtmlPart(1)
invokeTag('require','r',7,['module':("jquery")],-1)
printHtmlPart(1)
invokeTag('javascript','g',8,['src':("d3/d3.js")],-1)
printHtmlPart(1)
invokeTag('javascript','g',9,['src':("d3/nv.d3.min.js")],-1)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',11,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
if(true && (teams?.size() < 1)) {
printHtmlPart(5)
}
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(6)
createClosureForHtmlPart(7, 3)
invokeTag('link','g',20,['controller':("login"),'action':("auth")],3)
printHtmlPart(8)
})
invokeTag('ifNotLoggedIn','sec',23,[:],2)
printHtmlPart(9)
loop:{
int i = 0
for( it in (teams) ) {
printHtmlPart(10)
expressionOut.print(i == 0 ? 'lotusFirst' : 'lotusCell')
printHtmlPart(11)
createTagBody(3, {->
expressionOut.print(it?.teamName)
})
invokeTag('link','g',33,['action':("teamInfo"),'id':(it?.teamId)],3)
printHtmlPart(12)
expressionOut.print(it?.getTeamId())
printHtmlPart(13)

def jsonTimes = []
                    if (it?.getBuilds()?.count { it } > 0) {
                        it?.getBuilds()?.each {
                            def timeMap = [
                                    name: it?.getName(),
                                    time: it?.getBuildTimeInMillis(),
                                    modified: it?.getModified()
                            ]
                            jsonTimes?.add(timeMap)
                        }
                    }

printHtmlPart(14)
if(true && (jsonTimes.size() > 0)) {
printHtmlPart(15)
invokeTag('render','g',57,['template':("teamData"),'model':([team: it, jsonTimes: jsonTimes])],-1)
printHtmlPart(16)
}
else {
printHtmlPart(17)
}
printHtmlPart(18)
i++
}
}
printHtmlPart(19)
})
invokeTag('captureBody','sitemesh',64,[:],1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1398850897000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
