import ibm_cd_dashboard.User
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_IBM_CD_Dashboard_layoutsapplication_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/application.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'charset':("UTF-8")],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',7,['default':("IBM CD Adoption Dashboard")],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("Description"),'content':("Continuous Delivery Adoption Dashboard")],-1)
printHtmlPart(3)
expressionOut.print(resource(dir: 'css/base', file: 'core.css'))
printHtmlPart(4)
expressionOut.print(resource(dir: 'css/defaultTheme', file: 'defaultTheme.css'))
printHtmlPart(5)
invokeTag('layoutHead','g',51,[:],-1)
printHtmlPart(2)
invokeTag('layoutResources','r',53,[:],-1)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',54,[:],1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
invokeTag('img','g',64,['dir':("css/images"),'file':("blank.gif"),'alt':("Skip to main content link. Accesskey S")],-1)
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('img','g',66,['dir':("css/images"),'file':("blank.gif"),'alt':("Product Name")],-1)
printHtmlPart(11)
})
invokeTag('link','g',67,['controller':("team"),'action':("index"),'class':("lotusLogo")],2)
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(13)
createClosureForHtmlPart(14, 3)
invokeTag('link','g',71,['controller':("login")],3)
printHtmlPart(15)
})
invokeTag('ifNotLoggedIn','sec',72,[:],2)
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(13)
createClosureForHtmlPart(16, 3)
invokeTag('link','g',76,['controller':("logout"),'role':("button"),'class':("lotusBannerBtn")],3)
printHtmlPart(17)
createClosureForHtmlPart(18, 3)
invokeTag('link','g',80,['controller':("userProfile"),'action':("show"),'role':("button"),'class':("lotusBannerBtn")],3)
printHtmlPart(15)
})
invokeTag('ifLoggedIn','sec',81,[:],2)
printHtmlPart(19)
createTagBody(2, {->
printHtmlPart(20)
invokeTag('img','g',86,['dir':("css/images"),'file':("help.gif"),'class':("yourProductSprite yourProductSprite-bannerHelp16")],-1)
printHtmlPart(21)
})
invokeTag('link','g',86,['controller':("Home"),'action':("help"),'class':("yourProductSprite yourProductSprite-bannerHelp16")],2)
printHtmlPart(22)
invokeTag('img','g',91,['dir':("/css/images"),'file':("blank.gif"),'alt':("IBM"),'class':("lotusIBMLogo")],-1)
printHtmlPart(23)
invokeTag('img','g',101,['dir':("css/images"),'file':("refresh_graphic.png"),'class':("lotusIcon")],-1)
printHtmlPart(24)
invokeTag('img','g',112,['dir':("/css/images"),'file':("blank.gif"),'class':("lotusIcon yourProductSprite yourProductSprite-iconPlaceholder24")],-1)
printHtmlPart(25)
expressionOut.print(layoutTitle())
printHtmlPart(26)
invokeTag('layoutBody','g',124,[:],-1)
printHtmlPart(27)
invokeTag('img','g',130,['dir':("/css/images"),'file':("blank.gif"),'alt':("IBM"),'class':("lotusIBMLogo")],-1)
printHtmlPart(28)
createClosureForHtmlPart(29, 2)
invokeTag('link','g',140,['controller':("Home"),'action':("help")],2)
printHtmlPart(30)
createClosureForHtmlPart(31, 2)
invokeTag('link','g',141,['controller':("Home"),'action':("about")],2)
printHtmlPart(32)
invokeTag('img','g',150,['dir':("/css/images"),'file':("blank.gif"),'alt':("IBM"),'class':("lotusIBMLogoFooter")],-1)
printHtmlPart(33)
invokeTag('layoutResources','r',157,[:],-1)
printHtmlPart(6)
})
invokeTag('captureBody','sitemesh',157,['class':("lotusui30_body lotusui30_fonts lotusui30")],1)
printHtmlPart(34)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1398800927000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
