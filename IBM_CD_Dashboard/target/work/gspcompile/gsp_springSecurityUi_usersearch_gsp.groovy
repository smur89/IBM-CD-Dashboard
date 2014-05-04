import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='spring-security-ui', version='1.0-RC1')
class gsp_springSecurityUi_usersearch_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/spring-security-ui-1.0-RC1/grails-app/views/user/search.gsp" }
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
invokeTag('message','g',5,['code':("spring.security.ui.user.search")],-1)
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
invokeTag('message','g',23,['code':("user.username.label"),'default':("Username")],-1)
printHtmlPart(7)
invokeTag('textField','g',24,['name':("username"),'size':("50"),'maxlength':("255"),'autocomplete':("off"),'value':(username)],-1)
printHtmlPart(8)
invokeTag('message','g',28,['code':("spring.security.ui.search.true")],-1)
printHtmlPart(9)
invokeTag('message','g',29,['code':("spring.security.ui.search.false")],-1)
printHtmlPart(9)
invokeTag('message','g',30,['code':("spring.security.ui.search.either")],-1)
printHtmlPart(10)
invokeTag('message','g',33,['code':("user.enabled.label"),'default':("Enabled")],-1)
printHtmlPart(11)
createTagBody(4, {->
printHtmlPart(12)
out.print(it.radio)
printHtmlPart(13)
})
invokeTag('radioGroup','g',36,['name':("enabled"),'labels':(['','','']),'values':([1,-1,0]),'value':(enabled)],4)
printHtmlPart(14)
invokeTag('message','g',39,['code':("user.accountExpired.label"),'default':("Account Expired")],-1)
printHtmlPart(11)
createTagBody(4, {->
printHtmlPart(12)
out.print(it.radio)
printHtmlPart(13)
})
invokeTag('radioGroup','g',42,['name':("accountExpired"),'labels':(['','','']),'values':([1,-1,0]),'value':(accountExpired)],4)
printHtmlPart(14)
invokeTag('message','g',45,['code':("user.accountLocked.label"),'default':("Account Locked")],-1)
printHtmlPart(11)
createTagBody(4, {->
printHtmlPart(12)
out.print(it.radio)
printHtmlPart(13)
})
invokeTag('radioGroup','g',48,['name':("accountLocked"),'labels':(['','','']),'values':([1,-1,0]),'value':(accountLocked)],4)
printHtmlPart(14)
invokeTag('message','g',51,['code':("user.passwordExpired.label"),'default':("Password Expired")],-1)
printHtmlPart(11)
createTagBody(4, {->
printHtmlPart(12)
out.print(it.radio)
printHtmlPart(13)
})
invokeTag('radioGroup','g',54,['name':("passwordExpired"),'labels':(['','','']),'values':([1,-1,0]),'value':(passwordExpired)],4)
printHtmlPart(15)
invokeTag('submitButton','s2ui',58,['elementId':("search"),'form':("userSearchForm"),'messageCode':("spring.security.ui.search")],-1)
printHtmlPart(16)
})
invokeTag('form','g',62,['action':("userSearch"),'name':("userSearchForm")],3)
printHtmlPart(5)
})
invokeTag('form','s2ui',64,['width':("100%"),'height':("375"),'elementId':("formContainer"),'titleCode':("spring.security.ui.user.search")],2)
printHtmlPart(5)
if(true && (searched)) {
printHtmlPart(3)

def queryParams = [username: username, enabled: enabled, accountExpired: accountExpired, accountLocked: accountLocked, passwordExpired: passwordExpired]

printHtmlPart(17)
invokeTag('sortableColumn','g',76,['property':("username"),'title':(message(code: 'user.username.label', default: 'Username')),'params':(queryParams)],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',77,['property':("enabled"),'title':(message(code: 'user.enabled.label', default: 'Enabled')),'params':(queryParams)],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',78,['property':("accountExpired"),'title':(message(code: 'user.accountExpired.label', default: 'Account Expired')),'params':(queryParams)],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',79,['property':("accountLocked"),'title':(message(code: 'user.accountLocked.label', default: 'Account Locked')),'params':(queryParams)],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',80,['property':("passwordExpired"),'title':(message(code: 'user.passwordExpired.label', default: 'Password Expired')),'params':(queryParams)],-1)
printHtmlPart(19)
loop:{
int i = 0
for( user in (results) ) {
printHtmlPart(20)
expressionOut.print((i % 2) == 0 ? 'odd' : 'even')
printHtmlPart(21)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: user, field: "username"))
})
invokeTag('link','g',87,['action':("edit"),'id':(user.id)],4)
printHtmlPart(22)
invokeTag('formatBoolean','g',88,['boolean':(user.enabled)],-1)
printHtmlPart(22)
invokeTag('formatBoolean','g',89,['boolean':(user.accountExpired)],-1)
printHtmlPart(22)
invokeTag('formatBoolean','g',90,['boolean':(user.accountLocked)],-1)
printHtmlPart(22)
invokeTag('formatBoolean','g',91,['boolean':(user.passwordExpired)],-1)
printHtmlPart(23)
i++
}
}
printHtmlPart(24)
invokeTag('paginate','g',99,['total':(totalCount),'params':(queryParams)],-1)
printHtmlPart(25)
invokeTag('paginationSummary','s2ui',103,['total':(totalCount)],-1)
printHtmlPart(26)
}
printHtmlPart(27)
expressionOut.print(createLink(action: 'ajaxUserSearch'))
printHtmlPart(28)
invokeTag('initCheckboxes','s2ui',119,[:],-1)
printHtmlPart(29)
})
invokeTag('captureBody','sitemesh',123,[:],1)
printHtmlPart(30)
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
