
<%@ page import="org.strotmann.metals.Geschenk" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'geschenk.label', default: 'Geschenk')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-geschenk" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-geschenk" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="geschenk.item.label" default="Item" /></th>
						
						<g:sortableColumn property="empfaenger" title="${message(code: 'geschenk.empfaenger.label', default: 'Empfänger')}" />
						
						<g:sortableColumn property="anlass" title="${message(code: 'geschenk.anlass.label', default: 'Anlass')}" />
					
						<g:sortableColumn property="datum" title="${message(code: 'geschenk.datum.label', default: 'Datum')}" />
						
						<th><div align = right><g:message code="geschenk.€Wert.label" default="Metallwert €" /></div></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${geschenkInstanceList}" status="i" var="geschenkInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${geschenkInstance.id}">${fieldValue(bean: geschenkInstance, field: "item")}</g:link></td>
						
						<td>${fieldValue(bean: geschenkInstance, field: "empfaenger")}</td>
						
						<td>${fieldValue(bean: geschenkInstance, field: "anlass")}</td>
					
						<td><g:formatDate date="${geschenkInstance.datum}" format="dd.MM.yyyy"/></td>
						
						<td><div align = right><g:formatNumber number="${geschenkInstance.item.metallwert}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
											
					</tr>
				</g:each>
				</tbody>
				<tfoot>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td><div align = right><g:message code="item.summe.label" default="Summe:" /></div></td>
						<td><div align = right><g:formatNumber number="${geschenkSumme}" type="number" minFractionDigits="2" maxFractionDigits="2" format="###,##0.00"/></div></td>
					</tr>
				</tfoot>
			</table>
			<div class="pagination">
				<g:paginate total="${geschenkInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
