import org.grails.plugins.google.visualization.formatter.PatternFormatter
import  org.grails.plugins.google.visualization.formatter.NumberFormatter
import  org.grails.plugins.google.visualization.formatter.DateFormatter
import  org.grails.plugins.google.visualization.formatter.ColorRange
import  org.grails.plugins.google.visualization.formatter.ColorFormatter
import  org.grails.plugins.google.visualization.formatter.BarFormatter
import  org.grails.plugins.google.visualization.formatter.ArrowFormatter
import  org.grails.plugins.google.visualization.util.DateUtil
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='google-visualization', version='0.6.2')
class gsp_googleVisualization_deprecatedindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/google-visualization-0.6.2/grails-app/views/deprecated/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('apiImport','gvisualization',7,[:],-1)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(4)

def myDailyActivitiesColumns = [['string', 'Task'], ['number', 'Hours per Day']]
          def myDailyActivitiesData = [['Work', 11], ['Eat', 2], ['Commute', 2], ['Watch TV', 2], ['Sleep', 7]]
          def companyPerformanceColumns = [['string', 'Year'], ['number', 'Sales'], ['number', 'Expenses']]
          def companyPerformanceData = [['2004', 1000, 400], ['2005', 1170, 460], ['2006', 660, 1120], ['2007', 1030, 540]]
          def weightByAgeColumns = [['number', 'Age'], ['number', 'Weight']]
          def weightByAgeData = [[8, 12], [4, 5.5], [11, 14], [4, 5], [3, 3.5], [6.5, 7]]

printHtmlPart(5)
invokeTag('pieChart','gvisualization',19,['elementId':("piechart"),'title':("My Daily Activities"),'width':(400),'height':(240),'is3D':(true),'columns':(myDailyActivitiesColumns),'data':(myDailyActivitiesData)],-1)
printHtmlPart(4)
invokeTag('barChart','gvisualization',20,['elementId':("barchart"),'title':("Company Performance"),'width':(400),'height':(240),'is3D':(true),'columns':(companyPerformanceColumns),'data':(companyPerformanceData)],-1)
printHtmlPart(4)
invokeTag('columnChart','gvisualization',21,['elementId':("columnchart"),'title':("Company Performance"),'width':(400),'height':(240),'is3D':(true),'columns':(companyPerformanceColumns),'data':(companyPerformanceData)],-1)
printHtmlPart(4)
invokeTag('areaChart','gvisualization',22,['elementId':("areachart"),'title':("Company Performance"),'width':(400),'height':(240),'legend':("bottom"),'columns':(companyPerformanceColumns),'data':(companyPerformanceData)],-1)
printHtmlPart(4)
invokeTag('lineChart','gvisualization',23,['elementId':("linechart"),'width':(400),'height':(240),'title':("Company Performance"),'legend':("bottom"),'columns':(companyPerformanceColumns),'data':(companyPerformanceData)],-1)
printHtmlPart(4)
invokeTag('scatterChart','gvisualization',24,['elementId':("scatterchart"),'width':(400),'height':(240),'titleX':("Age"),'titleY':("Weight"),'legend':("none"),'pointSize':(5),'columns':(weightByAgeColumns),'data':(weightByAgeData)],-1)
printHtmlPart(6)
})
invokeTag('captureBody','sitemesh',75,[:],1)
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1342034378000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
