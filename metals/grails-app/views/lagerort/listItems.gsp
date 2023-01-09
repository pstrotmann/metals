<%@ page import="org.strotmann.metals.Item" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'item.label', default: 'Item')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-item" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args=" "/> Lagerorte</g:link></li>
			</ul>
		</div>
		<div id="list-item" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /> ${lagerortInstance}</h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="bezeichnung" title="${message(code: 'item.bezeichnung.label', default: 'Bezeichnung')}" />
						
						<g:sortableColumn property="metall" title="${message(code: 'item.metall.label', default: 'Metall')}" />
						
						<th><div align = right>Gewicht</div></th>
					
						<g:sortableColumn property="gewEinheit" title="${message(code: 'item.gewEinheit.label', default: 'Einheit')}" />
					
						<th><div align = right>Anzahl</div></th>
						
						<th><div align = right>Metallwert €</div></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${lagerortInstance.items}" status="i" var="itemInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link controller="item" action="show" id="${itemInstance.id}">${fieldValue(bean: itemInstance, field: "bezeichnung")}</g:link></td>
						
						<td>${fieldValue(bean: itemInstance, field: "metall")}</td>
						
 	 				  	<td><div align = right><g:formatNumber number="${itemInstance.gewicht}" type="number" minFractionDigits="2" format="#,##0.00"/></div></td>
					
						<td>${fieldValue(bean: itemInstance, field: "gewEinheit")}</td>
						
						<td><div align = right><g:formatNumber number="${itemInstance.anzahlLager(lagerortInstance.id)}" type="number" format="#,##0"/></div></td>
						
						<td><div align = right><g:formatNumber number="${itemInstance.metallwertLager(lagerortInstance.id)}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
					
					</tr>
				</g:each>
				</tbody>
				<tfoot>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><div align = right><g:message code="item.summe.label" default="Summe" /></div></td>
						<td><div align = right><g:formatNumber number="${lagerortInstance.summe}" type="number" minFractionDigits="2" maxFractionDigits="2" format="###,##0.00"/></div></td>
					</tr>
				</tfoot>
			</table>
			<div class="pagination">
				<g:paginate total="${itemInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>