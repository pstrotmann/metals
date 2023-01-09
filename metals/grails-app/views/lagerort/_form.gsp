<%@ page import="org.strotmann.metals.Lagerort" %>

<div class="fieldcontain ${hasErrors(bean: lagerortInstance, field: 'location', 'error')} required">
	<label for="location">
		<g:message code="lagerort.location.label" default="Location" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="location" required="" value="${lagerortInstance?.location}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: lagerortInstance, field: 'subLocation', 'error')} required">
	<label for="subLocation">
		<g:message code="lagerort.subLocation.label" default="Sub Location" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="subLocation" required="" value="${lagerortInstance?.subLocation}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: lagerortInstance, field: 'kostenProJahr', 'error')} ">
	<label for="kostenProJahr">
		<g:message code="lagerort.kostenProJahr.label" default="Kosten Pro Jahr" />
		
	</label>
	<g:field name="kostenProJahr" value="${fieldValue(bean: lagerortInstance, field: 'kostenProJahr')}"/>

</div>



