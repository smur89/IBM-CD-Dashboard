import com.ibm.team.workitem.common.model.WorkItemTypes
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_IBM_CD_Dashboard_buildbuildInfo_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/build/buildInfo.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
expressionOut.print(build.getName())
})
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(0)
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
expressionOut.print(build.getName())
printHtmlPart(5)
expressionOut.print(build.buildId)
printHtmlPart(6)
expressionOut.print(build.name)
printHtmlPart(7)
expressionOut.print(build.buildDefinitionId)
printHtmlPart(8)
expressionOut.print(build.buildTimeInMillis)
printHtmlPart(9)
expressionOut.print(build.startTime)
printHtmlPart(10)
expressionOut.print(build.buildStatus)
printHtmlPart(11)
expressionOut.print(build.buildState)
printHtmlPart(12)
expressionOut.print(build.modified)
printHtmlPart(13)
expressionOut.print(build.getWorkItems().count { it.getType().equals(WorkItemTypes.DEFECT) })
printHtmlPart(14)

def workItems = build.getWorkItems().sort { a, b -> b.getModified() <=> a.getModified() }

printHtmlPart(15)
expressionOut.print(workItems.count { it })
printHtmlPart(16)
for( _it88535189 in (workItems) ) {
changeItVariable(_it88535189)
printHtmlPart(17)
createTagBody(3, {->
expressionOut.print(it.type)
})
invokeTag('link','g',67,['action':("workItemInfo"),'controller':("workItem"),'id':(it.getWorkItemId())],3)
printHtmlPart(18)
createTagBody(3, {->
expressionOut.print(it.getCreationDate().format('dd/MM/yyyy', TimeZone.getTimeZone('GMT')))
})
invokeTag('link','g',70,['action':("workItemInfo"),'controller':("workItem"),'id':(it.getWorkItemId())],3)
printHtmlPart(19)
createTagBody(3, {->
expressionOut.print(it.getWorkItemId())
})
invokeTag('link','g',71,['action':("workItemInfo"),'controller':("workItem"),'id':(it.getWorkItemId())],3)
printHtmlPart(20)
}
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',72,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1398850858000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
