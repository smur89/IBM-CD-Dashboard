import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='spring-security-ui', version='1.0-RC1')
class gsp_springSecurityUi_registerindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/spring-security-ui-1.0-RC1/grails-app/views/register/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("register")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',5,['code':("spring.security.ui.register.title")],-1)
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
printHtmlPart(3)
createTagBody(3, {->
printHtmlPart(5)
if(true && (emailSent)) {
printHtmlPart(6)
invokeTag('message','g',19,['code':("spring.security.ui.register.sent")],-1)
printHtmlPart(1)
}
else {
printHtmlPart(7)
invokeTag('textFieldRow','s2ui',29,['name':("username"),'labelCode':("user.username.label"),'bean':(command),'size':("40"),'labelCodeDefault':("Username"),'value':(command.username)],-1)
printHtmlPart(8)
invokeTag('textFieldRow','s2ui',32,['name':("email"),'bean':(command),'value':(command.email),'size':("40"),'labelCode':("user.email.label"),'labelCodeDefault':("E-mail")],-1)
printHtmlPart(8)
invokeTag('passwordFieldRow','s2ui',35,['name':("password"),'labelCode':("user.password.label"),'bean':(command),'size':("40"),'labelCodeDefault':("Password"),'value':(command.password)],-1)
printHtmlPart(8)
invokeTag('passwordFieldRow','s2ui',38,['name':("password2"),'labelCode':("user.password2.label"),'bean':(command),'size':("40"),'labelCodeDefault':("Password (again)"),'value':(command.password2)],-1)
printHtmlPart(9)
invokeTag('submitButton','s2ui',43,['elementId':("create"),'form':("registerForm"),'messageCode':("spring.security.ui.register.submit")],-1)
printHtmlPart(5)
}
printHtmlPart(3)
})
invokeTag('form','g',47,['action':("register"),'name':("registerForm")],3)
printHtmlPart(3)
})
invokeTag('form','s2ui',49,['width':("650"),'height':("300"),'elementId':("loginFormContainer"),'titleCode':("spring.security.ui.register.description"),'center':("true")],2)
printHtmlPart(10)
})
invokeTag('captureBody','sitemesh',57,[:],1)
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
