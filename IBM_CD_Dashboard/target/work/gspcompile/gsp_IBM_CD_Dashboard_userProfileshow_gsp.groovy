import ibm_cd_dashboard.Team
import  ibm_cd_dashboard.UserProfile
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_IBM_CD_Dashboard_userProfileshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/userProfile/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("application")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'userProfile.label', default: 'UserProfile'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',12,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
createTagBody(3, {->
invokeTag('message','g',17,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',17,['class':("list"),'action':("index")],3)
printHtmlPart(7)
})
invokeTag('ifAllGranted','sec',20,['roles':("ROLE_ADMIN")],2)
printHtmlPart(8)
invokeTag('message','g',22,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (userProfileInstance?.user)) {
printHtmlPart(13)
invokeTag('message','g',31,['code':("userProfile.user.label"),'default':("User")],-1)
printHtmlPart(14)
createTagBody(3, {->
expressionOut.print(userProfileInstance?.user?.encodeAsHTML())
})
invokeTag('link','g',33,['controller':("user"),'action':("show"),'id':(userProfileInstance?.user?.id)],3)
printHtmlPart(15)
}
printHtmlPart(16)
for( project in (userProjectList) ) {
printHtmlPart(17)
expressionOut.print(project)
printHtmlPart(18)
}
printHtmlPart(19)
createTagBody(2, {->
printHtmlPart(20)
createTagBody(3, {->
invokeTag('message','g',45,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',45,['class':("edit"),'action':("edit"),'resource':(userProfileInstance)],3)
printHtmlPart(21)
invokeTag('actionSubmit','g',48,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(22)
})
invokeTag('form','g',50,['url':([resource: userProfileInstance, action: 'delete']),'method':("DELETE")],2)
printHtmlPart(23)
})
invokeTag('captureBody','sitemesh',52,[:],1)
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
