import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='spring-security-ui', version='1.0-RC1')
class gsp_springSecurityUi_persistentLoginsearch_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/spring-security-ui-1.0-RC1/grails-app/views/persistentLogin/search.gsp" }
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
invokeTag('message','g',5,['code':("spring.security.ui.persistentLogin.search")],-1)
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
invokeTag('message','g',22,['code':("persistentLogin.username.label"),'default':("Username")],-1)
printHtmlPart(7)
invokeTag('textField','g',23,['name':("username"),'size':("50"),'maxlength':("255"),'autocomplete':("off"),'value':(username)],-1)
printHtmlPart(8)
invokeTag('message','g',26,['code':("persistentLogin.token.label"),'default':("Token")],-1)
printHtmlPart(7)
invokeTag('textField','g',27,['name':("token"),'size':("50"),'maxlength':("255"),'autocomplete':("off"),'value':(token)],-1)
printHtmlPart(8)
invokeTag('message','g',30,['code':("persistentLogin.series.label"),'default':("Series")],-1)
printHtmlPart(7)
invokeTag('textField','g',31,['name':("series"),'size':("50"),'maxlength':("255"),'autocomplete':("off"),'value':(series)],-1)
printHtmlPart(9)
invokeTag('submitButton','s2ui',35,['elementId':("search"),'form':("persistentLoginSearchForm"),'messageCode':("spring.security.ui.search")],-1)
printHtmlPart(10)
})
invokeTag('form','g',39,['action':("persistentLoginSearch"),'name':("persistentLoginSearchForm")],3)
printHtmlPart(5)
})
invokeTag('form','s2ui',41,['width':("100%"),'height':("225"),'elementId':("formContainer"),'titleCode':("spring.security.ui.persistentLogin.search")],2)
printHtmlPart(5)
if(true && (searched)) {
printHtmlPart(3)

def queryParams = [username: username, token: token, series: series]

printHtmlPart(11)
invokeTag('sortableColumn','g',53,['property':("id"),'title':(message(code: 'persistentLogin.series.label', default: 'Series')),'params':(queryParams)],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',54,['property':("username"),'title':(message(code: 'persistentLogin.username.label', default: 'Username')),'params':(queryParams)],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',55,['property':("token"),'title':(message(code: 'persistentLogin.token.label', default: 'Token')),'params':(queryParams)],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',56,['property':("lastUsed"),'title':(message(code: 'persistentLogin.lastUsed.label', default: 'Last Used')),'params':(queryParams)],-1)
printHtmlPart(13)
loop:{
int i = 0
for( persistentLogin in (results) ) {
printHtmlPart(14)
expressionOut.print((i % 2) == 0 ? 'odd' : 'even')
printHtmlPart(15)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: persistentLogin, field: "id"))
})
invokeTag('link','g',63,['action':("edit"),'id':(persistentLogin.id)],4)
printHtmlPart(16)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: persistentLogin, field: "username"))
})
invokeTag('link','g',64,['controller':("user"),'action':("edit"),'params':([username: persistentLogin.username])],4)
printHtmlPart(16)
expressionOut.print(fieldValue(bean: persistentLogin, field: "token"))
printHtmlPart(16)
invokeTag('formatDate','g',66,['format':("MM/dd/yyyy"),'date':(persistentLogin.lastUsed)],-1)
printHtmlPart(17)
i++
}
}
printHtmlPart(18)
invokeTag('paginate','g',74,['total':(totalCount),'params':(queryParams)],-1)
printHtmlPart(19)
invokeTag('paginationSummary','s2ui',78,['total':(totalCount)],-1)
printHtmlPart(20)
}
printHtmlPart(21)
expressionOut.print(createLink(action: 'ajaxPersistentLoginSearch'))
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',96,[:],1)
printHtmlPart(23)
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
