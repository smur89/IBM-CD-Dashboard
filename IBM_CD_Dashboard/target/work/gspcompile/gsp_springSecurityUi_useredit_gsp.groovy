import org.codehaus.groovy.grails.plugins.PluginManagerHolder
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='spring-security-ui', version='1.0-RC1')
class gsp_springSecurityUi_useredit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/spring-security-ui-1.0-RC1/grails-app/views/user/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(2)
if(true && (user.username)) {
printHtmlPart(2)
invokeTag('set','g',7,['var':("canRunAs"),'value':(true)],-1)
printHtmlPart(2)
}
printHtmlPart(2)
})
invokeTag('ifAllGranted','sec',9,['roles':("ROLE_SWITCH_USER")],2)
printHtmlPart(3)
})
invokeTag('ifNotSwitched','sec',10,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',13,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("springSecurityUI")],-1)
printHtmlPart(2)
invokeTag('set','g',14,['var':("entityName"),'value':(message(code: 'user.label', default: 'User'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',15,['code':("default.edit.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',15,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',15,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',16,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',20,['code':("default.edit.label"),'args':([entityName])],-1)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(3)
invokeTag('hiddenField','g',23,['name':("id"),'value':(user?.id)],-1)
printHtmlPart(3)
invokeTag('hiddenField','g',24,['name':("version"),'value':(user?.version)],-1)
printHtmlPart(1)

def tabData = []
tabData << [name: 'userinfo', icon: 'icon_user', messageCode: 'spring.security.ui.user.info']
tabData << [name: 'roles',    icon: 'icon_role', messageCode: 'spring.security.ui.user.roles']
boolean isOpenId = PluginManagerHolder.pluginManager.hasGrailsPlugin('springSecurityOpenid')
if (isOpenId) {
	tabData << [name: 'openIds', icon: 'icon_role', messageCode: 'spring.security.ui.user.openIds']
}

printHtmlPart(1)
createTagBody(3, {->
printHtmlPart(6)
createTagBody(4, {->
printHtmlPart(7)
invokeTag('textFieldRow','s2ui',43,['name':("username"),'labelCode':("user.username.label"),'bean':(user),'labelCodeDefault':("Username"),'value':(user?.username)],-1)
printHtmlPart(8)
invokeTag('passwordFieldRow','s2ui',46,['name':("password"),'labelCode':("user.password.label"),'bean':(user),'labelCodeDefault':("Password"),'value':(user?.password)],-1)
printHtmlPart(8)
invokeTag('checkboxRow','s2ui',49,['name':("enabled"),'labelCode':("user.enabled.label"),'bean':(user),'labelCodeDefault':("Enabled"),'value':(user?.enabled)],-1)
printHtmlPart(8)
invokeTag('checkboxRow','s2ui',52,['name':("accountExpired"),'labelCode':("user.accountExpired.label"),'bean':(user),'labelCodeDefault':("Account Expired"),'value':(user?.accountExpired)],-1)
printHtmlPart(8)
invokeTag('checkboxRow','s2ui',55,['name':("accountLocked"),'labelCode':("user.accountLocked.label"),'bean':(user),'labelCodeDefault':("Account Locked"),'value':(user?.accountLocked)],-1)
printHtmlPart(8)
invokeTag('checkboxRow','s2ui',58,['name':("passwordExpired"),'labelCode':("user.passwordExpired.label"),'bean':(user),'labelCodeDefault':("Password Expired"),'value':(user?.passwordExpired)],-1)
printHtmlPart(9)
})
invokeTag('tab','s2ui',61,['name':("userinfo"),'height':("275")],4)
printHtmlPart(6)
createTagBody(4, {->
printHtmlPart(10)
for( entry in (roleMap) ) {
printHtmlPart(11)
invokeTag('checkBox','g',66,['name':(entry.key.authority),'value':(entry.value)],-1)
printHtmlPart(12)
createTagBody(6, {->
expressionOut.print(entry.key.authority.encodeAsHTML())
})
invokeTag('link','g',67,['controller':("role"),'action':("edit"),'id':(entry.key.id)],6)
printHtmlPart(13)
}
printHtmlPart(2)
})
invokeTag('tab','s2ui',70,['name':("roles"),'height':("275")],4)
printHtmlPart(6)
if(true && (isOpenId)) {
printHtmlPart(2)
createTagBody(5, {->
printHtmlPart(2)
if(true && (user?.openIds)) {
printHtmlPart(14)
for( openId in (user.openIds) ) {
printHtmlPart(15)
expressionOut.print(openId.url)
printHtmlPart(16)
}
printHtmlPart(17)
}
else {
printHtmlPart(18)
}
printHtmlPart(2)
})
invokeTag('tab','s2ui',84,['name':("openIds"),'height':("275")],5)
printHtmlPart(2)
}
printHtmlPart(1)
})
invokeTag('tabs','s2ui',87,['elementId':("tabs"),'height':("375"),'data':(tabData)],3)
printHtmlPart(19)
invokeTag('submitButton','s2ui',90,['elementId':("update"),'form':("userEditForm"),'messageCode':("default.button.update.label")],-1)
printHtmlPart(1)
if(true && (user)) {
printHtmlPart(3)
invokeTag('deleteButton','s2ui',93,[:],-1)
printHtmlPart(3)
}
printHtmlPart(1)
if(true && (canRunAs)) {
printHtmlPart(20)
expressionOut.print(message(code:'spring.security.ui.runas.submit'))
printHtmlPart(21)
}
printHtmlPart(22)
})
invokeTag('form','g',102,['action':("update"),'name':("userEditForm"),'class':("button-style")],2)
printHtmlPart(1)
if(true && (user)) {
printHtmlPart(3)
invokeTag('deleteButtonForm','s2ui',105,['instanceId':(user.id)],-1)
printHtmlPart(3)
}
printHtmlPart(1)
if(true && (canRunAs)) {
printHtmlPart(23)
expressionOut.print(request.contextPath)
printHtmlPart(24)
invokeTag('hiddenField','g',110,['name':("j_username"),'value':(user.username)],-1)
printHtmlPart(25)
}
printHtmlPart(26)
invokeTag('initCheckboxes','s2ui',119,[:],-1)
printHtmlPart(27)
})
invokeTag('captureBody','sitemesh',128,[:],1)
printHtmlPart(28)
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
