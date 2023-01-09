import org.strotmann.metals.Item
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_metals_itemshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/item/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'item.label', default: 'Item'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',14,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',15,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("list"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',16,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',16,['class':("create"),'action':("create")],2)
printHtmlPart(9)
invokeTag('message','g',20,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (itemInstance?.bezeichnung)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("item.bezeichnung.label"),'default':("Bezeichnung")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',30,['bean':(itemInstance),'field':("bezeichnung")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (itemInstance?.metall)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("item.metall.label"),'default':("Metall")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',39,['bean':(itemInstance),'field':("metall")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (itemInstance?.gewicht)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("item.gewicht.label"),'default':("Gewicht")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',48,['bean':(itemInstance),'field':("gewicht")],-1)
printHtmlPart(16)
}
printHtmlPart(22)
if(true && (itemInstance?.gewEinheit)) {
printHtmlPart(23)
invokeTag('message','g',56,['code':("item.gewEinheit.label"),'default':("Gew Einheit")],-1)
printHtmlPart(24)
invokeTag('fieldValue','g',58,['bean':(itemInstance),'field':("gewEinheit")],-1)
printHtmlPart(16)
}
printHtmlPart(25)
if(true && (itemInstance?.sammlerwert)) {
printHtmlPart(26)
invokeTag('message','g',66,['code':("item.sammlerwert.label"),'default':("Sammlerwert")],-1)
printHtmlPart(27)
invokeTag('fieldValue','g',68,['bean':(itemInstance),'field':("sammlerwert")],-1)
printHtmlPart(16)
}
printHtmlPart(28)
if(true && (itemInstance?.umlaufwert)) {
printHtmlPart(29)
invokeTag('message','g',75,['code':("item.umlaufwert.label"),'default':("Umlaufwert €")],-1)
printHtmlPart(30)
invokeTag('fieldValue','g',77,['bean':(itemInstance),'field':("umlaufwert")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (itemInstance?.feingehalt)) {
printHtmlPart(31)
invokeTag('message','g',84,['code':("item.feingehalt.label"),'default':("Feingehalt")],-1)
printHtmlPart(32)
invokeTag('fieldValue','g',86,['bean':(itemInstance),'field':("feingehalt")],-1)
printHtmlPart(16)
}
printHtmlPart(33)
invokeTag('message','g',92,['code':("item.metallwert1.label"),'default':("Metallwert Einzeln €")],-1)
printHtmlPart(34)
invokeTag('formatNumber','g',94,['number':(itemInstance.metallwert),'type':("number"),'minFractionDigits':("2"),'maxFractionDigits':("2"),'format':("#,##0.00")],-1)
printHtmlPart(35)
invokeTag('message','g',99,['code':("item.anzahl.label"),'default':("Anzahl")],-1)
printHtmlPart(36)
invokeTag('fieldValue','g',101,['bean':(itemInstance),'field':("anzahlGesamt")],-1)
printHtmlPart(37)
invokeTag('message','g',106,['code':("item.metallwert.label"),'default':("Metallwert Gesamt €")],-1)
printHtmlPart(38)
invokeTag('formatNumber','g',108,['number':(itemInstance.metallwertGesamt),'type':("number"),'minFractionDigits':("2"),'maxFractionDigits':("2"),'format':("###,##0.00")],-1)
printHtmlPart(39)
if(true && (itemInstance?.lagerungen)) {
printHtmlPart(40)
invokeTag('message','g',114,['code':("item.lagerungen.label"),'default':("Lagerungen")],-1)
printHtmlPart(41)
for( l in (itemInstance.lagerungen) ) {
printHtmlPart(42)
createTagBody(4, {->
expressionOut.print(l?.encodeAsHTML())
})
invokeTag('link','g',117,['controller':("lagerung"),'action':("show"),'id':(l.id)],4)
printHtmlPart(43)
}
printHtmlPart(44)
}
printHtmlPart(17)
if(true && (itemInstance?.geschenke)) {
printHtmlPart(40)
invokeTag('message','g',125,['code':("item.geschenke.label"),'default':("Geschenke")],-1)
printHtmlPart(41)
for( g in (itemInstance.geschenke) ) {
printHtmlPart(45)
createTagBody(4, {->
expressionOut.print(g?.encodeAsHTML())
})
invokeTag('link','g',128,['controller':("geschenk"),'action':("show"),'id':(g.id)],4)
printHtmlPart(43)
}
printHtmlPart(44)
}
printHtmlPart(46)
createTagBody(2, {->
printHtmlPart(47)
createTagBody(3, {->
invokeTag('message','g',137,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',137,['class':("edit"),'action':("edit"),'resource':(itemInstance)],3)
printHtmlPart(48)
invokeTag('actionSubmit','g',138,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(49)
})
invokeTag('form','g',140,['url':([resource:itemInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(50)
})
invokeTag('captureBody','sitemesh',142,[:],1)
printHtmlPart(51)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1595518148000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
