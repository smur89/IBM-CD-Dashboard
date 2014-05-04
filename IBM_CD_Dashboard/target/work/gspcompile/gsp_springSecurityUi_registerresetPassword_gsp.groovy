import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='spring-security-ui', version='1.0-RC1')
class gsp_springSecurityUi_registerresetPassword_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/spring-security-ui-1.0-RC1/grails-app/views/register/resetPassword.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',4,['code':("spring.security.ui.resetPassword.title")],-1)
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
printHtmlPart(5)
invokeTag('hiddenField','g',16,['name':("t"),'value':(token)],-1)
printHtmlPart(6)
invokeTag('message','g',20,['code':("spring.security.ui.resetPassword.description")],-1)
printHtmlPart(7)
invokeTag('passwordFieldRow','s2ui',24,['name':("password"),'labelCode':("resetPasswordCommand.password.label"),'bean':(command),'labelCodeDefault':("Password"),'value':(command?.password)],-1)
printHtmlPart(8)
invokeTag('passwordFieldRow','s2ui',27,['name':("password2"),'labelCode':("resetPasswordCommand.password2.label"),'bean':(command),'labelCodeDefault':("Password (again)"),'value':(command?.password2)],-1)
printHtmlPart(9)
invokeTag('submitButton','s2ui',30,['elementId':("reset"),'form':("resetPasswordForm"),'messageCode':("spring.security.ui.resetPassword.submit")],-1)
printHtmlPart(10)
})
invokeTag('form','g',33,['action':("resetPassword"),'name':("resetPasswordForm"),'autocomplete':("off")],3)
printHtmlPart(2)
})
invokeTag('form','s2ui',35,['width':("475"),'height':("250"),'elementId':("resetPasswordFormContainer"),'titleCode':("spring.security.ui.resetPassword.header"),'center':("true")],2)
printHtmlPart(11)
})
invokeTag('captureBody','sitemesh',43,[:],1)
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
