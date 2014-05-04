import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='spring-security-ui', version='1.0-RC1')
class gsp_springSecurityUi_aclSidedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/spring-security-ui-1.0-RC1/grails-app/views/aclSid/edit.gsp" }
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
invokeTag('hiddenField','g',17,['name':("id"),'value':(aclSid?.id)],-1)
printHtmlPart(6)
invokeTag('hiddenField','g',18,['name':("version"),'value':(aclSid?.version)],-1)
printHtmlPart(7)
invokeTag('textFieldRow','s2ui',26,['name':("sid"),'labelCode':("aclSid.sid.label"),'bean':(aclSid),'labelCodeDefault':("SID"),'size':("50"),'value':(aclSid?.sid)],-1)
printHtmlPart(8)
invokeTag('checkboxRow','s2ui',29,['name':("principal"),'labelCode':("aclSid.principal.label"),'bean':(aclSid),'labelCodeDefault':("Principal"),'value':(aclSid?.principal)],-1)
printHtmlPart(9)
createClosureForHtmlPart(10, 4)
invokeTag('link','g',33,['action':("aclObjectIdentitySearch"),'controller':("aclObjectIdentity"),'params':([ownerSid: aclSid.id])],4)
printHtmlPart(11)
createClosureForHtmlPart(12, 4)
invokeTag('link','g',38,['action':("aclEntrySearch"),'controller':("aclEntry"),'params':([sid: aclSid.id])],4)
printHtmlPart(13)
invokeTag('submitButton','s2ui',47,['elementId':("update"),'form':("aclSidEditForm"),'messageCode':("default.button.update.label")],-1)
printHtmlPart(14)
if(true && (aclSid)) {
printHtmlPart(6)
invokeTag('deleteButton','s2ui',50,[:],-1)
printHtmlPart(6)
}
printHtmlPart(15)
})
invokeTag('form','g',55,['action':("update"),'name':("aclSidEditForm")],3)
printHtmlPart(5)
})
invokeTag('form','s2ui',57,['width':("100%"),'height':("275"),'elementId':("formContainer"),'titleCode':("default.edit.label"),'titleCodeArgs':([entityName])],2)
printHtmlPart(5)
if(true && (aclSid)) {
printHtmlPart(1)
invokeTag('deleteButtonForm','s2ui',60,['instanceId':(aclSid.id)],-1)
printHtmlPart(1)
}
printHtmlPart(16)
invokeTag('initCheckboxes','s2ui',68,[:],-1)
printHtmlPart(17)
})
invokeTag('captureBody','sitemesh',72,[:],1)
printHtmlPart(18)
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
