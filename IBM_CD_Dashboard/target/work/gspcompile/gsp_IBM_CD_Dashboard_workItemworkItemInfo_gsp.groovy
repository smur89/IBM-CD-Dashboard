import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_IBM_CD_Dashboard_workItemworkItemInfo_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/workItem/workItemInfo.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
expressionOut.print(workItem.getWorkItemId())
})
invokeTag('captureTitle','sitemesh',4,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',4,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',5,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
expressionOut.print(workItem.getWorkItemId())
printHtmlPart(5)
expressionOut.print(workItem.getModified())
printHtmlPart(6)
expressionOut.print(workItem.getDuration())
printHtmlPart(7)
expressionOut.print(workItem.getCreationDate())
printHtmlPart(8)
expressionOut.print(workItem.getResolutionDate())
printHtmlPart(9)
expressionOut.print(workItem.getType())
printHtmlPart(10)
expressionOut.print(workItem.getSeverity().toString())
printHtmlPart(11)
})
invokeTag('captureBody','sitemesh',37,[:],1)
printHtmlPart(12)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1398850942000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
