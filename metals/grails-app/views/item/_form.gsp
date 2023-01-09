<%@ page import="org.strotmann.metals.Item" %>


<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'bezeichnung', 'error')} required">
	<label for="bezeichnung">
		<g:message code="item.bezeichnung.label" default="Bezeichnung" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="bezeichnung" required="" value="${itemInstance?.bezeichnung}"/>

</div>


<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'metall', 'error')} required">
	<label for="metall">
		<g:message code="item.metall.label" default="Metall" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="metall" from="${itemInstance.constraints.metall.inList}" required="" value="${itemInstance?.metall}" valueMessagePrefix="item.metall"/>

</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'gewicht', 'error')} required">
	<label for="gewicht">
		<g:message code="item.gewicht.label" default="Gewicht" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="gewicht" value="${fieldValue(bean: itemInstance, field: 'gewicht')}" required=""/>

</div>


<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'gewEinheit', 'error')} required">
	<label for="gewEinheit">
		<g:message code="item.gewEinheit.label" default="Gew Einheit" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="gewEinheit" from="${itemInstance.constraints.gewEinheit.inList}" required="" value="${itemInstance?.gewEinheit}" valueMessagePrefix="item.gewEinheit"/>

</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'sammlerwert', 'error')} ">
	<label for="sammlerwert">
		<g:message code="item.sammlerwert.label" default="Sammlerwert" />
		
	</label>
	<g:field name="sammlerwert" value="${fieldValue(bean: itemInstance, field: 'sammlerwert')}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'umlaufwert', 'error')} ">
	<label for="umlaufwert">
		<g:message code="item.umlaufwert.label" default="Umlaufwert" />
		
	</label>
	<g:field name="umlaufwert" value="${fieldValue(bean: itemInstance, field: 'umlaufwert')}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'feingehalt', 'error')} ">
	<label for="feingehalt">
		<g:message code="item.feingehalt.label" default="Feingehalt" />
		
	</label>
	<g:field name="feingehalt" value="${fieldValue(bean: itemInstance, field: 'feingehalt')}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'lagerungen', 'error')} ">
	<label for="lagerungen">
		<g:message code="item.lagerungen.label" default="Lagerungen" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${itemInstance?.lagerungen?}" var="l">
    <li><g:link controller="lagerung" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="lagerung" action="create" params="['item.id': itemInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'lagerung.label', default: 'Lagerung')])}</g:link>
</li>
</ul>


</div>

