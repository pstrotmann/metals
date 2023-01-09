
<%@ page import="org.strotmann.metals.Lagerung" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'lagerung.label', default: 'Lagerung')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-lagerung" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-lagerung" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list lagerung">
			
				<g:if test="${lagerungInstance?.anzahl}">
				<li class="fieldcontain">
					<span id="anzahl-label" class="property-label"><g:message code="lagerung.anzahl.label" default="Anzahl" /></span>
					
						<span class="property-value" aria-labelledby="anzahl-label"><g:fieldValue bean="${lagerungInstance}" field="anzahl"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${lagerungInstance?.item}">
				<li class="fieldcontain">
					<span id="item-label" class="property-label"><g:message code="lagerung.item.label" default="Item" /></span>
					
						<span class="property-value" aria-labelledby="item-label"><g:link controller="item" action="show" id="${lagerungInstance?.item?.id}">${lagerungInstance?.item?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${lagerungInstance?.lagerort}">
				<li class="fieldcontain">
					<span id="lagerort-label" class="property-label"><g:message code="lagerung.lagerort.label" default="Lagerort" /></span>
					
						<span class="property-value" aria-labelledby="lagerort-label"><g:link controller="lagerort" action="show" id="${lagerungInstance?.lagerort?.id}">${lagerungInstance?.lagerort?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:lagerungInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${lagerungInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
