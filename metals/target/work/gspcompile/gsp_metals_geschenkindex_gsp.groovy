import org.strotmann.metals.Geschenk
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_metals_geschenkindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/geschenk/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'geschenk.label', default: 'Geschenk'))],-1)
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
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
invokeTag('message','g',27,['code':("geschenk.item.label"),'default':("Item")],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',29,['property':("empfaenger"),'title':(message(code: 'geschenk.empfaenger.label', default: 'Empfänger'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',31,['property':("anlass"),'title':(message(code: 'geschenk.anlass.label', default: 'Anlass'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',33,['property':("datum"),'title':(message(code: 'geschenk.datum.label', default: 'Datum'))],-1)
printHtmlPart(16)
invokeTag('message','g',35,['code':("geschenk.€Wert.label"),'default':("Metallwert €")],-1)
printHtmlPart(17)
loop:{
int i = 0
for( geschenkInstance in (geschenkInstanceList) ) {
printHtmlPart(18)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(19)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: geschenkInstance, field: "item"))
})
invokeTag('link','g',43,['action':("show"),'id':(geschenkInstance.id)],3)
printHtmlPart(20)
expressionOut.print(fieldValue(bean: geschenkInstance, field: "empfaenger"))
printHtmlPart(20)
expressionOut.print(fieldValue(bean: geschenkInstance, field: "anlass"))
printHtmlPart(21)
invokeTag('formatDate','g',49,['date':(geschenkInstance.datum),'format':("dd.MM.yyyy")],-1)
printHtmlPart(22)
invokeTag('formatNumber','g',51,['number':(geschenkInstance.item.metallwert),'type':("number"),'minFractionDigits':("2"),'maxFractionDigits':("2"),'format':("#,##0.00")],-1)
printHtmlPart(23)
i++
}
}
printHtmlPart(24)
invokeTag('message','g',61,['code':("item.summe.label"),'default':("Summe:")],-1)
printHtmlPart(25)
invokeTag('formatNumber','g',62,['number':(geschenkSumme),'type':("number"),'minFractionDigits':("2"),'maxFractionDigits':("2"),'format':("###,##0.00")],-1)
printHtmlPart(26)
invokeTag('paginate','g',67,['total':(geschenkInstanceCount ?: 0)],-1)
printHtmlPart(27)
})
invokeTag('captureBody','sitemesh',70,[:],1)
printHtmlPart(28)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1595600212000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
