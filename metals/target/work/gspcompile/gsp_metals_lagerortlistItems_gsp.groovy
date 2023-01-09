import org.strotmann.metals.Item
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_metals_lagerortlistItems_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/lagerort/listItems.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'item.label', default: 'Item'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('message','g',10,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(4)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(5)
invokeTag('message','g',13,['code':("default.home.label")],-1)
printHtmlPart(6)
createTagBody(2, {->
invokeTag('message','g',14,['code':("default.list.label"),'args':(" ")],-1)
printHtmlPart(7)
})
invokeTag('link','g',14,['class':("list"),'action':("index")],2)
printHtmlPart(8)
invokeTag('message','g',18,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(9)
expressionOut.print(lagerortInstance)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('sortableColumn','g',26,['property':("bezeichnung"),'title':(message(code: 'item.bezeichnung.label', default: 'Bezeichnung'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',28,['property':("metall"),'title':(message(code: 'item.metall.label', default: 'Metall'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',32,['property':("gewEinheit"),'title':(message(code: 'item.gewEinheit.label', default: 'Einheit'))],-1)
printHtmlPart(16)
loop:{
int i = 0
for( itemInstance in (lagerortInstance.items) ) {
printHtmlPart(17)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(18)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: itemInstance, field: "bezeichnung"))
})
invokeTag('link','g',44,['controller':("item"),'action':("show"),'id':(itemInstance.id)],3)
printHtmlPart(19)
expressionOut.print(fieldValue(bean: itemInstance, field: "metall"))
printHtmlPart(20)
invokeTag('formatNumber','g',48,['number':(itemInstance.gewicht),'type':("number"),'minFractionDigits':("2"),'format':("#,##0.00")],-1)
printHtmlPart(21)
expressionOut.print(fieldValue(bean: itemInstance, field: "gewEinheit"))
printHtmlPart(22)
invokeTag('formatNumber','g',52,['number':(itemInstance.anzahlLager(lagerortInstance.id)),'type':("number"),'format':("#,##0")],-1)
printHtmlPart(23)
invokeTag('formatNumber','g',54,['number':(itemInstance.metallwertLager(lagerortInstance.id)),'type':("number"),'minFractionDigits':("2"),'maxFractionDigits':("2"),'format':("#,##0.00")],-1)
printHtmlPart(24)
i++
}
}
printHtmlPart(25)
invokeTag('message','g',65,['code':("item.summe.label"),'default':("Summe")],-1)
printHtmlPart(26)
invokeTag('formatNumber','g',66,['number':(lagerortInstance.summe),'type':("number"),'minFractionDigits':("2"),'maxFractionDigits':("2"),'format':("###,##0.00")],-1)
printHtmlPart(27)
invokeTag('paginate','g',71,['total':(itemInstanceCount ?: 0)],-1)
printHtmlPart(28)
})
invokeTag('captureBody','sitemesh',74,[:],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1563735085000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
