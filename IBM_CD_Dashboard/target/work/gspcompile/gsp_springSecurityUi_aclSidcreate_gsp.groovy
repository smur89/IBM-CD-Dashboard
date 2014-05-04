import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='spring-security-ui', version='1.0-RC1')
class gsp_springSecurityUi_aclSidcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/spring-security-ui-1.0-RC1/grails-app/views/aclSid/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("springSecurityUI")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'aclSid.label', default: 'AclSid'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',6,['code':("default.create.label"),'args':([entityName])],-1)
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
invokeTag('textFieldRow','s2ui',25,['name':("sid"),'labelCode':("aclSid.sid.label"),'bean':(aclSid),'size':("50"),'labelCodeDefault':("SID"),'value':(aclSid?.sid)],-1)
printHtmlPart(7)
invokeTag('checkboxRow','s2ui',28,['name':("principal"),'labelCode':("aclSid.principal.label"),'bean':(aclSid),'labelCodeDefault':("Principal"),'value':(aclSid?.principal)],-1)
printHtmlPart(8)
invokeTag('submitButton','s2ui',34,['elementId':("create"),'form':("aclSidCreateForm"),'messageCode':("default.button.create.label")],-1)
printHtmlPart(9)
})
invokeTag('form','g',42,['action':("save"),'name':("aclSidCreateForm")],3)
printHtmlPart(5)
})
invokeTag('form','s2ui',44,['width':("100%"),'height':("225"),'elementId':("formContainer"),'titleCode':("default.create.label"),'titleCodeArgs':([entityName])],2)
printHtmlPart(10)
invokeTag('initCheckboxes','s2ui',53,[:],-1)
printHtmlPart(11)
})
invokeTag('captureBody','sitemesh',56,[:],1)
printHtmlPart(12)
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
