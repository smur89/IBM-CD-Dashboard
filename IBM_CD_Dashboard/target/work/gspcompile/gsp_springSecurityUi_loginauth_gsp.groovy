import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='spring-security-ui', version='1.0-RC1')
class gsp_springSecurityUi_loginauth_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/spring-security-ui-1.0-RC1/grails-app/views/login/auth.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',4,['code':("spring.security.ui.login.title")],-1)
})
invokeTag('captureTitle','sitemesh',4,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',4,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("register")],-1)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
expressionOut.print(postUrl)
printHtmlPart(4)
invokeTag('message','g',17,['code':("spring.security.ui.login.signin")],-1)
printHtmlPart(5)
invokeTag('message','g',21,['code':("spring.security.ui.login.username")],-1)
printHtmlPart(6)
invokeTag('message','g',25,['code':("spring.security.ui.login.password")],-1)
printHtmlPart(7)
expressionOut.print(rememberMeParameter)
printHtmlPart(8)
invokeTag('message','g',31,['code':("spring.security.ui.login.rememberme")],-1)
printHtmlPart(9)
createTagBody(2, {->
invokeTag('message','g',33,['code':("spring.security.ui.login.forgotPassword")],-1)
})
invokeTag('link','g',33,['controller':("register"),'action':("forgotPassword")],2)
printHtmlPart(10)
invokeTag('linkButton','s2ui',39,['elementId':("register"),'controller':("register"),'messageCode':("spring.security.ui.login.register")],-1)
printHtmlPart(11)
invokeTag('submitButton','s2ui',40,['elementId':("loginButton"),'form':("loginForm"),'messageCode':("spring.security.ui.login.login")],-1)
printHtmlPart(12)
invokeTag('initCheckboxes','s2ui',55,[:],-1)
printHtmlPart(13)
})
invokeTag('captureBody','sitemesh',59,[:],1)
printHtmlPart(14)
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
