import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='spring-security-ui', version='1.0-RC1')
class gsp_springSecurityUi_aclClassedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/spring-security-ui-1.0-RC1/grails-app/views/aclClass/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("springSecurityUI")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'aclClass.label', default: 'AclClass'))],-1)
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
invokeTag('hiddenField','g',17,['name':("id"),'value':(aclClass?.id)],-1)
printHtmlPart(6)
invokeTag('hiddenField','g',18,['name':("version"),'value':(aclClass?.version)],-1)
printHtmlPart(7)
invokeTag('textFieldRow','s2ui',26,['name':("className"),'labelCode':("aclClass.className.label"),'bean':(aclClass),'labelCodeDefault':("Class Name"),'size':("60"),'value':(aclClass?.className)],-1)
printHtmlPart(8)
createClosureForHtmlPart(9, 4)
invokeTag('link','g',30,['action':("aclObjectIdentitySearch"),'controller':("aclObjectIdentity"),'params':([aclClass: aclClass.id])],4)
printHtmlPart(10)
createClosureForHtmlPart(11, 4)
invokeTag('link','g',35,['action':("aclEntrySearch"),'controller':("aclEntry"),'params':([aclClass: aclClass.id])],4)
printHtmlPart(12)
invokeTag('submitButton','s2ui',44,['elementId':("update"),'form':("aclClassEditForm"),'messageCode':("default.button.update.label")],-1)
printHtmlPart(13)
if(true && (aclClass)) {
printHtmlPart(6)
invokeTag('deleteButton','s2ui',47,[:],-1)
printHtmlPart(6)
}
printHtmlPart(14)
})
invokeTag('form','g',52,['action':("update"),'name':("aclClassEditForm")],3)
printHtmlPart(5)
})
invokeTag('form','s2ui',54,['width':("100%"),'height':("225"),'elementId':("formContainer"),'titleCode':("default.edit.label"),'titleCodeArgs':([entityName])],2)
printHtmlPart(5)
if(true && (aclClass)) {
printHtmlPart(1)
invokeTag('deleteButtonForm','s2ui',57,['instanceId':(aclClass.id)],-1)
printHtmlPart(1)
}
printHtmlPart(15)
})
invokeTag('captureBody','sitemesh',62,[:],1)
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
