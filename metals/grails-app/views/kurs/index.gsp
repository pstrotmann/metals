
<%@ page import="org.strotmann.metals.Kurs" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'kurs.label', default: 'Kurs')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-kurs" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li><g:link class="edit" action="updateKurse"><g:message code="default.webUpdate.label"/></g:link></li>
			</ul>
		</div>
		<div id="list-kurs" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:if test="${flash.message1}">
				<div class="message">${flash.message1}</div>
			</g:if>
			
			<table>
				<thead>
					<tr>
						<th><div align = left>Devisen</div></th>
						<th><div align = right>US$ zum €</div></th>	
						<th><div align = right>€ zum US$</div></th>	
						<th><div align = right></div></th>
						<th><div align = right></div></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><div align = right></div></td>
						<td><div align = right><g:formatNumber number="${kursInstanceList[0].kursDollarJeEuro}" type="number" minFractionDigits="2" minIntegerDigits="1" format="##,##0.00"/></div></td>
						<td><div align = right><g:formatNumber number="${kursInstanceList[0].kursEuroJeDollar}" type="number" minFractionDigits="2" minIntegerDigits="1" format="##,##0.00"/></div></td>
						<td><div align = right></div></td>
						<td><div align = right></div></td>
					</tr>
				</tbody>
			</table>
			
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="metall" title="${message(code: 'kurs.metall.label', default: 'Metalle')}" />						

						<th><div align = right>€ Je Unze</div></th>
						
						<th><div align = right>US$ Je Unze</div></th>
						
						<th><div align = right>€ Je Kg</div></th>
						
						<th><div align = right>US$ Je Kg</div></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${kursInstanceList}" status="i" var="kursInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${kursInstance.id}">${fieldValue(bean: kursInstance, field: "metallDE")}</g:link></td>
						
						<td><div align = right><g:formatNumber number="${kursInstance.kursInEuroJeUnze}" type="number" minFractionDigits="2" minIntegerDigits="1" format="##,##0.00"/></div></td>
						
						<td><div align = right><g:formatNumber number="${kursInstance.kursInDollarJeUnze}" type="number" minFractionDigits="2" minIntegerDigits="1" format="##,##0.00"/></div></td>
						
						<td><div align = right><g:formatNumber number="${kursInstance.kursInEuroJeKg}" type="number" minFractionDigits="2" minIntegerDigits="1" format="##,##0.00"/></div></td>
						
						<td><div align = right><g:formatNumber number="${kursInstance.kursInDollarJeKg}" type="number" minFractionDigits="2" minIntegerDigits="1" format="##,##0.00"/></div></td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${kursInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
