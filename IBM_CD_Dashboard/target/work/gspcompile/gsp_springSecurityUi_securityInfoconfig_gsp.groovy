import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='spring-security-ui', version='1.0-RC1')
class gsp_springSecurityUi_securityInfoconfig_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/spring-security-ui-1.0-RC1/grails-app/views/securityInfo/config.gsp" }
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
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(3)
createClosureForHtmlPart(4, 2)
invokeTag('javascript','g',11,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(5)
for( entry in (conf) ) {
printHtmlPart(6)

def key = entry.key
if (key.startsWith('failureHandler.exceptionMappings.')) {
	key = key - 'failureHandler.exceptionMappings.'
	key = 'failureHandler.exceptionMappings. ' + key.replaceAll('\\.', '\\. ')
}
def value = entry.value
if (value instanceof Class) {
	value = value.name.replaceAll('\\.', '\\. ')
}

printHtmlPart(7)
expressionOut.print(key)
printHtmlPart(8)
expressionOut.print(value)
printHtmlPart(9)
}
printHtmlPart(10)
})
invokeTag('captureBody','sitemesh',47,[:],1)
printHtmlPart(11)
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
