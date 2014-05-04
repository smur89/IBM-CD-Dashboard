import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_IBM_CD_Dashboardindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("application")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',83,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
invokeTag('message','g',87,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(7)
invokeTag('meta','g',92,['name':("app.version")],-1)
printHtmlPart(8)
invokeTag('meta','g',93,['name':("app.grails.version")],-1)
printHtmlPart(9)
expressionOut.print(GroovySystem.getVersion())
printHtmlPart(10)
expressionOut.print(System.getProperty('java.version'))
printHtmlPart(11)
expressionOut.print(grails.util.Environment.reloadingAgentEnabled)
printHtmlPart(12)
expressionOut.print(grailsApplication.controllerClasses.size())
printHtmlPart(13)
expressionOut.print(grailsApplication.domainClasses.size())
printHtmlPart(14)
expressionOut.print(grailsApplication.serviceClasses.size())
printHtmlPart(15)
expressionOut.print(grailsApplication.tagLibClasses.size())
printHtmlPart(16)
for( plugin in (applicationContext.getBean('pluginManager').allPlugins) ) {
printHtmlPart(17)
expressionOut.print(plugin.name)
printHtmlPart(18)
expressionOut.print(plugin.version)
printHtmlPart(19)
}
printHtmlPart(20)
for( c in (grailsApplication.controllerClasses.sort { it.fullName }) ) {
printHtmlPart(21)
createTagBody(3, {->
expressionOut.print(c.fullName)
})
invokeTag('link','g',124,['controller':(c.logicalPropertyName)],3)
printHtmlPart(22)
}
printHtmlPart(23)
})
invokeTag('captureBody','sitemesh',129,[:],1)
printHtmlPart(24)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1398800927000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
