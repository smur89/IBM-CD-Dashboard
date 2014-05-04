import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='spring-security-ui', version='1.0-RC1')
class gsp_springSecurityUi_aclObjectIdentitysearch_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/spring-security-ui-1.0-RC1/grails-app/views/aclObjectIdentity/search.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("springSecurityUI")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',5,['code':("spring.security.ui.aclObjectIdentity.search")],-1)
})
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
createTagBody(3, {->
printHtmlPart(6)
invokeTag('message','g',22,['code':("aclObjectIdentity.aclClass.label"),'default':("AclClass")],-1)
printHtmlPart(7)
invokeTag('select','g',25,['name':("aclClass"),'from':(classes),'optionKey':("id"),'optionValue':("className"),'value':(aclClass),'noSelection':(['null': 'All'])],-1)
printHtmlPart(8)
invokeTag('message','g',29,['code':("aclObjectIdentity.objectId.label"),'default':("Object ID")],-1)
printHtmlPart(9)
invokeTag('textField','g',30,['name':("objectId"),'size':("50"),'maxlength':("255"),'value':(objectId)],-1)
printHtmlPart(10)
invokeTag('message','g',33,['code':("aclObjectIdentity.owner.label"),'default':("Owner")],-1)
printHtmlPart(7)
invokeTag('select','g',36,['name':("ownerSid"),'from':(sids),'optionKey':("id"),'optionValue':("sid"),'value':(ownerSid),'noSelection':(['null': 'All'])],-1)
printHtmlPart(8)
invokeTag('message','g',40,['code':("aclObjectIdentity.parent.label"),'default':("Parent")],-1)
printHtmlPart(9)
invokeTag('textField','g',41,['name':("parent"),'size':("50"),'maxlength':("255"),'value':(parent)],-1)
printHtmlPart(11)
invokeTag('message','g',45,['code':("spring.security.ui.search.true")],-1)
printHtmlPart(12)
invokeTag('message','g',46,['code':("spring.security.ui.search.false")],-1)
printHtmlPart(12)
invokeTag('message','g',47,['code':("spring.security.ui.search.either")],-1)
printHtmlPart(10)
invokeTag('message','g',50,['code':("aclObjectIdentity.entriesInheriting.label"),'default':("Entries Inheriting")],-1)
printHtmlPart(13)
createTagBody(4, {->
printHtmlPart(14)
out.print(it.radio)
printHtmlPart(15)
})
invokeTag('radioGroup','g',53,['name':("entriesInheriting"),'labels':(['','','']),'values':([1,-1,0]),'value':(entriesInheriting)],4)
printHtmlPart(16)
invokeTag('submitButton','s2ui',56,['elementId':("search"),'form':("aclObjectIdentitySearchForm"),'messageCode':("spring.security.ui.search")],-1)
printHtmlPart(17)
})
invokeTag('form','g',60,['action':("aclObjectIdentitySearch"),'name':("aclObjectIdentitySearchForm")],3)
printHtmlPart(5)
})
invokeTag('form','s2ui',62,['width':("100%"),'height':("275"),'elementId':("formContainer"),'titleCode':("spring.security.ui.aclObjectIdentity.search")],2)
printHtmlPart(5)
if(true && (searched)) {
printHtmlPart(3)

def queryParams = [aclClass: aclClass, objectId: objectId, ownerSid: ownerSid, parent: parent, entriesInheriting: entriesInheriting]

printHtmlPart(18)
invokeTag('sortableColumn','g',74,['property':("id"),'title':(message(code: 'aclObjectIdentity.id.label', default: 'ID'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',75,['property':("aclClass.className"),'title':(message(code: 'aclObjectIdentity.aclClass.label', default: 'AclClass'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',76,['property':("objectId"),'title':(message(code: 'aclObjectIdentity.objectId.label', default: 'Object ID'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',77,['property':("entriesInheriting"),'title':(message(code: 'aclObjectIdentity.entriesInheriting.label', default: 'Entries Inheriting'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',78,['property':("owner.sid"),'title':(message(code: 'aclObjectIdentity.owner.label', default: 'Owner'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',79,['property':("parent.id"),'title':(message(code: 'aclObjectIdentity.parent.label', default: 'Parent'))],-1)
printHtmlPart(20)
loop:{
int i = 0
for( oid in (results) ) {
printHtmlPart(21)
expressionOut.print((i % 2) == 0 ? 'odd' : 'even')
printHtmlPart(22)
createTagBody(4, {->
expressionOut.print(oid.id)
})
invokeTag('link','g',86,['action':("edit"),'id':(oid.id)],4)
printHtmlPart(23)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: oid.aclClass, field: "className"))
})
invokeTag('link','g',87,['action':("edit"),'controller':("aclClass"),'id':(oid.aclClass.id)],4)
printHtmlPart(23)
expressionOut.print(fieldValue(bean: oid, field: "objectId"))
printHtmlPart(23)
invokeTag('formatBoolean','g',89,['boolean':(oid.entriesInheriting)],-1)
printHtmlPart(24)
if(true && (oid.owner && oid.owner.principal)) {
printHtmlPart(25)
createTagBody(5, {->
expressionOut.print(fieldValue(bean: oid.owner, field: "sid"))
})
invokeTag('link','g',92,['action':("edit"),'controller':("user"),'params':([username: oid.owner.sid])],5)
printHtmlPart(19)
}
printHtmlPart(19)
if(true && (oid.owner && !oid.owner.principal)) {
printHtmlPart(25)
createTagBody(5, {->
expressionOut.print(fieldValue(bean: oid.owner, field: "sid"))
})
invokeTag('link','g',95,['action':("edit"),'controller':("role"),'params':([name: oid.owner.sid])],5)
printHtmlPart(19)
}
printHtmlPart(26)
if(true && (oid.parent)) {
printHtmlPart(25)
createTagBody(5, {->
expressionOut.print(oid.parent.id)
})
invokeTag('link','g',101,['action':("edit"),'id':(oid.parent.id)],5)
printHtmlPart(19)
}
printHtmlPart(27)
i++
}
}
printHtmlPart(28)
invokeTag('paginate','g',112,['total':(totalCount),'params':(queryParams)],-1)
printHtmlPart(29)
invokeTag('paginationSummary','s2ui',116,['total':(totalCount)],-1)
printHtmlPart(30)
}
printHtmlPart(31)
invokeTag('initCheckboxes','s2ui',124,[:],-1)
printHtmlPart(32)
})
invokeTag('captureBody','sitemesh',127,[:],1)
printHtmlPart(33)
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
