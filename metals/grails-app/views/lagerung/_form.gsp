<%@ page import="org.strotmann.metals.Lagerung" %>



<div class="fieldcontain ${hasErrors(bean: lagerungInstance, field: 'anzahl', 'error')} required">
	<label for="anzahl">
		<g:message code="lagerung.anzahl.label" default="Anzahl" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="anzahl" type="number" value="${lagerungInstance.anzahl}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: lagerungInstance, field: 'item', 'error')} required">
	<label for="item">
		<g:message code="lagerung.item.label" default="Item" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="item" name="item.id" from="${org.strotmann.metals.Item.list()}" optionKey="id" required="" value="${lagerungInstance?.item?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: lagerungInstance, field: 'lagerort', 'error')} required">
	<label for="lagerort">
		<g:message code="lagerung.lagerort.label" default="Lagerort" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="lagerort" name="lagerort.id" from="${org.strotmann.metals.Lagerort.list()}" optionKey="id" required="" value="${lagerungInstance?.lagerort?.id}" class="many-to-one"/>

</div>

