import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='spring-security-ui', version='1.0-RC1')
class gsp_springSecurityUi_roleedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/spring-security-ui-1.0-RC1/grails-app/views/role/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("springSecurityUI")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'role.label', default: 'Role'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',6,['code':("default.edit.label"),'args':([entityName])],-1)
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
invokeTag('message','g',11,['code':("default.edit.label"),'args':([entityName])],-1)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(2)
invokeTag('hiddenField','g',14,['name':("id"),'value':(role?.id)],-1)
printHtmlPart(2)
invokeTag('hiddenField','g',15,['name':("version"),'value':(role?.version)],-1)
printHtmlPart(3)

def tabData = []
tabData << [name: 'roleinfo', icon: 'icon_role',  messageCode: 'spring.security.ui.role.info']
tabData << [name: 'users',    icon: 'icon_users', messageCode: 'spring.security.ui.role.users']

printHtmlPart(3)
createTagBody(3, {->
printHtmlPart(6)
createTagBody(4, {->
printHtmlPart(7)
invokeTag('textFieldRow','s2ui',29,['name':("authority"),'labelCode':("role.authority.label"),'bean':(role),'labelCodeDefault':("Authority"),'value':(role?.authority)],-1)
printHtmlPart(8)
})
invokeTag('tab','s2ui',32,['name':("roleinfo"),'height':("150")],4)
printHtmlPart(6)
createTagBody(4, {->
printHtmlPart(9)
if(true && (users.empty)) {
printHtmlPart(9)
invokeTag('message','g',36,['code':("spring.security.ui.role_no_users")],-1)
printHtmlPart(9)
}
printHtmlPart(9)
for( u in (users) ) {
printHtmlPart(10)
createTagBody(6, {->
expressionOut.print(u.username.encodeAsHTML())
})
invokeTag('link','g',39,['controller':("user"),'action':("edit"),'id':(u.id)],6)
printHtmlPart(11)
}
printHtmlPart(1)
})
invokeTag('tab','s2ui',41,['name':("users"),'height':("150")],4)
printHtmlPart(3)
})
invokeTag('tabs','s2ui',43,['elementId':("tabs"),'height':("150"),'data':(tabData)],3)
printHtmlPart(12)
invokeTag('submitButton','s2ui',46,['elementId':("update"),'form':("roleEditForm"),'messageCode':("default.button.update.label")],-1)
printHtmlPart(3)
if(true && (role)) {
printHtmlPart(2)
invokeTag('deleteButton','s2ui',49,[:],-1)
printHtmlPart(2)
}
printHtmlPart(13)
})
invokeTag('form','g',54,['action':("update"),'name':("roleEditForm")],2)
printHtmlPart(3)
if(true && (role)) {
printHtmlPart(2)
invokeTag('deleteButtonForm','s2ui',57,['instanceId':(role.id)],-1)
printHtmlPart(2)
}
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',60,[:],1)
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
