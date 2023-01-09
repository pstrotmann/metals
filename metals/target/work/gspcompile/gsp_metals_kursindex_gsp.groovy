import org.strotmann.metals.Kurs
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_metals_kursindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/kurs/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'kurs.label', default: 'Kurs'))],-1)
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
createTagBody(2, {->
invokeTag('message','g',16,['code':("default.webUpdate.label")],-1)
})
invokeTag('link','g',16,['class':("edit"),'action':("updateKurse")],2)
printHtmlPart(9)
invokeTag('message','g',20,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (flash.message1)) {
printHtmlPart(14)
expressionOut.print(flash.message1)
printHtmlPart(12)
}
printHtmlPart(15)
invokeTag('formatNumber','g',41,['number':(kursInstanceList[0].kursDollarJeEuro),'type':("number"),'minFractionDigits':("2"),'minIntegerDigits':("1"),'format':("##,##0.00")],-1)
printHtmlPart(16)
invokeTag('formatNumber','g',42,['number':(kursInstanceList[0].kursEuroJeDollar),'type':("number"),'minFractionDigits':("2"),'minIntegerDigits':("1"),'format':("##,##0.00")],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',53,['property':("metall"),'title':(message(code: 'kurs.metall.label', default: 'Metalle'))],-1)
printHtmlPart(18)
loop:{
int i = 0
for( kursInstance in (kursInstanceList) ) {
printHtmlPart(19)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(20)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: kursInstance, field: "metallDE"))
})
invokeTag('link','g',69,['action':("show"),'id':(kursInstance.id)],3)
printHtmlPart(21)
invokeTag('formatNumber','g',71,['number':(kursInstance.kursInEuroJeUnze),'type':("number"),'minFractionDigits':("2"),'minIntegerDigits':("1"),'format':("##,##0.00")],-1)
printHtmlPart(22)
invokeTag('formatNumber','g',73,['number':(kursInstance.kursInDollarJeUnze),'type':("number"),'minFractionDigits':("2"),'minIntegerDigits':("1"),'format':("##,##0.00")],-1)
printHtmlPart(22)
invokeTag('formatNumber','g',75,['number':(kursInstance.kursInEuroJeKg),'type':("number"),'minFractionDigits':("2"),'minIntegerDigits':("1"),'format':("##,##0.00")],-1)
printHtmlPart(22)
invokeTag('formatNumber','g',77,['number':(kursInstance.kursInDollarJeKg),'type':("number"),'minFractionDigits':("2"),'minIntegerDigits':("1"),'format':("##,##0.00")],-1)
printHtmlPart(23)
i++
}
}
printHtmlPart(24)
invokeTag('paginate','g',83,['total':(kursInstanceCount ?: 0)],-1)
printHtmlPart(25)
})
invokeTag('captureBody','sitemesh',86,[:],1)
printHtmlPart(26)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1673188990000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
