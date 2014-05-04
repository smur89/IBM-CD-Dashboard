import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_IBM_CD_Dashboard_layoutsmain_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/main.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(resource(dir: 'css/base', file: 'core.css'))
printHtmlPart(2)
expressionOut.print(resource(dir: 'css/defaultTheme', file: 'defaultTheme.css'))
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',13,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(4)
invokeTag('captureMeta','sitemesh',14,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge,chrome=1")],-1)
printHtmlPart(4)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',15,['default':("Grails")],-1)
})
invokeTag('captureTitle','sitemesh',15,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',15,[:],2)
printHtmlPart(4)
invokeTag('captureMeta','sitemesh',16,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(5)
expressionOut.print(resource(dir: 'images', file: 'favicon.ico'))
printHtmlPart(6)
expressionOut.print(resource(dir: 'images', file: 'apple-touch-icon.png'))
printHtmlPart(7)
expressionOut.print(resource(dir: 'images', file: 'apple-touch-icon-retina.png'))
printHtmlPart(8)
invokeTag('layoutHead','g',50,[:],-1)
printHtmlPart(4)
invokeTag('layoutResources','r',51,[:],-1)
printHtmlPart(9)
})
invokeTag('captureHead','sitemesh',51,[:],1)
printHtmlPart(10)
createTagBody(1, {->
printHtmlPart(11)
expressionOut.print(resource(dir: 'images', file: 'blank.gif'))
printHtmlPart(12)
expressionOut.print(resource(dir: 'images', file: 'blank.gif'))
printHtmlPart(13)
expressionOut.print(resource(dir: 'images', file: 'blank.gif'))
printHtmlPart(14)
expressionOut.print(resource(dir: 'images', file: 'blank.gif'))
printHtmlPart(15)
expressionOut.print(resource(dir: 'images', file: 'blank.gif'))
printHtmlPart(16)
expressionOut.print(resource(dir: 'images', file: 'blank.gif'))
printHtmlPart(17)
expressionOut.print(resource(dir: 'images', file: 'blank.gif'))
printHtmlPart(18)
expressionOut.print(resource(dir: 'images', file: 'blank.gif'))
printHtmlPart(19)
expressionOut.print(resource(dir: 'images', file: 'blank.gif'))
printHtmlPart(20)
expressionOut.print(resource(dir: 'images', file: 'blank.gif'))
printHtmlPart(21)
expressionOut.print(resource(dir: 'images', file: 'blank.gif'))
printHtmlPart(22)
expressionOut.print(resource(dir: 'images', file: 'blank.gif'))
printHtmlPart(23)
expressionOut.print(resource(dir: 'images', file: 'blank.gif'))
printHtmlPart(24)
expressionOut.print(resource(dir: 'images', file: 'blank.gif'))
printHtmlPart(25)
expressionOut.print(resource(dir: 'images', file: 'blank.gif'))
printHtmlPart(26)
expressionOut.print(resource(dir: 'images', file: 'blank.gif'))
printHtmlPart(27)
expressionOut.print(resource(dir: 'images', file: 'blank.gif'))
printHtmlPart(28)
expressionOut.print(resource(dir: 'images', file: 'grails_logo.png'))
printHtmlPart(29)
invokeTag('layoutBody','g',157,[:],-1)
printHtmlPart(30)
invokeTag('javascript','g',158,['library':("application")],-1)
printHtmlPart(31)
invokeTag('layoutResources','r',159,[:],-1)
printHtmlPart(9)
})
invokeTag('captureBody','sitemesh',159,[:],1)
printHtmlPart(32)
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
