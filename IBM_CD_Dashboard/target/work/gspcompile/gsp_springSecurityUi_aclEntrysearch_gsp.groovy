import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='spring-security-ui', version='1.0-RC1')
class gsp_springSecurityUi_aclEntrysearch_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/spring-security-ui-1.0-RC1/grails-app/views/aclEntry/search.gsp" }
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
invokeTag('message','g',5,['code':("spring.security.ui.aclEntry.search")],-1)
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
invokeTag('message','g',19,['code':("aclEntry.aclObjectIdentity.label"),'default':("AclObjectIdentity")],-1)
printHtmlPart(7)
invokeTag('textField','g',20,['name':("aclObjectIdentity"),'size':("50"),'maxlength':("255"),'value':(aclObjectIdentity)],-1)
printHtmlPart(8)
invokeTag('message','g',23,['code':("aclEntry.aceOrder.label"),'default':("Ace Order")],-1)
printHtmlPart(7)
invokeTag('textField','g',24,['name':("aceOrder"),'size':("50"),'maxlength':("255"),'value':(aceOrder)],-1)
printHtmlPart(8)
invokeTag('message','g',27,['code':("aclEntry.sid.label"),'default':("SID")],-1)
printHtmlPart(9)
invokeTag('select','g',30,['name':("sid"),'from':(sids),'optionKey':("id"),'optionValue':("sid"),'value':(sid),'noSelection':(['null': 'All'])],-1)
printHtmlPart(10)
invokeTag('message','g',34,['code':("aclEntry.mask.label"),'default':("Mask")],-1)
printHtmlPart(7)
invokeTag('textField','g',35,['name':("mask"),'size':("50"),'maxlength':("255"),'value':(mask)],-1)
printHtmlPart(11)
invokeTag('message','g',39,['code':("spring.security.ui.search.true")],-1)
printHtmlPart(12)
invokeTag('message','g',40,['code':("spring.security.ui.search.false")],-1)
printHtmlPart(12)
invokeTag('message','g',41,['code':("spring.security.ui.search.either")],-1)
printHtmlPart(8)
invokeTag('message','g',44,['code':("aclEntry.granting.label"),'default':("Granting")],-1)
printHtmlPart(13)
createTagBody(4, {->
printHtmlPart(14)
out.print(it.radio)
printHtmlPart(15)
})
invokeTag('radioGroup','g',47,['name':("granting"),'labels':(['','','']),'values':([1,-1,0]),'value':(granting)],4)
printHtmlPart(16)
invokeTag('message','g',50,['code':("aclEntry.auditSuccess.label"),'default':("Audit Success")],-1)
printHtmlPart(13)
createTagBody(4, {->
printHtmlPart(14)
out.print(it.radio)
printHtmlPart(15)
})
invokeTag('radioGroup','g',53,['name':("auditSuccess"),'labels':(['','','']),'values':([1,-1,0]),'value':(auditSuccess)],4)
printHtmlPart(16)
invokeTag('message','g',56,['code':("aclEntry.auditFailure.label"),'default':("Audit Failure")],-1)
printHtmlPart(13)
createTagBody(4, {->
printHtmlPart(14)
out.print(it.radio)
printHtmlPart(15)
})
invokeTag('radioGroup','g',59,['name':("auditFailure"),'labels':(['','','']),'values':([1,-1,0]),'value':(auditFailure)],4)
printHtmlPart(17)
invokeTag('submitButton','s2ui',62,['elementId':("search"),'form':("aclEntrySearchForm"),'messageCode':("spring.security.ui.search")],-1)
printHtmlPart(18)
})
invokeTag('form','g',66,['action':("aclEntrySearch"),'name':("aclEntrySearchForm")],3)
printHtmlPart(5)
})
invokeTag('form','s2ui',68,['width':("100%"),'height':("310"),'elementId':("formContainer"),'titleCode':("spring.security.ui.aclEntry.search")],2)
printHtmlPart(5)
if(true && (searched)) {
printHtmlPart(3)

def queryParams = [aclObjectIdentity: aclObjectIdentity, aceOrder: aceOrder, sid: sid, mask: mask, granting: granting, auditSuccess: auditSuccess, auditFailure: auditFailure]

printHtmlPart(19)
invokeTag('sortableColumn','g',80,['property':("id"),'title':(message(code: 'aclEntry.id.label', default: 'ID'))],-1)
printHtmlPart(20)
invokeTag('sortableColumn','g',81,['property':("aclObjectIdentity.id"),'title':(message(code: 'aclEntry.aclObjectIdentity.label', default: 'AclObjectIdentity'))],-1)
printHtmlPart(20)
invokeTag('sortableColumn','g',82,['property':("aceOrder"),'title':(message(code: 'aclEntry.aceOrder.label', default: 'Ace Order'))],-1)
printHtmlPart(20)
invokeTag('sortableColumn','g',83,['property':("sid.id"),'title':(message(code: 'aclEntry.sid.label', default: 'SID'))],-1)
printHtmlPart(20)
invokeTag('sortableColumn','g',84,['property':("mask"),'title':(message(code: 'aclEntry.mask.label', default: 'Mask'))],-1)
printHtmlPart(20)
invokeTag('sortableColumn','g',85,['property':("granting"),'title':(message(code: 'aclEntry.granting.label', default: 'Granting'))],-1)
printHtmlPart(20)
invokeTag('sortableColumn','g',86,['property':("auditSuccess"),'title':(message(code: 'aclEntry.auditSuccess.label', default: 'Audit Success'))],-1)
printHtmlPart(20)
invokeTag('sortableColumn','g',87,['property':("auditFailure"),'title':(message(code: 'aclEntry.auditFailure.label', default: 'Audit Failure'))],-1)
printHtmlPart(21)
loop:{
int i = 0
for( entry in (results) ) {
printHtmlPart(22)
expressionOut.print((i % 2) == 0 ? 'odd' : 'even')
printHtmlPart(23)
createTagBody(4, {->
expressionOut.print(entry.id)
})
invokeTag('link','g',94,['action':("edit"),'id':(entry.id)],4)
printHtmlPart(24)
createTagBody(4, {->
expressionOut.print(entry.aclObjectIdentity.id)
})
invokeTag('link','g',95,['action':("edit"),'controller':("aclObjectIdentity"),'id':(entry.aclObjectIdentity.id)],4)
printHtmlPart(24)
expressionOut.print(entry.aceOrder)
printHtmlPart(24)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: entry.sid, field: "sid"))
})
invokeTag('link','g',97,['action':("edit"),'controller':("aclSid"),'id':(entry.sid.id)],4)
printHtmlPart(24)
expressionOut.print(permissionFactory.buildFromMask(entry.mask))
printHtmlPart(24)
invokeTag('formatBoolean','g',99,['boolean':(entry.granting)],-1)
printHtmlPart(24)
invokeTag('formatBoolean','g',100,['boolean':(entry.auditSuccess)],-1)
printHtmlPart(24)
invokeTag('formatBoolean','g',101,['boolean':(entry.auditFailure)],-1)
printHtmlPart(25)
i++
}
}
printHtmlPart(26)
invokeTag('paginate','g',109,['total':(totalCount),'params':(queryParams)],-1)
printHtmlPart(27)
invokeTag('paginationSummary','s2ui',113,['total':(totalCount)],-1)
printHtmlPart(28)
}
printHtmlPart(29)
invokeTag('initCheckboxes','s2ui',121,[:],-1)
printHtmlPart(30)
})
invokeTag('captureBody','sitemesh',124,[:],1)
printHtmlPart(31)
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
