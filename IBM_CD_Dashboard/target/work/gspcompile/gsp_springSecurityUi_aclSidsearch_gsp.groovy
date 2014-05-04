import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='spring-security-ui', version='1.0-RC1')
class gsp_springSecurityUi_aclSidsearch_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/spring-security-ui-1.0-RC1/grails-app/views/aclSid/search.gsp" }
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
invokeTag('message','g',5,['code':("spring.security.ui.aclSid.search")],-1)
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
invokeTag('message','g',23,['code':("aclSid.sid.label"),'default':("SID")],-1)
printHtmlPart(7)
invokeTag('textField','g',24,['name':("sid"),'size':("50"),'maxlength':("255"),'autocomplete':("off"),'value':(sid)],-1)
printHtmlPart(8)
invokeTag('message','g',28,['code':("spring.security.ui.search.true")],-1)
printHtmlPart(9)
invokeTag('message','g',29,['code':("spring.security.ui.search.false")],-1)
printHtmlPart(9)
invokeTag('message','g',30,['code':("spring.security.ui.search.either")],-1)
printHtmlPart(10)
invokeTag('message','g',33,['code':("aclSid.principal.label"),'default':("Principal")],-1)
printHtmlPart(11)
createTagBody(4, {->
printHtmlPart(12)
out.print(it.radio)
printHtmlPart(13)
})
invokeTag('radioGroup','g',36,['name':("principal"),'labels':(['','','']),'values':([1,-1,0]),'value':(principal)],4)
printHtmlPart(14)
invokeTag('submitButton','s2ui',40,['elementId':("search"),'form':("aclSidSearchForm"),'messageCode':("spring.security.ui.search")],-1)
printHtmlPart(15)
})
invokeTag('form','g',44,['action':("aclSidSearch"),'name':("aclSidSearchForm")],3)
printHtmlPart(5)
})
invokeTag('form','s2ui',46,['width':("100%"),'height':("225"),'elementId':("formContainer"),'titleCode':("spring.security.ui.aclSid.search")],2)
printHtmlPart(5)
if(true && (searched)) {
printHtmlPart(3)

def queryParams = [sid: sid, principal: principal]

printHtmlPart(16)
invokeTag('sortableColumn','g',58,['property':("sid"),'title':(message(code: 'aclSid.sid.label', default: 'SID')),'params':(queryParams)],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',59,['property':("principal"),'title':(message(code: 'aclSid.principal.label', default: 'Principal')),'params':(queryParams)],-1)
printHtmlPart(18)
loop:{
int i = 0
for( aclSid in (results) ) {
printHtmlPart(19)
expressionOut.print((i % 2) == 0 ? 'odd' : 'even')
printHtmlPart(20)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: aclSid, field: "sid"))
})
invokeTag('link','g',66,['action':("edit"),'id':(aclSid.id)],4)
printHtmlPart(21)
invokeTag('formatBoolean','g',67,['boolean':(aclSid.principal)],-1)
printHtmlPart(22)
i++
}
}
printHtmlPart(23)
invokeTag('paginate','g',75,['total':(totalCount),'params':(queryParams)],-1)
printHtmlPart(24)
invokeTag('paginationSummary','s2ui',79,['total':(totalCount)],-1)
printHtmlPart(25)
}
printHtmlPart(26)
expressionOut.print(createLink(action: 'ajaxAclSidSearch'))
printHtmlPart(27)
invokeTag('initCheckboxes','s2ui',95,[:],-1)
printHtmlPart(28)
})
invokeTag('captureBody','sitemesh',99,[:],1)
printHtmlPart(29)
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
