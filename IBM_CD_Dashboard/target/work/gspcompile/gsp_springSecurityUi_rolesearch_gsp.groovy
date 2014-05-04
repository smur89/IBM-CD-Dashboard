import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='spring-security-ui', version='1.0-RC1')
class gsp_springSecurityUi_rolesearch_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/spring-security-ui-1.0-RC1/grails-app/views/role/search.gsp" }
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
invokeTag('message','g',5,['code':("spring.security.ui.role.search")],-1)
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
invokeTag('message','g',22,['code':("role.authority.label"),'default':("Authority")],-1)
printHtmlPart(7)
invokeTag('textField','g',23,['name':("authority"),'class':("textField"),'size':("50"),'maxlength':("255"),'autocomplete':("off"),'value':(authority)],-1)
printHtmlPart(8)
invokeTag('submitButton','s2ui',27,['elementId':("search"),'form':("roleSearchForm"),'messageCode':("spring.security.ui.search")],-1)
printHtmlPart(9)
})
invokeTag('form','g',31,['action':("roleSearch"),'name':("roleSearchForm")],3)
printHtmlPart(5)
})
invokeTag('form','s2ui',33,['width':("100%"),'height':("200"),'elementId':("formContainer"),'titleCode':("spring.security.ui.role.search")],2)
printHtmlPart(5)
if(true && (searched)) {
printHtmlPart(3)

def queryParams = [authority: authority]

printHtmlPart(10)
invokeTag('sortableColumn','g',45,['property':("authority"),'title':(message(code: 'role.authority.label', default: 'Authority')),'params':(queryParams)],-1)
printHtmlPart(11)
loop:{
int i = 0
for( role in (results) ) {
printHtmlPart(12)
expressionOut.print((i % 2) == 0 ? 'odd' : 'even')
printHtmlPart(13)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: role, field: "authority"))
})
invokeTag('link','g',52,['action':("edit"),'id':(role.id)],4)
printHtmlPart(14)
i++
}
}
printHtmlPart(15)
invokeTag('paginate','g',60,['total':(totalCount),'params':(queryParams)],-1)
printHtmlPart(16)
invokeTag('paginationSummary','s2ui',64,['total':(totalCount)],-1)
printHtmlPart(17)
}
printHtmlPart(18)
expressionOut.print(createLink(action: 'ajaxRoleSearch'))
printHtmlPart(19)
})
invokeTag('captureBody','sitemesh',81,[:],1)
printHtmlPart(20)
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
