import org.strotmann.metals.Item
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_metals_itemindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/item/index.gsp" }
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
invokeTag('message','g',8,['code':("default.list.label"),'args':([entityName])],-1)
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
invokeTag('message','g',15,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("create"),'action':("create")],2)
printHtmlPart(8)
invokeTag('message','g',19,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(9)
if(true && (itemInstanceMetall)) {
printHtmlPart(10)
expressionOut.print(itemInstanceMetall)
printHtmlPart(9)
}
else {
printHtmlPart(9)
}
printHtmlPart(11)
if(true && (flash.message)) {
printHtmlPart(12)
expressionOut.print(flash.message)
printHtmlPart(13)
}
printHtmlPart(14)
invokeTag('sortableColumn','g',33,['property':("bezeichnung"),'title':(message(code: 'item.bezeichnung.label', default: 'Bezeichnung'))],-1)
printHtmlPart(15)
if(true && (!itemInstanceMetall)) {
printHtmlPart(16)
invokeTag('sortableColumn','g',36,['property':("metall"),'title':(message(code: 'item.metall.label', default: 'Metall'))],-1)
printHtmlPart(17)
}
printHtmlPart(18)
invokeTag('sortableColumn','g',40,['property':("gewEinheit"),'title':(message(code: 'item.gewEinheit.label', default: 'Einheit'))],-1)
printHtmlPart(19)
loop:{
int i = 0
for( itemInstance in (itemInstanceList) ) {
printHtmlPart(20)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(21)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: itemInstance, field: "bezeichnung"))
})
invokeTag('link','g',52,['action':("show"),'id':(itemInstance.id)],3)
printHtmlPart(22)
if(true && (!itemInstanceMetall)) {
printHtmlPart(23)
expressionOut.print(fieldValue(bean: itemInstance, field: "metall"))
printHtmlPart(24)
}
printHtmlPart(25)
invokeTag('formatNumber','g',58,['number':(itemInstance.gewicht),'type':("number"),'minFractionDigits':("2"),'format':("#,##0.00")],-1)
printHtmlPart(26)
expressionOut.print(fieldValue(bean: itemInstance, field: "gewEinheit"))
printHtmlPart(27)
invokeTag('formatNumber','g',62,['number':(itemInstance.anzahlGesamt),'type':("number"),'format':("#,##0")],-1)
printHtmlPart(28)
invokeTag('formatNumber','g',64,['number':(itemInstance.metallwertGesamt),'type':("number"),'minFractionDigits':("2"),'maxFractionDigits':("2"),'format':("#,##0.00")],-1)
printHtmlPart(29)
i++
}
}
printHtmlPart(30)
if(true && (itemInstanceMetall)) {
printHtmlPart(31)
invokeTag('message','g',73,['code':("item.summe.label"),'default':("Summen:")],-1)
printHtmlPart(32)
invokeTag('formatNumber','g',74,['number':(itemInstanceGewOzSumme),'type':("number"),'minFractionDigits':("2"),'maxFractionDigits':("2"),'format':("###,##0.00")],-1)
printHtmlPart(33)
invokeTag('formatNumber','g',75,['number':(itemInstanceGewGrSumme),'type':("number"),'minFractionDigits':("2"),'maxFractionDigits':("2"),'format':("###,##0.00")],-1)
printHtmlPart(34)
}
else {
printHtmlPart(35)
invokeTag('message','g',81,['code':("item.summe.label"),'default':("Summe:")],-1)
printHtmlPart(34)
}
printHtmlPart(36)
invokeTag('formatNumber','g',83,['number':(itemInstanceSumme),'type':("number"),'minFractionDigits':("2"),'maxFractionDigits':("2"),'format':("###,##0.00")],-1)
printHtmlPart(37)
invokeTag('paginate','g',88,['total':(itemInstanceCount ?: 0)],-1)
printHtmlPart(38)
})
invokeTag('captureBody','sitemesh',91,[:],1)
printHtmlPart(39)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1565196971000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
