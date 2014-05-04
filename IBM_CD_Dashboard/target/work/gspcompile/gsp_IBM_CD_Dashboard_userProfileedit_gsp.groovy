import ibm_cd_dashboard.UserProfile
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_IBM_CD_Dashboard_userProfileedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/userProfile/edit.gsp" }
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
invokeTag('message','g',7,['code':("default.edit.label"),'args':([entityName])],-1)
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
invokeTag('message','g',22,['code':("default.edit.label"),'args':([entityName])],-1)
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(14)
expressionOut.print(error.field)
printHtmlPart(15)
}
printHtmlPart(16)
invokeTag('message','g',30,['error':(error)],-1)
printHtmlPart(17)
})
invokeTag('eachError','g',31,['bean':(userProfileInstance),'var':("error")],3)
printHtmlPart(18)
})
invokeTag('hasErrors','g',33,['bean':(userProfileInstance)],2)
printHtmlPart(19)
createTagBody(2, {->
printHtmlPart(20)
invokeTag('hiddenField','g',36,['name':("version"),'value':(userProfileInstance?.version)],-1)
printHtmlPart(21)
invokeTag('render','g',38,['template':("form")],-1)
printHtmlPart(22)
invokeTag('actionSubmit','g',42,['class':("save"),'action':("updateTwo"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(23)
})
invokeTag('form','g',44,['url':([resource: userProfileInstance, action: 'update']),'method':("PUT")],2)
printHtmlPart(24)
})
invokeTag('captureBody','sitemesh',46,[:],1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1395945884000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
