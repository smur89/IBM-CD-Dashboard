import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='spring-security-ui', version='1.0-RC1')
class gsp_springSecurityUi_requestmapsearch_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/spring-security-ui-1.0-RC1/grails-app/views/requestmap/search.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("springSecurityUI")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'requestmap.label', default: 'Requestmap'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',6,['code':("default.list.label"),'args':([entityName])],-1)
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
invokeTag('message','g',23,['code':("requestmap.url.label"),'default':("URL")],-1)
printHtmlPart(7)
invokeTag('textField','g',24,['name':("url"),'size':("50"),'maxlength':("255"),'autocomplete':("off"),'value':(url)],-1)
printHtmlPart(8)
invokeTag('message','g',27,['code':("requestmap.configAttribute.label"),'default':("Config Attribute")],-1)
printHtmlPart(7)
invokeTag('textField','g',28,['name':("configAttribute"),'size':("50"),'maxlength':("255"),'autocomplete':("off"),'value':(configAttribute)],-1)
printHtmlPart(9)
invokeTag('submitButton','s2ui',32,['elementId':("search"),'form':("requestmapSearchForm"),'messageCode':("spring.security.ui.search")],-1)
printHtmlPart(10)
})
invokeTag('form','g',36,['action':("requestmapSearch"),'name':("requestmapSearchForm")],3)
printHtmlPart(5)
})
invokeTag('form','s2ui',38,['width':("100%"),'height':("200"),'elementId':("formContainer"),'titleCode':("spring.security.ui.requestmap.search")],2)
printHtmlPart(5)
if(true && (searched)) {
printHtmlPart(3)

def queryParams = [url: url, configAttribute: configAttribute]

printHtmlPart(11)
invokeTag('sortableColumn','g',50,['property':("url"),'title':(message(code: 'requestmap.url.label', default: 'URL')),'params':(queryParams)],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',51,['property':("configAttribute"),'title':(message(code: 'requestmap.configAttribute.label', default: 'Config Attribute')),'params':(queryParams)],-1)
printHtmlPart(13)
loop:{
int i = 0
for( requestmap in (results) ) {
printHtmlPart(14)
expressionOut.print((i % 2) == 0 ? 'odd' : 'even')
printHtmlPart(15)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: requestmap, field: "url"))
})
invokeTag('link','g',57,['action':("edit"),'id':(requestmap.id)],4)
printHtmlPart(16)
expressionOut.print(fieldValue(bean: requestmap, field: "configAttribute"))
printHtmlPart(17)
i++
}
}
printHtmlPart(18)
invokeTag('paginate','g',66,['total':(totalCount),'params':(queryParams)],-1)
printHtmlPart(19)
invokeTag('paginationSummary','s2ui',70,['total':(totalCount)],-1)
printHtmlPart(20)
}
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',83,[:],1)
printHtmlPart(22)
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
