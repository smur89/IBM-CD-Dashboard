import ibm_cd_dashboard.Team
import  java.text.DecimalFormat
import  grails.converters.JSON
import  com.ibm.team.workitem.common.model.WorkItemTypes
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_IBM_CD_Dashboard_teamteamInfo_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/team/teamInfo.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("application")],-1)
printHtmlPart(2)
expressionOut.print(resource(dir: 'css', file: 'nv.d3.css'))
printHtmlPart(3)
invokeTag('javascript','g',7,['src':("d3/d3.js")],-1)
printHtmlPart(1)
invokeTag('javascript','g',8,['src':("d3/nv.d3.min.js")],-1)
printHtmlPart(4)
createTagBody(2, {->
createTagBody(3, {->
expressionOut.print(team.getTeamName())
})
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',11,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
for( jt in (jsonTimes) ) {
printHtmlPart(1)
if(true && (jt.getAt("time") > 0)) {
printHtmlPart(9)
expressionOut.print(jt.getAt("time"))
printHtmlPart(10)
expressionOut.print(jt.getAt("name"))
printHtmlPart(11)
}
printHtmlPart(5)
}
printHtmlPart(12)
})
invokeTag('script','r',79,[:],2)
printHtmlPart(13)

DecimalFormat df = new DecimalFormat("#.##");

printHtmlPart(14)
expressionOut.print(df.format(avgBuildTime))
printHtmlPart(15)

//Calculate total defects
        def count = 0
        team.getBuilds().each {
            it.workItems.each {
                if (it.getType() == WorkItemTypes.DEFECT) {
                    count++
                }
            }
        }

printHtmlPart(16)
expressionOut.print(count)
printHtmlPart(17)
for( member in (team.teamMembers) ) {
printHtmlPart(18)
expressionOut.print(member.name)
printHtmlPart(19)
expressionOut.print(member.email)
printHtmlPart(20)
expressionOut.print(member.email)
printHtmlPart(21)
}
printHtmlPart(22)

def builds = team.getBuilds().sort { a, b -> a.getModified() <=> b.getModified() }

printHtmlPart(23)
loop:{
int i = 0
for( it in (builds) ) {
printHtmlPart(24)
expressionOut.print(i == 0 ? 'lotusFirst' : '')
printHtmlPart(25)
expressionOut.print(builds.size() - (i + 1))
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(27)
if(true && (it.name.equals(null))) {
printHtmlPart(28)
}
else {
printHtmlPart(29)
expressionOut.print(it.name)
printHtmlPart(30)
}
printHtmlPart(31)
})
invokeTag('link','g',149,['action':("buildInfo"),'controller':("build"),'id':(it.buildId)],3)
printHtmlPart(32)
expressionOut.print(it.getBuildStatus())
printHtmlPart(33)
expressionOut.print(it.getBuildState())
printHtmlPart(34)
expressionOut.print(it.getModified().format('dd/MM/yyyy', TimeZone.getTimeZone('GMT')))
printHtmlPart(33)
expressionOut.print(it.getWorkItems().count { it })
printHtmlPart(35)
i++
}
}
printHtmlPart(36)
})
invokeTag('captureBody','sitemesh',166,[:],1)
printHtmlPart(37)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1398850905000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
