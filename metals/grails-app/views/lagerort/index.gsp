
<%@ page import="org.strotmann.metals.Lagerort" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'lagerort.label', default: 'Lagerort')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-lagerort" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-lagerort" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="location" title="${message(code: 'lagerort.location.label', default: 'Location')}" />
					
						<g:sortableColumn property="subLocation" title="${message(code: 'lagerort.subLocation.label', default: 'Sub Location')}" />
					
						<g:sortableColumn property="kostenProJahr" title="${message(code: 'lagerort.kostenProJahr.label', default: 'Kosten Pro Jahr')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${lagerortInstanceList}" status="i" var="lagerortInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${lagerortInstance.id}">${fieldValue(bean: lagerortInstance, field: "location")}</g:link></td>
					
						<td>${fieldValue(bean: lagerortInstance, field: "subLocation")}</td>
						
						<td>${fieldValue(bean: lagerortInstance, field: "kostenProJahr")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${lagerortInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
