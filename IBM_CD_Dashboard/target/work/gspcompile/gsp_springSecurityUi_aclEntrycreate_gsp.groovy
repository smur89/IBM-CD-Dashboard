import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='spring-security-ui', version='1.0-RC1')
class gsp_springSecurityUi_aclEntrycreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/spring-security-ui-1.0-RC1/grails-app/views/aclEntry/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("springSecurityUI")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'aclEntry.label', default: 'AclEntry'))],-1)
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
invokeTag('textFieldRow','s2ui',26,['name':("aclObjectIdentity.id"),'labelCode':("aclEntry.aclObjectIdentity.label"),'size':("50"),'bean':(aclEntry),'labelCodeDefault':("AclObjectIdentity"),'value':(aclEntry?.aclObjectIdentity?.id)],-1)
printHtmlPart(7)
invokeTag('textFieldRow','s2ui',30,['name':("aceOrder"),'labelCode':("aclEntry.aceOrder.label"),'size':("50"),'bean':(aclEntry),'labelCodeDefault':("Ace Order"),'value':(aclEntry?.aceOrder)],-1)
printHtmlPart(8)
invokeTag('message','g',34,['code':("aclEntry.sid.label"),'default':("SID")],-1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: aclEntry, field: 'sid', 'errors'))
printHtmlPart(10)
invokeTag('select','g',38,['name':("sid.id"),'from':(sids),'optionKey':("id"),'optionValue':("sid"),'value':(aclEntry?.sid?.id),'noSelection':(['null': ''])],-1)
printHtmlPart(11)
invokeTag('textFieldRow','s2ui',43,['name':("mask"),'labelCode':("aclEntry.mask.label"),'bean':(aclEntry),'size':("50"),'labelCodeDefault':("Mask"),'value':(aclEntry?.mask)],-1)
printHtmlPart(7)
invokeTag('checkboxRow','s2ui',46,['name':("granting"),'labelCode':("aclEntry.granting.label"),'bean':(aclEntry),'labelCodeDefault':("Granting"),'value':(aclEntry?.granting)],-1)
printHtmlPart(7)
invokeTag('checkboxRow','s2ui',49,['name':("auditSuccess"),'labelCode':("aclEntry.auditSuccess.label"),'bean':(aclEntry),'labelCodeDefault':("Audit Success"),'value':(aclEntry?.auditSuccess)],-1)
printHtmlPart(7)
invokeTag('checkboxRow','s2ui',52,['name':("auditFailure"),'labelCode':("aclEntry.auditFailure.label"),'bean':(aclEntry),'labelCodeDefault':("Audit Failure"),'value':(aclEntry?.auditFailure)],-1)
printHtmlPart(12)
invokeTag('submitButton','s2ui',56,['elementId':("create"),'form':("aclEntryCreateForm"),'messageCode':("default.button.create.label")],-1)
printHtmlPart(13)
})
invokeTag('form','g',64,['action':("save"),'name':("aclEntryCreateForm")],3)
printHtmlPart(5)
})
invokeTag('form','s2ui',66,['width':("100%"),'height':("310"),'elementId':("formContainer"),'titleCode':("default.create.label"),'titleCodeArgs':([entityName])],2)
printHtmlPart(14)
invokeTag('initCheckboxes','s2ui',71,[:],-1)
printHtmlPart(15)
})
invokeTag('captureBody','sitemesh',74,[:],1)
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
