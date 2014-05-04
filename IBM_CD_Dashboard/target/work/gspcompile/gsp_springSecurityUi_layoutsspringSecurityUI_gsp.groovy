import org.codehaus.groovy.grails.plugins.PluginManagerHolder
import grails.plugin.springsecurity.SpringSecurityUtils
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='spring-security-ui', version='1.0-RC1')
class gsp_springSecurityUi_layoutsspringSecurityUI_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/spring-security-ui-1.0-RC1/grails-app/views/layouts/springSecurityUI.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=utf-8")],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',11,['default':("Security Management Console")],-1)
})
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(3)
expressionOut.print(resource(dir:'images',file:'favicon.ico'))
printHtmlPart(4)
invokeTag('resources','s2ui',15,['module':("spring-security-ui")],-1)
printHtmlPart(5)
expressionOut.print(fam.icon(name: 'lock'))
printHtmlPart(6)
expressionOut.print(fam.icon(name: 'group'))
printHtmlPart(7)
expressionOut.print(fam.icon(name: 'user'))
printHtmlPart(8)
expressionOut.print(fam.icon(name: 'exclamation'))
printHtmlPart(9)
expressionOut.print(fam.icon(name: 'information'))
printHtmlPart(10)
invokeTag('layoutHead','g',24,[:],-1)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',24,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(11)
invokeTag('message','g',25,['code':("spring.security.ui.menu.users")],-1)
printHtmlPart(12)
createTagBody(2, {->
invokeTag('message','g',26,['code':("spring.security.ui.search")],-1)
})
invokeTag('link','g',26,['controller':("user"),'action':("search")],2)
printHtmlPart(13)
createTagBody(2, {->
invokeTag('message','g',27,['code':("spring.security.ui.create")],-1)
})
invokeTag('link','g',27,['controller':("user"),'action':("create")],2)
printHtmlPart(14)
invokeTag('message','g',28,['code':("spring.security.ui.menu.roles")],-1)
printHtmlPart(12)
createTagBody(2, {->
invokeTag('message','g',29,['code':("spring.security.ui.search")],-1)
})
invokeTag('link','g',29,['controller':("role"),'action':("search")],2)
printHtmlPart(13)
createTagBody(2, {->
invokeTag('message','g',30,['code':("spring.security.ui.create")],-1)
})
invokeTag('link','g',30,['controller':("role"),'action':("create")],2)
printHtmlPart(15)
if(true && (SpringSecurityUtils.securityConfig.securityConfigType?.toString() == 'Requestmap')) {
printHtmlPart(16)
invokeTag('message','g',37,['code':("spring.security.ui.menu.requestmaps")],-1)
printHtmlPart(12)
createTagBody(3, {->
invokeTag('message','g',43,['code':("spring.security.ui.search")],-1)
})
invokeTag('link','g',43,['controller':("requestmap"),'action':("search")],3)
printHtmlPart(13)
createTagBody(3, {->
invokeTag('message','g',47,['code':("spring.security.ui.create")],-1)
})
invokeTag('link','g',47,['controller':("requestmap"),'action':("create")],3)
printHtmlPart(15)
}
printHtmlPart(17)
if(true && (SpringSecurityUtils.securityConfig.rememberMe.persistent)) {
printHtmlPart(16)
invokeTag('message','g',56,['code':("spring.security.ui.menu.persistentLogins")],-1)
printHtmlPart(12)
createTagBody(3, {->
invokeTag('message','g',61,['code':("spring.security.ui.search")],-1)
})
invokeTag('link','g',61,['controller':("persistentLogin"),'action':("search")],3)
printHtmlPart(15)
}
printHtmlPart(16)
invokeTag('message','g',75,['code':("spring.security.ui.menu.registrationCode")],-1)
printHtmlPart(12)
createTagBody(2, {->
invokeTag('message','g',78,['code':("spring.security.ui.search")],-1)
})
invokeTag('link','g',78,['controller':("registrationCode"),'action':("search")],2)
printHtmlPart(15)
if(true && (PluginManagerHolder.pluginManager.hasGrailsPlugin('springSecurityAcl'))) {
printHtmlPart(16)
invokeTag('message','g',79,['code':("spring.security.ui.menu.acl")],-1)
printHtmlPart(12)
invokeTag('message','g',82,['code':("spring.security.ui.menu.aclClass")],-1)
printHtmlPart(18)
createTagBody(3, {->
invokeTag('message','g',84,['code':("spring.security.ui.search")],-1)
})
invokeTag('link','g',84,['controller':("aclClass"),'action':("search")],3)
printHtmlPart(19)
createTagBody(3, {->
invokeTag('message','g',85,['code':("spring.security.ui.create")],-1)
})
invokeTag('link','g',85,['controller':("aclClass"),'action':("create")],3)
printHtmlPart(20)
invokeTag('message','g',88,['code':("spring.security.ui.menu.aclSid")],-1)
printHtmlPart(18)
createTagBody(3, {->
invokeTag('message','g',89,['code':("spring.security.ui.search")],-1)
})
invokeTag('link','g',89,['controller':("aclSid"),'action':("search")],3)
printHtmlPart(19)
createTagBody(3, {->
invokeTag('message','g',91,['code':("spring.security.ui.create")],-1)
})
invokeTag('link','g',91,['controller':("aclSid"),'action':("create")],3)
printHtmlPart(20)
invokeTag('message','g',92,['code':("spring.security.ui.menu.aclObjectIdentity")],-1)
printHtmlPart(18)
createTagBody(3, {->
invokeTag('message','g',96,['code':("spring.security.ui.search")],-1)
})
invokeTag('link','g',96,['controller':("aclObjectIdentity"),'action':("search")],3)
printHtmlPart(19)
createTagBody(3, {->
invokeTag('message','g',99,['code':("spring.security.ui.create")],-1)
})
invokeTag('link','g',99,['controller':("aclObjectIdentity"),'action':("create")],3)
printHtmlPart(20)
invokeTag('message','g',99,['code':("spring.security.ui.menu.aclEntry")],-1)
printHtmlPart(18)
createTagBody(3, {->
invokeTag('message','g',103,['code':("spring.security.ui.search")],-1)
})
invokeTag('link','g',103,['controller':("aclEntry"),'action':("search")],3)
printHtmlPart(19)
createTagBody(3, {->
invokeTag('message','g',105,['code':("spring.security.ui.create")],-1)
})
invokeTag('link','g',105,['controller':("aclEntry"),'action':("create")],3)
printHtmlPart(21)
}
printHtmlPart(16)
invokeTag('message','g',109,['code':("spring.security.ui.menu.appinfo")],-1)
printHtmlPart(22)
createTagBody(2, {->
invokeTag('message','g',111,['code':("spring.security.ui.menu.appinfo.config")],-1)
})
invokeTag('link','g',111,['action':("config"),'controller':("securityInfo")],2)
printHtmlPart(23)
createTagBody(2, {->
invokeTag('message','g',113,['code':("spring.security.ui.menu.appinfo.mappings")],-1)
})
invokeTag('link','g',113,['action':("mappings"),'controller':("securityInfo")],2)
printHtmlPart(23)
createTagBody(2, {->
invokeTag('message','g',115,['code':("spring.security.ui.menu.appinfo.auth")],-1)
})
invokeTag('link','g',115,['action':("currentAuth"),'controller':("securityInfo")],2)
printHtmlPart(23)
createTagBody(2, {->
invokeTag('message','g',119,['code':("spring.security.ui.menu.appinfo.usercache")],-1)
})
invokeTag('link','g',119,['action':("usercache"),'controller':("securityInfo")],2)
printHtmlPart(23)
createTagBody(2, {->
invokeTag('message','g',120,['code':("spring.security.ui.menu.appinfo.filters")],-1)
})
invokeTag('link','g',120,['action':("filterChain"),'controller':("securityInfo")],2)
printHtmlPart(23)
createTagBody(2, {->
invokeTag('message','g',123,['code':("spring.security.ui.menu.appinfo.logout")],-1)
})
invokeTag('link','g',123,['action':("logoutHandler"),'controller':("securityInfo")],2)
printHtmlPart(23)
createTagBody(2, {->
invokeTag('message','g',125,['code':("spring.security.ui.menu.appinfo.voters")],-1)
})
invokeTag('link','g',125,['action':("voters"),'controller':("securityInfo")],2)
printHtmlPart(23)
createTagBody(2, {->
invokeTag('message','g',126,['code':("spring.security.ui.menu.appinfo.providers")],-1)
})
invokeTag('link','g',126,['action':("providers"),'controller':("securityInfo")],2)
printHtmlPart(24)
createTagBody(2, {->
printHtmlPart(25)
invokeTag('username','sec',132,[:],-1)
printHtmlPart(26)
createClosureForHtmlPart(27, 3)
invokeTag('link','g',132,['controller':("logout")],3)
printHtmlPart(28)
})
invokeTag('ifLoggedIn','sec',132,[:],2)
printHtmlPart(17)
createClosureForHtmlPart(29, 2)
invokeTag('ifNotLoggedIn','sec',138,[:],2)
printHtmlPart(30)
createTagBody(2, {->
printHtmlPart(31)
expressionOut.print(request.contextPath)
printHtmlPart(32)
invokeTag('switchedUserOriginalUsername','sec',140,[:],-1)
printHtmlPart(33)
})
invokeTag('ifSwitched','sec',140,[:],2)
printHtmlPart(34)
invokeTag('layoutResources','s2ui',142,['module':("spring-security-ui")],-1)
printHtmlPart(17)
invokeTag('layoutBody','g',142,[:],-1)
printHtmlPart(35)
invokeTag('render','g',142,['template':("/includes/ajaxLogin"),'plugin':("spring-security-ui")],-1)
printHtmlPart(2)
invokeTag('showFlash','s2ui',143,[:],-1)
printHtmlPart(2)
})
invokeTag('captureBody','sitemesh',143,[:],1)
printHtmlPart(36)
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
