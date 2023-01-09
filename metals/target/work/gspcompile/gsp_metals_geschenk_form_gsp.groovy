import org.strotmann.metals.Geschenk
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_metals_geschenk_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/geschenk/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: geschenkInstance, field: 'datum', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("geschenk.datum.label"),'default':("Datum")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',10,['name':("datum"),'precision':("day"),'years':(2010..2030),'value':(geschenkInstance?.datum),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: geschenkInstance, field: 'anlass', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("geschenk.anlass.label"),'default':("Anlass")],-1)
printHtmlPart(2)
invokeTag('textField','g',19,['name':("anlass"),'value':(geschenkInstance?.anlass)],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: geschenkInstance, field: 'empfaenger', 'error'))
printHtmlPart(6)
invokeTag('message','g',25,['code':("geschenk.empfaenger.label"),'default':("Empfänger")],-1)
printHtmlPart(7)
invokeTag('textField','g',28,['name':("empfaenger"),'required':(""),'value':(geschenkInstance?.empfaenger)],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: geschenkInstance, field: 'item', 'error'))
printHtmlPart(8)
invokeTag('message','g',34,['code':("geschenk.item.label"),'default':("Item")],-1)
printHtmlPart(7)
invokeTag('select','g',37,['id':("item"),'name':("item.id"),'from':(org.strotmann.metals.Item.list()),'optionKey':("id"),'required':(""),'value':(geschenkInstance?.item?.id),'class':("many-to-one")],-1)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1595600248000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
