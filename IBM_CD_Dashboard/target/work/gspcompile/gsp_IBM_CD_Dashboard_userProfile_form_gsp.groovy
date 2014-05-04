import ibm_cd_dashboard.User
import  ibm_cd_dashboard.Team
import  ibm_cd_dashboard.UserProfile
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_IBM_CD_Dashboard_userProfile_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/userProfile/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: userProfileInstance, field: 'user', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("userProfile.user.label"),'default':("User")],-1)
printHtmlPart(2)
invokeTag('select','g',11,['id':("user"),'name':("user.id"),'from':(userProfileInstance.user),'optionKey':("id"),'required':(""),'value':(userProfileInstance?.user?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
for( team in (Team.getAll()) ) {
printHtmlPart(4)
if(true && (userProfileInstance?.projects?.contains(team.getTeamId()))) {
printHtmlPart(5)
invokeTag('checkBox','g',16,['name':("checkbox.${team.getTeamId()}"),'checked':("true"),'value':(team.id)],-1)
printHtmlPart(6)
}
else {
printHtmlPart(5)
invokeTag('checkBox','g',19,['name':("checkbox.${team.getTeamId()}"),'checked':("false"),'value':(team.id)],-1)
printHtmlPart(6)
}
printHtmlPart(7)
expressionOut.print(team)
printHtmlPart(8)
expressionOut.print(team.teamName)
printHtmlPart(9)
}
printHtmlPart(10)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1396100512000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
