import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='spring-security-ui', version='1.0-RC1')
class gsp_springSecurityUi_aclObjectIdentityedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/spring-security-ui-1.0-RC1/grails-app/views/aclObjectIdentity/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("springSecurityUI")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'aclObjectIdentity.label', default: 'AclObjectIdentity'))],-1)
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
invokeTag('hiddenField','g',17,['name':("id"),'value':(aclObjectIdentity?.id)],-1)
printHtmlPart(6)
invokeTag('hiddenField','g',18,['name':("version"),'value':(aclObjectIdentity?.version)],-1)
printHtmlPart(7)
invokeTag('message','g',28,['code':("aclObjectIdentity.aclClass.label"),'default':("AclClass")],-1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: aclObjectIdentity, field: 'aclClass', 'errors'))
printHtmlPart(9)
invokeTag('select','g',32,['name':("aclClass.id"),'from':(classes),'optionKey':("id"),'optionValue':("className"),'value':(aclObjectIdentity?.aclClass?.id)],-1)
printHtmlPart(10)
expressionOut.print(fieldError(bean: aclObjectIdentity, field: 'aclClass'))
printHtmlPart(11)
invokeTag('textFieldRow','s2ui',39,['name':("objectId"),'labelCode':("aclObjectIdentity.objectId.label"),'size':("50"),'bean':(aclObjectIdentity),'labelCodeDefault':("Object ID"),'value':(aclObjectIdentity?.objectId)],-1)
printHtmlPart(12)
invokeTag('message','g',43,['code':("aclObjectIdentity.owner.label"),'default':("Owner")],-1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: aclObjectIdentity, field: 'owner', 'errors'))
printHtmlPart(9)
invokeTag('select','g',47,['name':("owner.id"),'from':(sids),'optionKey':("id"),'optionValue':("sid"),'value':(aclObjectIdentity?.owner?.id)],-1)
printHtmlPart(11)
invokeTag('textFieldRow','s2ui',53,['name':("parent.id"),'labelCode':("aclObjectIdentity.parent.label"),'size':("50"),'bean':(aclObjectIdentity),'labelCodeDefault':("Parent"),'value':(aclObjectIdentity?.parent?.id)],-1)
printHtmlPart(13)
invokeTag('checkboxRow','s2ui',56,['name':("entriesInheriting"),'labelCode':("aclObjectIdentity.entriesInheriting.label"),'bean':(aclObjectIdentity),'labelCodeDefault':("Entries Inheriting"),'value':(aclObjectIdentity?.entriesInheriting)],-1)
printHtmlPart(14)
createClosureForHtmlPart(15, 4)
invokeTag('link','g',60,['action':("aclEntrySearch"),'controller':("aclEntry"),'params':([aclObjectIdentity: aclObjectIdentity.id])],4)
printHtmlPart(16)
invokeTag('submitButton','s2ui',69,['elementId':("update"),'form':("aclObjectIdentityEditForm"),'messageCode':("default.button.update.label")],-1)
printHtmlPart(17)
if(true && (aclObjectIdentity)) {
printHtmlPart(6)
invokeTag('deleteButton','s2ui',72,[:],-1)
printHtmlPart(6)
}
printHtmlPart(18)
})
invokeTag('form','g',77,['action':("update"),'name':("aclObjectIdentityEditForm")],3)
printHtmlPart(5)
})
invokeTag('form','s2ui',79,['width':("100%"),'height':("310"),'elementId':("formContainer"),'titleCode':("default.edit.label"),'titleCodeArgs':([entityName])],2)
printHtmlPart(5)
if(true && (aclObjectIdentity)) {
printHtmlPart(1)
invokeTag('deleteButtonForm','s2ui',82,['instanceId':(aclObjectIdentity.id)],-1)
printHtmlPart(1)
}
printHtmlPart(19)
invokeTag('initCheckboxes','s2ui',90,[:],-1)
printHtmlPart(20)
})
invokeTag('captureBody','sitemesh',94,[:],1)
printHtmlPart(21)
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
