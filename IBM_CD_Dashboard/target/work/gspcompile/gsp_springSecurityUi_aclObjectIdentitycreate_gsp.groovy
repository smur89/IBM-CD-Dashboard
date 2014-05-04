import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='spring-security-ui', version='1.0-RC1')
class gsp_springSecurityUi_aclObjectIdentitycreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/spring-security-ui-1.0-RC1/grails-app/views/aclObjectIdentity/create.gsp" }
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
invokeTag('message','g',26,['code':("aclObjectIdentity.aclClass.label"),'default':("AclClass")],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: aclObjectIdentity, field: 'aclClass', 'errors'))
printHtmlPart(8)
invokeTag('select','g',30,['name':("aclClass.id"),'from':(classes),'optionKey':("id"),'optionValue':("className"),'value':(aclObjectIdentity?.aclClass?.id),'noSelection':(['null': ''])],-1)
printHtmlPart(9)
expressionOut.print(fieldError(bean: aclObjectIdentity, field: 'aclClass'))
printHtmlPart(10)
invokeTag('textFieldRow','s2ui',37,['name':("objectId"),'labelCode':("aclObjectIdentity.objectId.label"),'size':("50"),'bean':(aclObjectIdentity),'labelCodeDefault':("Object ID"),'value':(aclObjectIdentity?.objectId)],-1)
printHtmlPart(11)
invokeTag('message','g',41,['code':("aclObjectIdentity.owner.label"),'default':("Owner")],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: aclObjectIdentity, field: 'owner', 'errors'))
printHtmlPart(8)
invokeTag('select','g',45,['name':("owner.id"),'from':(sids),'optionKey':("id"),'optionValue':("sid"),'value':(aclObjectIdentity?.owner?.id),'noSelection':(['null': ''])],-1)
printHtmlPart(9)
expressionOut.print(fieldError(bean: aclObjectIdentity, field: 'owner'))
printHtmlPart(10)
invokeTag('textFieldRow','s2ui',52,['name':("parent.id"),'labelCode':("aclObjectIdentity.parent.label"),'size':("50"),'bean':(aclObjectIdentity),'labelCodeDefault':("Parent"),'value':(aclObjectIdentity?.parent?.id)],-1)
printHtmlPart(12)
invokeTag('checkboxRow','s2ui',55,['name':("entriesInheriting"),'labelCode':("aclObjectIdentity.entriesInheriting.label"),'bean':(aclObjectIdentity),'labelCodeDefault':("Entries Inheriting"),'value':(aclObjectIdentity?.entriesInheriting)],-1)
printHtmlPart(13)
invokeTag('submitButton','s2ui',61,['elementId':("create"),'form':("aclObjectIdentityCreateForm"),'messageCode':("default.button.create.label")],-1)
printHtmlPart(14)
})
invokeTag('form','g',69,['action':("save"),'name':("aclObjectIdentityCreateForm")],3)
printHtmlPart(5)
})
invokeTag('form','s2ui',71,['width':("100%"),'height':("275"),'elementId':("formContainer"),'titleCode':("default.create.label"),'titleCodeArgs':([entityName])],2)
printHtmlPart(15)
invokeTag('initCheckboxes','s2ui',76,[:],-1)
printHtmlPart(16)
})
invokeTag('captureBody','sitemesh',79,[:],1)
printHtmlPart(17)
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
