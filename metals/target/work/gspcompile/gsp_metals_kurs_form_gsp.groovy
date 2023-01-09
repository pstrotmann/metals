import org.strotmann.metals.Kurs
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_metals_kurs_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/kurs/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: kursInstance, field: 'metall', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("kurs.metall.label"),'default':("Metall")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['name':("metall"),'from':(kursInstance.constraints.metall.inList),'required':(""),'value':(kursInstance?.metall),'valueMessagePrefix':("kurs.metall")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: kursInstance, field: 'kursInDollarJeUnze', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("kurs.kursInDollarJeUnze.label"),'default':("Kurs In Dollar Je Unze")],-1)
printHtmlPart(5)
invokeTag('field','g',19,['name':("kursInDollarJeUnze"),'value':(fieldValue(bean: kursInstance, field: 'kursInDollarJeUnze'))],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: kursInstance, field: 'kursInEuroJeKg', 'error'))
printHtmlPart(6)
invokeTag('message','g',25,['code':("kurs.kursInEuroJeKg.label"),'default':("Kurs In Euro Je Kg")],-1)
printHtmlPart(5)
invokeTag('field','g',28,['name':("kursInEuroJeKg"),'value':(fieldValue(bean: kursInstance, field: 'kursInEuroJeKg'))],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: kursInstance, field: 'kursInDollarJeKg', 'error'))
printHtmlPart(7)
invokeTag('message','g',34,['code':("kurs.kursInDollarJeKg.label"),'default':("Kurs In Dollar Je Kg")],-1)
printHtmlPart(5)
invokeTag('field','g',37,['name':("kursInDollarJeKg"),'value':(fieldValue(bean: kursInstance, field: 'kursInDollarJeKg'))],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: kursInstance, field: 'kursInEuroJeUnze', 'error'))
printHtmlPart(8)
invokeTag('message','g',43,['code':("kurs.kursInEuroJeUnze.label"),'default':("Kurs In Euro Je Unze")],-1)
printHtmlPart(2)
invokeTag('field','g',46,['name':("kursInEuroJeUnze"),'value':(fieldValue(bean: kursInstance, field: 'kursInEuroJeUnze')),'required':("")],-1)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1545164468000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
