
<%@ page import="org.strotmann.metals.Lagerort" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'lagerort.label', default: 'Lagerort')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-lagerort" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li><g:link class="list" action="listItems" id="${lagerortInstance.id}">gelagerte Items</g:link></li>
			</ul>
		</div>
		<div id="show-lagerort" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list lagerort">
			
				<g:if test="${lagerortInstance?.location}">
				<li class="fieldcontain">
					<span id="location-label" class="property-label"><g:message code="lagerort.location.label" default="Location" /></span>
					
						<span class="property-value" aria-labelledby="location-label"><g:fieldValue bean="${lagerortInstance}" field="location"/></span>
					
				</li>
				</g:if>
			
				
				<g:if test="${lagerortInstance?.subLocation}">
				<li class="fieldcontain">
					<span id="subLocation-label" class="property-label"><g:message code="lagerort.subLocation.label" default="Sub Location" /></span>
					
						<span class="property-value" aria-labelledby="subLocation-label"><g:fieldValue bean="${lagerortInstance}" field="subLocation"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${lagerortInstance?.kostenProJahr}">
				<li class="fieldcontain">
					<span id="kostenProJahr-label" class="property-label"><g:message code="lagerort.kostenProJahr.label" default="Kosten Pro Jahr" /></span>
					
						<span class="property-value" aria-labelledby="kostenProJahr-label"><g:fieldValue bean="${lagerortInstance}" field="kostenProJahr"/></span>
					
				</li>
				</g:if>
			
				
			</ol>
			<g:form url="[resource:lagerortInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${lagerortInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
