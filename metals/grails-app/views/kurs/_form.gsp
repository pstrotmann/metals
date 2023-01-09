<%@ page import="org.strotmann.metals.Kurs" %>



<div class="fieldcontain ${hasErrors(bean: kursInstance, field: 'metall', 'error')} required">
	<label for="metall">
		<g:message code="kurs.metall.label" default="Metall" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="metall" from="${kursInstance.constraints.metall.inList}" required="" value="${kursInstance?.metall}" valueMessagePrefix="kurs.metall"/>

</div>

<div class="fieldcontain ${hasErrors(bean: kursInstance, field: 'kursInDollarJeUnze', 'error')} ">
	<label for="kursInDollarJeUnze">
		<g:message code="kurs.kursInDollarJeUnze.label" default="Kurs In Dollar Je Unze" />
		
	</label>
	<g:field name="kursInDollarJeUnze" value="${fieldValue(bean: kursInstance, field: 'kursInDollarJeUnze')}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: kursInstance, field: 'kursInEuroJeKg', 'error')} ">
	<label for="kursInEuroJeKg">
		<g:message code="kurs.kursInEuroJeKg.label" default="Kurs In Euro Je Kg" />
		
	</label>
	<g:field name="kursInEuroJeKg" value="${fieldValue(bean: kursInstance, field: 'kursInEuroJeKg')}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: kursInstance, field: 'kursInDollarJeKg', 'error')} ">
	<label for="kursInDollarJeKg">
		<g:message code="kurs.kursInDollarJeKg.label" default="Kurs In Dollar Je Kg" />
		
	</label>
	<g:field name="kursInDollarJeKg" value="${fieldValue(bean: kursInstance, field: 'kursInDollarJeKg')}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: kursInstance, field: 'kursInEuroJeUnze', 'error')} required">
	<label for="kursInEuroJeUnze">
		<g:message code="kurs.kursInEuroJeUnze.label" default="Kurs In Euro Je Unze" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="kursInEuroJeUnze" value="${fieldValue(bean: kursInstance, field: 'kursInEuroJeUnze')}" required=""/>

</div>

