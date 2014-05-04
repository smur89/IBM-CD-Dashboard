import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='spring-security-ui', version='1.0-RC1')
class gsp_springSecurityUi_includes_ajaxLogin_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/spring-security-ui-1.0-RC1/grails-app/views/includes/_ajaxLogin.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(message(code:'spring.security.ui.login.signin'))
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('message','g',12,['code':("spring.security.ui.login.username")],-1)
printHtmlPart(3)
invokeTag('message','g',15,['code':("spring.security.ui.login.password")],-1)
printHtmlPart(4)
invokeTag('message','g',19,['code':("spring.security.ui.login.rememberme")],-1)
printHtmlPart(5)
createTagBody(2, {->
invokeTag('message','g',21,['code':("spring.security.ui.login.forgotPassword")],-1)
})
invokeTag('link','g',21,['controller':("register"),'action':("forgotPassword")],2)
printHtmlPart(6)
createTagBody(2, {->
invokeTag('message','g',22,['code':("spring.security.ui.login.register")],-1)
})
invokeTag('link','g',22,['controller':("register")],2)
printHtmlPart(7)
})
invokeTag('form','g',26,['controller':("j_spring_security_check"),'name':("loginForm"),'autocomplete':("off")],1)
printHtmlPart(8)
invokeTag('message','g',32,['code':("spring.security.ui.login.login")],-1)
printHtmlPart(9)
out.print(link(controller: 'logout') { 'Logout' })
printHtmlPart(10)
invokeTag('message','g',34,['code':("spring.security.ui.login.loggingYouIn")],-1)
printHtmlPart(11)
invokeTag('javascript','g',36,['src':("jquery/jquery.form.js"),'plugin':("spring-security-ui")],-1)
printHtmlPart(12)
invokeTag('javascript','g',37,['src':("ajaxLogin.js"),'plugin':("spring-security-ui")],-1)
printHtmlPart(12)
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
