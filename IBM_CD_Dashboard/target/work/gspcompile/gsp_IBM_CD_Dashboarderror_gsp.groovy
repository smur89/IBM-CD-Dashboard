import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_IBM_CD_Dashboarderror_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/error.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':("/"),'charset':("UTF-8")],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
if((grails.util.Environment.current.name == 'development') && true) {
printHtmlPart(3)
}
else {
printHtmlPart(4)
}
})
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("Description"),'content':("Example error page")],-1)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',52,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
if((grails.util.Environment.current.name == 'development') && true) {
printHtmlPart(8)
invokeTag('renderException','g',65,['exception':(exception.getMessage())],-1)
printHtmlPart(9)
}
else {
printHtmlPart(10)
}
printHtmlPart(11)
createClosureForHtmlPart(12, 2)
invokeTag('link','g',75,['controller':("team"),'action':("index"),'class':("lotusBtn")],2)
printHtmlPart(13)
expressionOut.print(exception.getCause())
printHtmlPart(14)
expressionOut.print(exception.getStackTraceText())
printHtmlPart(15)
})
invokeTag('captureBody','sitemesh',84,['class':("lotusui30_body lotusui30_fonts lotusui30 lotusError")],1)
printHtmlPart(16)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1398801126000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
