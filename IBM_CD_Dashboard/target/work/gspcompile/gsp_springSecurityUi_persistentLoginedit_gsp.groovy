import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='spring-security-ui', version='1.0-RC1')
class gsp_springSecurityUi_persistentLoginedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/spring-security-ui-1.0-RC1/grails-app/views/persistentLogin/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("springSecurityUI")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'persistentLogin.label', default: 'PersistentLogin'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',6,['code':("default.edit.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
createTagBody(3, {->
printHtmlPart(6)
invokeTag('hiddenField','g',17,['name':("id"),'value':(persistentLogin?.id)],-1)
printHtmlPart(6)
invokeTag('hiddenField','g',18,['name':("version"),'value':(persistentLogin?.version)],-1)
printHtmlPart(7)
expressionOut.print(message(code: 'persistentLogin.series.label', default: 'Series'))
printHtmlPart(8)
expressionOut.print(persistentLogin.id)
printHtmlPart(9)
expressionOut.print(message(code: 'persistentLogin.username.label', default: 'Username'))
printHtmlPart(8)
expressionOut.print(persistentLogin.username)
printHtmlPart(10)
invokeTag('textFieldRow','s2ui',42,['name':("token"),'labelCode':("persistentLogin.token.label"),'size':("50"),'bean':(persistentLogin),'labelCodeDefault':("Token"),'value':(persistentLogin?.token)],-1)
printHtmlPart(11)
invokeTag('dateFieldRow','s2ui',46,['name':("lastUsed"),'labelCode':("persistentLogin.lastUsed.label"),'size':("50"),'bean':(persistentLogin),'labelCodeDefault':("Last Used"),'value':(persistentLogin?.lastUsed)],-1)
printHtmlPart(12)
invokeTag('submitButton','s2ui',53,['elementId':("update"),'form':("persistentLoginEditForm"),'messageCode':("default.button.update.label")],-1)
printHtmlPart(13)
if(true && (persistentLogin)) {
printHtmlPart(6)
invokeTag('deleteButton','s2ui',56,[:],-1)
printHtmlPart(6)
}
printHtmlPart(14)
})
invokeTag('form','g',61,['action':("update"),'name':("persistentLoginEditForm")],3)
printHtmlPart(5)
})
invokeTag('form','s2ui',63,['width':("100%"),'height':("275"),'elementId':("formContainer"),'titleCode':("default.edit.label"),'titleCodeArgs':([entityName])],2)
printHtmlPart(5)
if(true && (persistentLogin)) {
printHtmlPart(1)
invokeTag('deleteButtonForm','s2ui',66,['instanceId':(persistentLogin.id)],-1)
printHtmlPart(1)
}
printHtmlPart(15)
})
invokeTag('captureBody','sitemesh',71,[:],1)
printHtmlPart(16)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1384194130000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
