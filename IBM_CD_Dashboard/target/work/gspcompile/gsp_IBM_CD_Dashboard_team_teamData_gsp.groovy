import ibm_cd_dashboard.Build
import  ibm_cd_dashboard.Team
import  com.ibm.team.workitem.common.internal.setup.builders.DefaultIdentifiers
import  com.ibm.team.workitem.common.model.WorkItemTypes
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_IBM_CD_Dashboard_team_teamData_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/team/_teamData.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)

//      AreaChart
    def buildColumns = [['string', 'Build Id'], ['number', 'Build Time (ms)'], ['number', 'Average Build Time (ms)']]
    def testColumns = [['string', 'Build Id'], ['number', 'Test Time (ms)'], ['number', 'Average Test Time (ms)']]
    def totalBuildTime = 0
    def buildTimes = []
    def testTimes = []
    def builds = team?.getBuilds()?.sort { a, b -> a?.getModified() <=> b?.getModified() }
    def avgBuildTime = (team?.getBuilds()?.buildTimeInMillis?.sum { it } / builds?.size())
    def avgTestTime = (team?.getBuilds()?.testResults?.commitPhaseTestingTime?.sum { it } / builds?.size())


    for (Build build in builds) {
        buildTimes.add([build?.buildId, build?.buildTimeInMillis, avgBuildTime])
        testTimes.add([build.buildId, build?.getTestResults()?.getCommitPhaseTestingTime(), avgTestTime])
        totalBuildTime += build?.buildTimeInMillis
    }


    def totalDefects = 0 //Total
    def s3 = 0 // Normal, Minor
    def s2 = 0 // Major
    def s1 = 0 // Critical or Blocker

    //Count severity for display, group by s1, s2 and s3 as per IBM conventions.
    team?.getBuilds()?.each {
        it?.workItems?.each {
            if (it?.getType() == WorkItemTypes.DEFECT) {
                totalDefects++
                if (it?.severity == DefaultIdentifiers.Severity.UNASSIGNED.toString() ||
                        it?.severity == DefaultIdentifiers.Severity.MINOR.toString() ||
                        it?.severity == DefaultIdentifiers.Severity.NORMAL.toString()) {
                    s3++
                } else if (it?.severity == DefaultIdentifiers.Severity.MAJOR.toString()) {
                    s2++
                } else if (it?.severity == DefaultIdentifiers.Severity.CRITICAL.toString() ||
                        it.severity == DefaultIdentifiers.Severity.BLOCKER.toString()) {
                    s1++
                }
            }
        }
    }

    def avgDefects = 0
    if (totalDefects > 0 && builds.size() > 0) {
        avgDefects = (totalDefects / builds?.size())
    }

printHtmlPart(1)
createTagBody(1, {->
expressionOut.print(team?.teamId)
})
invokeTag('link','g',52,['action':("teamInfo"),'id':(team?.teamId)],1)
printHtmlPart(2)

def pieColumns = [['string', 'Team Name'], ['number', 'numDefects']]
                    def pieData = [["S3", s3], ["S2", s2], ["S1", s1]]

printHtmlPart(3)
invokeTag('pieCoreChart','gvisualization',66,['elementId':("piechart${team.teamId}"),'title':("Commit Stage Defects"),'width':(300),'height':(300),'colors':(['red', '#FF8600', '#1B5200']),'columns':(pieColumns),'data':(pieData)],-1)
printHtmlPart(4)
expressionOut.print(team?.teamId)
printHtmlPart(5)
invokeTag('areaCoreChart','gvisualization',74,['elementId':("buildChart${team.teamId}"),'title':("Build Times"),'height':(300),'width':(490),'colors':(['#0892D0', '#2A4480', '#BBBB00']),'columns':(buildColumns),'data':(buildTimes)],-1)
printHtmlPart(6)
expressionOut.print(team?.teamId)
printHtmlPart(7)
invokeTag('areaCoreChart','gvisualization',82,['elementId':("testChart${team.teamId}"),'title':("Commit Test Times (Expanded)"),'height':(300),'width':(490),'colors':(['#FFEB00', '#666666']),'columns':(testColumns),'data':(testTimes)],-1)
printHtmlPart(8)
expressionOut.print(team?.teamId)
printHtmlPart(9)

int buildCount = team?.getBuilds()?.count { it }?.intValue()

printHtmlPart(10)
expressionOut.print(buildCount)
printHtmlPart(11)
invokeTag('formatNumber','g',100,['number':(avgBuildTime),'type':("number"),'maxFractionDigits':("2")],-1)
printHtmlPart(12)
invokeTag('formatNumber','g',108,['number':(avgTestTime),'type':("number"),'maxFractionDigits':("2")],-1)
printHtmlPart(13)
invokeTag('formatNumber','g',116,['number':(avgDefects),'type':("number"),'maxFractionDigits':("2")],-1)
printHtmlPart(14)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1398793077000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
