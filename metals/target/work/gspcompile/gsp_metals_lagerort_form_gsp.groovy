import org.strotmann.metals.Lagerort
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_metals_lagerort_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/lagerort/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: lagerortInstance, field: 'location', 'error'))
printHtmlPart(1)
invokeTag('message','g',5,['code':("lagerort.location.label"),'default':("Location")],-1)
printHtmlPart(2)
invokeTag('textField','g',8,['name':("location"),'required':(""),'value':(lagerortInstance?.location)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: lagerortInstance, field: 'subLocation', 'error'))
printHtmlPart(4)
invokeTag('message','g',14,['code':("lagerort.subLocation.label"),'default':("Sub Location")],-1)
printHtmlPart(2)
invokeTag('textField','g',17,['name':("subLocation"),'required':(""),'value':(lagerortInstance?.subLocation)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: lagerortInstance, field: 'kostenProJahr', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("lagerort.kostenProJahr.label"),'default':("Kosten Pro Jahr")],-1)
printHtmlPart(6)
invokeTag('field','g',26,['name':("kostenProJahr"),'value':(fieldValue(bean: lagerortInstance, field: 'kostenProJahr'))],-1)
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1545220711000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
