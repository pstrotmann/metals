
<%@ page import="org.strotmann.metals.Item" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'item.label', default: 'Item')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-item" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-item" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list item">
			
				<g:if test="${itemInstance?.bezeichnung}">
				<li class="fieldcontain">
					<span id="bezeichnung-label" class="property-label"><g:message code="item.bezeichnung.label" default="Bezeichnung" /></span>
					
						<span class="property-value" aria-labelledby="bezeichnung-label"><g:fieldValue bean="${itemInstance}" field="bezeichnung"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${itemInstance?.metall}">
				<li class="fieldcontain">
					<span id="metall-label" class="property-label"><g:message code="item.metall.label" default="Metall" /></span>
					
						<span class="property-value" aria-labelledby="metall-label"><g:fieldValue bean="${itemInstance}" field="metall"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${itemInstance?.gewicht}">
				<li class="fieldcontain">
					<span id="gewicht-label" class="property-label"><g:message code="item.gewicht.label" default="Gewicht" /></span>
					
						<span class="property-value" aria-labelledby="gewicht-label"><g:fieldValue bean="${itemInstance}" field="gewicht"/></span>
					
				</li>
				</g:if>
			
			
				<g:if test="${itemInstance?.gewEinheit}">
				<li class="fieldcontain">
					<span id="gewEinheit-label" class="property-label"><g:message code="item.gewEinheit.label" default="Gew Einheit" /></span>
					
						<span class="property-value" aria-labelledby="gewEinheit-label"><g:fieldValue bean="${itemInstance}" field="gewEinheit"/></span>
					
				</li>
				</g:if>
			

				<g:if test="${itemInstance?.sammlerwert}">
				<li class="fieldcontain">
					<span id="sammlerwert-label" class="property-label"><g:message code="item.sammlerwert.label" default="Sammlerwert" /></span>
					
						<span class="property-value" aria-labelledby="sammlerwert-label"><g:fieldValue bean="${itemInstance}" field="sammlerwert"/></span>
					
				</li>
				</g:if>

				<g:if test="${itemInstance?.umlaufwert}">
				<li class="fieldcontain">
					<span id="umlaufwert-label" class="property-label"><g:message code="item.umlaufwert.label" default="Umlaufwert €" /></span>
					
						<span class="property-value" aria-labelledby="umlaufwert-label"><g:fieldValue bean="${itemInstance}" field="umlaufwert"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${itemInstance?.feingehalt}">
				<li class="fieldcontain">
					<span id="feingehalt-label" class="property-label"><g:message code="item.feingehalt.label" default="Feingehalt" /></span>
					
						<span class="property-value" aria-labelledby="feingehalt-label"><g:fieldValue bean="${itemInstance}" field="feingehalt"/></span>
					
				</li>
				</g:if>
							
				<li class="fieldcontain">
					<span id="metallwert1-label" class="property-label"><g:message code="item.metallwert1.label" default="Metallwert Einzeln €" /></span>
					
						<span class="property-value" aria-labelledby="metallwert1"><g:formatNumber number="${itemInstance.metallwert}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></span>
					
				</li>
				
				<li class="fieldcontain">
					<span id="anzahl-label" class="property-label"><g:message code="item.anzahl.label" default="Anzahl" /></span>
					
						<span class="property-value" aria-labelledby="anzahl-label"><g:fieldValue bean="${itemInstance}" field="anzahlGesamt"/></span>
					
				</li>
							
				<li class="fieldcontain">
					<span id="metallwert-label" class="property-label"><g:message code="item.metallwert.label" default="Metallwert Gesamt €" /></span>
					
						<span class="property-value" aria-labelledby="metallwert-label"><g:formatNumber number="${itemInstance.metallwertGesamt}" type="number" minFractionDigits="2" maxFractionDigits="2" format="###,##0.00"/></span>
					
				</li>
				
				<g:if test="${itemInstance?.lagerungen}">
				<li class="fieldcontain">
					<span id="lagerungen-label" class="property-label"><g:message code="item.lagerungen.label" default="Lagerungen" /></span>
					
						<g:each in="${itemInstance.lagerungen}" var="l">
						<span class="property-value" aria-labelledby="lagerungen-label"><g:link controller="lagerung" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
				<g:if test="${itemInstance?.geschenke}">
				<li class="fieldcontain">
					<span id="lagerungen-label" class="property-label"><g:message code="item.geschenke.label" default="Geschenke" /></span>
					
						<g:each in="${itemInstance.geschenke}" var="g">
						<span class="property-value" aria-labelledby="geschenke-label"><g:link controller="geschenk" action="show" id="${g.id}">${g?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:itemInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${itemInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
