
<%@ page import="za.co.ang.voucher.Merchant" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'merchant.label', default: 'Merchant')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-merchant" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-merchant" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="businessName" title="${message(code: 'merchant.businessName.label', default: 'Business Name')}" />
					
						<th><g:message code="merchant.credentials.label" default="Credentials" /></th>
					
						<th><g:message code="merchant.physicalAddress.label" default="Physical Address" /></th>
					
						<th><g:message code="merchant.postalAddress.label" default="Postal Address" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${merchantInstanceList}" status="i" var="merchantInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${merchantInstance.id}">${fieldValue(bean: merchantInstance, field: "businessName")}</g:link></td>
					
						<td>${fieldValue(bean: merchantInstance, field: "credentials")}</td>
					
						<td>${fieldValue(bean: merchantInstance, field: "physicalAddress")}</td>
					
						<td>${fieldValue(bean: merchantInstance, field: "postalAddress")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${merchantInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
