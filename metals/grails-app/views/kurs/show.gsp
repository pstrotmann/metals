
<%@ page import="org.strotmann.metals.Kurs" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'kurs.label', default: 'Kurs')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-kurs" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-kurs" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list kurs">
			
				<g:if test="${kursInstance?.metall}">
				<li class="fieldcontain">
					<span id="metall-label" class="property-label"><g:message code="kurs.metall.label" default="Metall" /></span>
					
						<span class="property-value" aria-labelledby="metall-label">
							<g:if test="${kursInstance.metall == 'au'}">
								<g:link uri="https://www.finanzen.net/rohstoffe/goldpreis"><g:fieldValue bean="${kursInstance}" field="metallDE"/></g:link>
							</g:if>
							<g:if test="${kursInstance.metall == 'pl'}">
								<g:link uri="https://www.finanzen.net/rohstoffe/platinpreis"><g:fieldValue bean="${kursInstance}" field="metallDE"/></g:link>
							</g:if>
							<g:if test="${kursInstance.metall == 'ag'}">
								<g:link uri="https://www.finanzen.net/rohstoffe/silberpreis"><g:fieldValue bean="${kursInstance}" field="metallDE"/></g:link>
							</g:if>
							<g:if test="${kursInstance.metall == 'pd'}">
								<g:link uri="https://www.finanzen.net/rohstoffe/palladiumpreis"><g:fieldValue bean="${kursInstance}" field="metallDE"/></g:link>
							</g:if>
						</span>
					
				</li>
				</g:if>
			
				<g:if test="${kursInstance?.kursInDollarJeUnze}">
				<li class="fieldcontain">
					<span id="kursInDollarJeUnze-label" class="property-label"><g:message code="kurs.kursInDollarJeUnze.label" default="Kurs In Dollar Je Unze" /></span>
					
						<span class="property-value" aria-labelledby="kursInDollarJeUnze-label"><g:fieldValue bean="${kursInstance}" field="kursInDollarJeUnze"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${kursInstance?.kursInEuroJeKg}">
				<li class="fieldcontain">
					<span id="kursInEuroJeKg-label" class="property-label"><g:message code="kurs.kursInEuroJeKg.label" default="Kurs In Euro Je Kg" /></span>
					
						<span class="property-value" aria-labelledby="kursInEuroJeKg-label"><g:fieldValue bean="${kursInstance}" field="kursInEuroJeKg"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${kursInstance?.kursInDollarJeKg}">
				<li class="fieldcontain">
					<span id="kursInDollarJeKg-label" class="property-label"><g:message code="kurs.kursInDollarJeKg.label" default="Kurs In Dollar Je Kg" /></span>
					
						<span class="property-value" aria-labelledby="kursInDollarJeKg-label"><g:fieldValue bean="${kursInstance}" field="kursInDollarJeKg"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${kursInstance?.kursInEuroJeUnze}">
				<li class="fieldcontain">
					<span id="kursInEuroJeUnze-label" class="property-label"><g:message code="kurs.kursInEuroJeUnze.label" default="Kurs In Euro Je Unze" /></span>
					
						<span class="property-value" aria-labelledby="kursInEuroJeUnze-label"><g:fieldValue bean="${kursInstance}" field="kursInEuroJeUnze"/></span>
					
				</li>
				</g:if>
				
							
			</ol>
			<g:form url="[resource:kursInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${kursInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
