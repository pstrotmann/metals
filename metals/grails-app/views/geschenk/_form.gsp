<%@ page import="org.strotmann.metals.Geschenk" %>



<div class="fieldcontain ${hasErrors(bean: geschenkInstance, field: 'datum', 'error')} ">
	<label for="datum">
		<g:message code="geschenk.datum.label" default="Datum" />
		
	</label>
	<g:datePicker name="datum" precision="day" years="${2010..2030}" value="${geschenkInstance?.datum}" default="none" noSelection="['': '']" />
	
</div>

<div class="fieldcontain ${hasErrors(bean: geschenkInstance, field: 'anlass', 'error')} ">
	<label for="anlass">
		<g:message code="geschenk.anlass.label" default="Anlass" />
		
	</label>
	<g:textField name="anlass" value="${geschenkInstance?.anlass}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: geschenkInstance, field: 'empfaenger', 'error')} required">
	<label for="empfaenger">
		<g:message code="geschenk.empfaenger.label" default="Empfänger" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="empfaenger" required="" value="${geschenkInstance?.empfaenger}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: geschenkInstance, field: 'item', 'error')} required">
	<label for="item">
		<g:message code="geschenk.item.label" default="Item" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="item" name="item.id" from="${org.strotmann.metals.Item.list()}" optionKey="id" required="" value="${geschenkInstance?.item?.id}" class="many-to-one"/>

</div>

