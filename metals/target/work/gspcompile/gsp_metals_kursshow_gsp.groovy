import org.strotmann.metals.Kurs
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_metals_kursshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/kurs/show.gsp" }
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
if(true && (kursInstance?.metall)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("kurs.metall.label"),'default':("Metall")],-1)
printHtmlPart(15)
if(true && (kursInstance.metall == 'au')) {
printHtmlPart(16)
createTagBody(4, {->
invokeTag('fieldValue','g',32,['bean':(kursInstance),'field':("metallDE")],-1)
})
invokeTag('link','g',32,['uri':("https://www.finanzen.net/rohstoffe/goldpreis")],4)
printHtmlPart(17)
}
printHtmlPart(17)
if(true && (kursInstance.metall == 'pl')) {
printHtmlPart(16)
createTagBody(4, {->
invokeTag('fieldValue','g',35,['bean':(kursInstance),'field':("metallDE")],-1)
})
invokeTag('link','g',35,['uri':("https://www.finanzen.net/rohstoffe/platinpreis")],4)
printHtmlPart(17)
}
printHtmlPart(17)
if(true && (kursInstance.metall == 'ag')) {
printHtmlPart(16)
createTagBody(4, {->
invokeTag('fieldValue','g',38,['bean':(kursInstance),'field':("metallDE")],-1)
})
invokeTag('link','g',38,['uri':("https://www.finanzen.net/rohstoffe/silberpreis")],4)
printHtmlPart(17)
}
printHtmlPart(17)
if(true && (kursInstance.metall == 'pd')) {
printHtmlPart(16)
createTagBody(4, {->
invokeTag('fieldValue','g',41,['bean':(kursInstance),'field':("metallDE")],-1)
})
invokeTag('link','g',41,['uri':("https://www.finanzen.net/rohstoffe/palladiumpreis")],4)
printHtmlPart(17)
}
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (kursInstance?.kursInDollarJeUnze)) {
printHtmlPart(20)
invokeTag('message','g',50,['code':("kurs.kursInDollarJeUnze.label"),'default':("Kurs In Dollar Je Unze")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',52,['bean':(kursInstance),'field':("kursInDollarJeUnze")],-1)
printHtmlPart(22)
}
printHtmlPart(19)
if(true && (kursInstance?.kursInEuroJeKg)) {
printHtmlPart(23)
invokeTag('message','g',59,['code':("kurs.kursInEuroJeKg.label"),'default':("Kurs In Euro Je Kg")],-1)
printHtmlPart(24)
invokeTag('fieldValue','g',61,['bean':(kursInstance),'field':("kursInEuroJeKg")],-1)
printHtmlPart(22)
}
printHtmlPart(19)
if(true && (kursInstance?.kursInDollarJeKg)) {
printHtmlPart(25)
invokeTag('message','g',68,['code':("kurs.kursInDollarJeKg.label"),'default':("Kurs In Dollar Je Kg")],-1)
printHtmlPart(26)
invokeTag('fieldValue','g',70,['bean':(kursInstance),'field':("kursInDollarJeKg")],-1)
printHtmlPart(22)
}
printHtmlPart(19)
if(true && (kursInstance?.kursInEuroJeUnze)) {
printHtmlPart(27)
invokeTag('message','g',77,['code':("kurs.kursInEuroJeUnze.label"),'default':("Kurs In Euro Je Unze")],-1)
printHtmlPart(28)
invokeTag('fieldValue','g',79,['bean':(kursInstance),'field':("kursInEuroJeUnze")],-1)
printHtmlPart(22)
}
printHtmlPart(29)
createTagBody(2, {->
printHtmlPart(30)
createTagBody(3, {->
invokeTag('message','g',88,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',88,['class':("edit"),'action':("edit"),'resource':(kursInstance)],3)
printHtmlPart(31)
invokeTag('actionSubmit','g',89,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(32)
})
invokeTag('form','g',91,['url':([resource:kursInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(33)
})
invokeTag('captureBody','sitemesh',93,[:],1)
printHtmlPart(34)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1673188805000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
