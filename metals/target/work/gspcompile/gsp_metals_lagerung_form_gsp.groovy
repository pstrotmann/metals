import org.strotmann.metals.Lagerung
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_metals_lagerung_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/lagerung/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: lagerungInstance, field: 'anzahl', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("lagerung.anzahl.label"),'default':("Anzahl")],-1)
printHtmlPart(2)
invokeTag('field','g',10,['name':("anzahl"),'type':("number"),'value':(lagerungInstance.anzahl),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: lagerungInstance, field: 'item', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("lagerung.item.label"),'default':("Item")],-1)
printHtmlPart(2)
invokeTag('select','g',19,['id':("item"),'name':("item.id"),'from':(org.strotmann.metals.Item.list()),'optionKey':("id"),'required':(""),'value':(lagerungInstance?.item?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: lagerungInstance, field: 'lagerort', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("lagerung.lagerort.label"),'default':("Lagerort")],-1)
printHtmlPart(2)
invokeTag('select','g',28,['id':("lagerort"),'name':("lagerort.id"),'from':(org.strotmann.metals.Lagerort.list()),'optionKey':("id"),'required':(""),'value':(lagerungInstance?.lagerort?.id),'class':("many-to-one")],-1)
printHtmlPart(6)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1545164496000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
