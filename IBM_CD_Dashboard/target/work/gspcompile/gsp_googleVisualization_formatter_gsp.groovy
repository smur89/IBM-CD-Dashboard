import org.grails.plugins.google.visualization.formatter.ColorFormatter
import  org.grails.plugins.google.visualization.formatter.PatternFormatter
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='google-visualization', version='0.6.2')
class gsp_googleVisualization_formatter_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/google-visualization-0.6.2/grails-app/views/_formatter.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
loop:{
int i = 0
for( formatter in (visualizationData.formatters) ) {
printHtmlPart(1)
invokeTag('set','g',4,['var':("index"),'value':(i + 1)],-1)
printHtmlPart(2)
expressionOut.print(index)
printHtmlPart(3)
expressionOut.print(formatter.object)
printHtmlPart(4)
expressionOut.print(formatter.options)
printHtmlPart(5)
if(true && (formatter instanceof PatternFormatter)) {
printHtmlPart(6)
expressionOut.print(index)
printHtmlPart(7)
expressionOut.print(visualizationData.name)
printHtmlPart(8)
expressionOut.print(formatter.srcColumnIndices)
if(true && (formatter.dstColumnIndex)) {
printHtmlPart(9)
expressionOut.print(formatter.dstColumnIndex)
}
printHtmlPart(5)
}
else if(true && (formatter instanceof ColorFormatter)) {
printHtmlPart(10)
for( range in (formatter.getFormattedRanges()) ) {
printHtmlPart(11)
expressionOut.print(index)
printHtmlPart(12)
expressionOut.print(range)
printHtmlPart(13)
}
printHtmlPart(10)
for( gradientRange in (formatter.getFormattedGradientRanges()) ) {
printHtmlPart(11)
expressionOut.print(index)
printHtmlPart(14)
expressionOut.print(gradientRange)
printHtmlPart(13)
}
printHtmlPart(6)
expressionOut.print(index)
printHtmlPart(7)
expressionOut.print(visualizationData.name)
printHtmlPart(8)
expressionOut.print(formatter.column)
printHtmlPart(5)
}
else {
printHtmlPart(6)
expressionOut.print(index)
printHtmlPart(7)
expressionOut.print(visualizationData.name)
printHtmlPart(8)
expressionOut.print(formatter.column)
printHtmlPart(5)
}
printHtmlPart(15)
i++
}
}
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
