
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
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-item" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" />
				<g:if test ="${itemInstanceMetall}">
					${itemInstanceMetall}
				</g:if>
				<g:else>
				</g:else>
			</h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="bezeichnung" title="${message(code: 'item.bezeichnung.label', default: 'Bezeichnung')}" />
						
						<g:if test ="${!itemInstanceMetall}">
							<g:sortableColumn property="metall" title="${message(code: 'item.metall.label', default: 'Metall')}" />
						</g:if>
						<th><div align = right>Gewicht</div></th>
					
						<g:sortableColumn property="gewEinheit" title="${message(code: 'item.gewEinheit.label', default: 'Einheit')}" />
					
						<th><div align = right>Anzahl</div></th>
						
						<th><div align = right>Metallwert €</div></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${itemInstanceList}" status="i" var="itemInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${itemInstance.id}">${fieldValue(bean: itemInstance, field: "bezeichnung")}</g:link></td>
						
						<g:if test ="${!itemInstanceMetall}">
							<td>${fieldValue(bean: itemInstance, field: "metall")}</td>
						</g:if>						
						
 	 				  	<td><div align = right><g:formatNumber number="${itemInstance.gewicht}" type="number" minFractionDigits="2" format="#,##0.00"/></div></td>
					
						<td>${fieldValue(bean: itemInstance, field: "gewEinheit")}</td>
						
						<td><div align = right><g:formatNumber number="${itemInstance.anzahlGesamt}" type="number" format="#,##0"/></div></td>
						
						<td><div align = right><g:formatNumber number="${itemInstance.metallwertGesamt}" type="number" minFractionDigits="2" maxFractionDigits="2" format="#,##0.00"/></div></td>
					
					</tr>
				</g:each>
				</tbody>
				<tfoot>
					<tr>
						<td></td>
						<g:if test ="${itemInstanceMetall}">
							<td><div align = right><g:message code="item.summe.label" default="Summen:" /></div></td>
							<td><div align = left>oz <g:formatNumber number="${itemInstanceGewOzSumme}" type="number" minFractionDigits="2" maxFractionDigits="2" format="###,##0.00"/></div></td>
							<td><div align = right>gr <g:formatNumber number="${itemInstanceGewGrSumme}" type="number" minFractionDigits="2" maxFractionDigits="2" format="###,##0.00"/></div></td>
						</g:if>
						<g:else>
							<td></td>
							<td></td>
							<td></td>
							<td><div align = right><g:message code="item.summe.label" default="Summe:" /></div></td>
						</g:else>
						<td><div align = right><g:formatNumber number="${itemInstanceSumme}" type="number" minFractionDigits="2" maxFractionDigits="2" format="###,##0.00"/></div></td>
					</tr>
				</tfoot>
			</table>
			<div class="pagination">
				<g:paginate total="${itemInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
