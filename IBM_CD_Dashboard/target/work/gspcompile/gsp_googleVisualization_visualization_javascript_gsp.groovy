import org.apache.commons.lang.StringUtils
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='google-visualization', version='0.6.2')
class gsp_googleVisualization_visualization_javascript_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/google-visualization-0.6.2/grails-app/views/_visualization_javascript.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('set','g',2,['var':("functionName"),'value':("draw${StringUtils.capitalize(visualizationData.name)}")],-1)
printHtmlPart(1)
out.print(visualizationData.version)
printHtmlPart(2)
out.print(visualizationData.visualization.packageName)
printHtmlPart(3)
if(true && (visualizationData.dynamicLoading)) {
printHtmlPart(4)
out.print(functionName)
}
if(true && (visualizationData.language)) {
printHtmlPart(5)
out.print(visualizationData.language)
printHtmlPart(6)
}
printHtmlPart(7)
if(true && (!visualizationData.dynamicLoading)) {
printHtmlPart(8)
out.print(functionName)
printHtmlPart(9)
}
printHtmlPart(10)
out.print(functionName)
printHtmlPart(11)
out.print(visualizationData.name)
printHtmlPart(12)
for( column in (visualizationData.columns) ) {
printHtmlPart(13)
out.print(visualizationData.name)
printHtmlPart(14)
out.print(column[0])
printHtmlPart(15)
out.print(column[1])
printHtmlPart(16)
}
printHtmlPart(13)
for( row in (visualizationData.rows) ) {
printHtmlPart(13)
out.print(visualizationData.name)
printHtmlPart(17)
out.print(row)
printHtmlPart(18)
}
printHtmlPart(19)
out.print(visualizationData.name)
printHtmlPart(20)
out.print(visualizationData.visualization.object)
printHtmlPart(21)
out.print(visualizationData.elementId)
printHtmlPart(22)
invokeTag('render','g',18,['template':("/formatter"),'model':([visualizationData: visualizationData]),'plugin':("google-visualization")],-1)
printHtmlPart(23)
for( beforeDrawEvent in (visualizationData.beforeDrawEvents) ) {
printHtmlPart(24)
out.print(visualizationData.name)
printHtmlPart(25)
out.print(beforeDrawEvent.key)
printHtmlPart(26)
out.print(beforeDrawEvent.value)
printHtmlPart(18)
}
printHtmlPart(27)
out.print(visualizationData.name)
printHtmlPart(28)
out.print(visualizationData.name)
printHtmlPart(29)
out.print(visualizationData.options)
printHtmlPart(30)
for( afterDrawEvent in (visualizationData.afterDrawEvents) ) {
printHtmlPart(24)
out.print(visualizationData.name)
printHtmlPart(25)
out.print(afterDrawEvent.key)
printHtmlPart(26)
out.print(afterDrawEvent.value)
printHtmlPart(18)
}
printHtmlPart(31)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1359917816000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
