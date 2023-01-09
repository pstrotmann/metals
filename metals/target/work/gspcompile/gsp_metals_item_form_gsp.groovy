import org.strotmann.metals.Item
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_metals_item_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/item/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: itemInstance, field: 'bezeichnung', 'error'))
printHtmlPart(1)
invokeTag('message','g',6,['code':("item.bezeichnung.label"),'default':("Bezeichnung")],-1)
printHtmlPart(2)
invokeTag('textField','g',9,['name':("bezeichnung"),'required':(""),'value':(itemInstance?.bezeichnung)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: itemInstance, field: 'metall', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("item.metall.label"),'default':("Metall")],-1)
printHtmlPart(2)
invokeTag('select','g',19,['name':("metall"),'from':(itemInstance.constraints.metall.inList),'required':(""),'value':(itemInstance?.metall),'valueMessagePrefix':("item.metall")],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: itemInstance, field: 'gewicht', 'error'))
printHtmlPart(6)
invokeTag('message','g',25,['code':("item.gewicht.label"),'default':("Gewicht")],-1)
printHtmlPart(2)
invokeTag('field','g',28,['name':("gewicht"),'value':(fieldValue(bean: itemInstance, field: 'gewicht')),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: itemInstance, field: 'gewEinheit', 'error'))
printHtmlPart(7)
invokeTag('message','g',35,['code':("item.gewEinheit.label"),'default':("Gew Einheit")],-1)
printHtmlPart(2)
invokeTag('select','g',38,['name':("gewEinheit"),'from':(itemInstance.constraints.gewEinheit.inList),'required':(""),'value':(itemInstance?.gewEinheit),'valueMessagePrefix':("item.gewEinheit")],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: itemInstance, field: 'sammlerwert', 'error'))
printHtmlPart(8)
invokeTag('message','g',44,['code':("item.sammlerwert.label"),'default':("Sammlerwert")],-1)
printHtmlPart(9)
invokeTag('field','g',47,['name':("sammlerwert"),'value':(fieldValue(bean: itemInstance, field: 'sammlerwert'))],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: itemInstance, field: 'umlaufwert', 'error'))
printHtmlPart(10)
invokeTag('message','g',53,['code':("item.umlaufwert.label"),'default':("Umlaufwert")],-1)
printHtmlPart(9)
invokeTag('field','g',56,['name':("umlaufwert"),'value':(fieldValue(bean: itemInstance, field: 'umlaufwert'))],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: itemInstance, field: 'feingehalt', 'error'))
printHtmlPart(11)
invokeTag('message','g',62,['code':("item.feingehalt.label"),'default':("Feingehalt")],-1)
printHtmlPart(9)
invokeTag('field','g',65,['name':("feingehalt"),'value':(fieldValue(bean: itemInstance, field: 'feingehalt'))],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: itemInstance, field: 'lagerungen', 'error'))
printHtmlPart(12)
invokeTag('message','g',71,['code':("item.lagerungen.label"),'default':("Lagerungen")],-1)
printHtmlPart(13)
for( l in (itemInstance?.lagerungen) ) {
printHtmlPart(14)
createTagBody(2, {->
expressionOut.print(l?.encodeAsHTML())
})
invokeTag('link','g',77,['controller':("lagerung"),'action':("show"),'id':(l.id)],2)
printHtmlPart(15)
}
printHtmlPart(16)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'lagerung.label', default: 'Lagerung')]))
})
invokeTag('link','g',80,['controller':("lagerung"),'action':("create"),'params':(['item.id': itemInstance?.id])],1)
printHtmlPart(17)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1588336694000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
