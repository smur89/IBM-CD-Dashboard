import org.grails.plugins.google.visualization.data.Cell
import  org.grails.plugins.google.visualization.formatter.PatternFormatter
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
class gsp_googleVisualization_formatterindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/google-visualization-0.6.2/grails-app/views/formatter/index.gsp" }
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

def departmentRevenueChangeColumns = [['string', 'Department'], ['number', 'Revenues Change']]
          def departmentRevenueChangeData = [['Shoes', new Cell(value: 12, label: '12.0%')], ['Sports', new Cell(value: -7.3, label: '-7.3%')], ['Toys', new Cell(value: 0, label: '0%')], ['Electronics', new Cell(value: -2.1, label: '-2.1%')], ['Food', new Cell(value: 22, label: '22.0%')]]
          def departmentRevenueColumns = [['string', 'Department'], ['number', 'Revenues']]
          def departmentRevenueData = [['Shoes', 10700], ['Sports', -15400], ['Toys', 12500], ['Electronics', -2100], ['Food', 22600], ['Art', 1100]]
          def employeeDatesColumns = [['string', 'Employee Name'], ['date', 'Start Date (Long)'], ['date', 'Start Date (Medium)'], ['date', 'Start Date (Short)']]
          def employeeDatesData = [['Mike', DateUtil.createDate(2008, 1, 28, 0, 31, 26, 0), DateUtil.createDate(2008, 1, 28, 0, 31, 26, 0), DateUtil.createDate(2008, 1, 28, 0, 31, 26, 0)], ['Bob', DateUtil.createDate(2007, 5, 1), DateUtil.createDate(2007, 5, 1), DateUtil.createDate(2007, 5, 1)], ['Alice', DateUtil.createDate(2006, 7, 16), DateUtil.createDate(2006, 7, 16), DateUtil.createDate(2006, 7, 16)]]
          def peopleEmailColumns = [['string', 'Name'], ['string', 'Email']]
          def peopleEmailData = [['John Lennon', 'john@beatles.co.uk'], ['Paul McCartney', 'paul@beatles.co.uk'], ['George Harrison', 'george@beatles.co.uk'], ['Ringo Starr', 'ringo@beatles.co.uk']]
          def arrowFormatters = [new ArrowFormatter(1)]
          def barFormatter = new BarFormatter(1)
          barFormatter.width = 120
          def barFormatters = [barFormatter]
          def colorFormatter = new ColorFormatter(1)
          colorFormatter.ranges = [new ColorRange(-20000, 0, 'white', 'orange'), new ColorRange(20000, null, 'red', '#33ff33')]
          def colorFormatters = [colorFormatter]
          def longDateFormatter = new DateFormatter(1)
          longDateFormatter.formatType = 'long'
          def mediumDateFormatter = new DateFormatter(2)
          mediumDateFormatter.formatType = 'medium'
          def shortDateFormatter = new DateFormatter(3)
          shortDateFormatter.formatType = 'short'
          def dateFormatters = [longDateFormatter, mediumDateFormatter, shortDateFormatter]
          def numberFormatter = new NumberFormatter(1)
          numberFormatter.prefix = '$'
          numberFormatter.negativeColor = 'red'
          numberFormatter.negativeParens = true
          def numberFormatters = [numberFormatter]
          def patternFormatter = new PatternFormatter('<a href=\"mailto:{1}\">{0}</a>', [0, 1])
          def patternFormatters = [patternFormatter]

printHtmlPart(5)
invokeTag('table','gvisualization',42,['elementId':("arrowformat_div"),'allowHtml':(true),'showRowNumber':(true),'columns':(departmentRevenueChangeColumns),'data':(departmentRevenueChangeData),'formatters':(arrowFormatters)],-1)
printHtmlPart(4)
invokeTag('table','gvisualization',43,['elementId':("barformat_div"),'allowHtml':(true),'showRowNumber':(true),'columns':(departmentRevenueColumns),'data':(departmentRevenueData),'formatters':(barFormatters)],-1)
printHtmlPart(4)
invokeTag('table','gvisualization',44,['elementId':("colorformat_div"),'allowHtml':(true),'showRowNumber':(true),'columns':(departmentRevenueColumns),'data':(departmentRevenueData),'formatters':(colorFormatters)],-1)
printHtmlPart(4)
invokeTag('table','gvisualization',45,['elementId':("dateformat_div"),'showRowNumber':(true),'columns':(employeeDatesColumns),'data':(employeeDatesData),'formatters':(dateFormatters)],-1)
printHtmlPart(4)
invokeTag('table','gvisualization',46,['elementId':("numberformat_div"),'allowHtml':(true),'showRowNumber':(true),'columns':(departmentRevenueColumns),'data':(departmentRevenueData),'formatters':(numberFormatters)],-1)
printHtmlPart(4)
invokeTag('table','gvisualization',47,['elementId':("patternformat_div"),'allowHtml':(true),'showRowNumber':(true),'columns':(peopleEmailColumns),'data':(peopleEmailData),'formatters':(patternFormatters)],-1)
printHtmlPart(6)
})
invokeTag('captureBody','sitemesh',98,[:],1)
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
