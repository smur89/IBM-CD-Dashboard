import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='spring-security-ui', version='1.0-RC1')
class gsp_springSecurityUi_registerforgotPassword_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/spring-security-ui-1.0-RC1/grails-app/views/register/forgotPassword.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',4,['code':("spring.security.ui.forgotPassword.title")],-1)
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
createTagBody(2, {->
printHtmlPart(4)
createTagBody(3, {->
printHtmlPart(4)
if(true && (emailSent)) {
printHtmlPart(5)
invokeTag('message','g',19,['code':("spring.security.ui.forgotPassword.sent")],-1)
printHtmlPart(6)
}
else {
printHtmlPart(7)
invokeTag('message','g',25,['code':("spring.security.ui.forgotPassword.description")],-1)
printHtmlPart(8)
invokeTag('message','g',29,['code':("spring.security.ui.forgotPassword.username")],-1)
printHtmlPart(9)
invokeTag('textField','g',30,['name':("username"),'size':("25")],-1)
printHtmlPart(10)
invokeTag('submitButton','s2ui',34,['elementId':("reset"),'form':("forgotPasswordForm"),'messageCode':("spring.security.ui.forgotPassword.submit")],-1)
printHtmlPart(4)
}
printHtmlPart(4)
})
invokeTag('form','g',38,['action':("forgotPassword"),'name':("forgotPasswordForm"),'autocomplete':("off")],3)
printHtmlPart(1)
})
invokeTag('form','s2ui',39,['width':("400"),'height':("220"),'elementId':("forgotPasswordFormContainer"),'titleCode':("spring.security.ui.forgotPassword.header"),'center':("true")],2)
printHtmlPart(11)
})
invokeTag('captureBody','sitemesh',47,[:],1)
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
