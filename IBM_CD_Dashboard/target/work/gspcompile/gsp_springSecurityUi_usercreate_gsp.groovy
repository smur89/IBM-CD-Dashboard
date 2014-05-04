import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='spring-security-ui', version='1.0-RC1')
class gsp_springSecurityUi_usercreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/spring-security-ui-1.0-RC1/grails-app/views/user/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("springSecurityUI")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'user.label', default: 'User'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',6,['code':("default.create.label"),'args':([entityName])],-1)
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
invokeTag('message','g',11,['code':("default.create.label"),'args':([entityName])],-1)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(3)

def tabData = []
tabData << [name: 'userinfo', icon: 'icon_user', messageCode: 'spring.security.ui.user.info']
tabData << [name: 'roles',    icon: 'icon_role', messageCode: 'spring.security.ui.user.roles']

printHtmlPart(3)
createTagBody(3, {->
printHtmlPart(6)
createTagBody(4, {->
printHtmlPart(7)
invokeTag('textFieldRow','s2ui',28,['name':("username"),'labelCode':("user.username.label"),'bean':(user),'labelCodeDefault':("Username"),'value':(user?.username)],-1)
printHtmlPart(8)
invokeTag('passwordFieldRow','s2ui',31,['name':("password"),'labelCode':("user.password.label"),'bean':(user),'labelCodeDefault':("Password"),'value':(user?.password)],-1)
printHtmlPart(8)
invokeTag('checkboxRow','s2ui',34,['name':("enabled"),'labelCode':("user.enabled.label"),'bean':(user),'labelCodeDefault':("Enabled"),'value':(user?.enabled)],-1)
printHtmlPart(8)
invokeTag('checkboxRow','s2ui',37,['name':("accountExpired"),'labelCode':("user.accountExpired.label"),'bean':(user),'labelCodeDefault':("Account Expired"),'value':(user?.accountExpired)],-1)
printHtmlPart(8)
invokeTag('checkboxRow','s2ui',40,['name':("accountLocked"),'labelCode':("user.accountLocked.label"),'bean':(user),'labelCodeDefault':("Account Locked"),'value':(user?.accountLocked)],-1)
printHtmlPart(8)
invokeTag('checkboxRow','s2ui',43,['name':("passwordExpired"),'labelCode':("user.passwordExpired.label"),'bean':(user),'labelCodeDefault':("Password Expired"),'value':(user?.passwordExpired)],-1)
printHtmlPart(9)
})
invokeTag('tab','s2ui',46,['name':("userinfo"),'height':("280")],4)
printHtmlPart(6)
createTagBody(4, {->
printHtmlPart(10)
for( auth in (authorityList) ) {
printHtmlPart(11)
invokeTag('checkBox','g',51,['name':(auth.authority)],-1)
printHtmlPart(12)
createTagBody(6, {->
expressionOut.print(auth.authority.encodeAsHTML())
})
invokeTag('link','g',52,['controller':("role"),'action':("edit"),'id':(auth.id)],6)
printHtmlPart(13)
}
printHtmlPart(1)
})
invokeTag('tab','s2ui',55,['name':("roles"),'height':("280")],4)
printHtmlPart(3)
})
invokeTag('tabs','s2ui',57,['elementId':("tabs"),'height':("375"),'data':(tabData)],3)
printHtmlPart(14)
invokeTag('submitButton','s2ui',60,['elementId':("create"),'form':("userCreateForm"),'messageCode':("default.button.create.label")],-1)
printHtmlPart(15)
})
invokeTag('form','g',63,['action':("save"),'name':("userCreateForm")],2)
printHtmlPart(16)
invokeTag('initCheckboxes','s2ui',68,[:],-1)
printHtmlPart(17)
})
invokeTag('captureBody','sitemesh',72,[:],1)
printHtmlPart(18)
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
