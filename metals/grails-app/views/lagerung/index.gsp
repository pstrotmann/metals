
<%@ page import="org.strotmann.metals.Lagerung" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'lagerung.label', default: 'Lagerung')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-lagerung" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-lagerung" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="anzahl" title="${message(code: 'lagerung.anzahl.label', default: 'Anzahl')}" />
					
						<th><g:message code="lagerung.item.label" default="Item" /></th>
					
						<th><g:message code="lagerung.lagerort.label" default="Lagerort" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${lagerungInstanceList}" status="i" var="lagerungInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${lagerungInstance.id}">${fieldValue(bean: lagerungInstance, field: "anzahl")}</g:link></td>
					
						<td>${fieldValue(bean: lagerungInstance, field: "item")}</td>
					
						<td>${fieldValue(bean: lagerungInstance, field: "lagerort")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${lagerungInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
