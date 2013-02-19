
<%@ page import="za.co.ang.voucher.Merchant" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'merchant.label', default: 'Merchant')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-merchant" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-merchant" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list merchant">
			
				<g:if test="${merchantInstance?.businessName}">
				<li class="fieldcontain">
					<span id="businessName-label" class="property-label"><g:message code="merchant.businessName.label" default="Business Name" /></span>
					
						<span class="property-value" aria-labelledby="businessName-label"><g:fieldValue bean="${merchantInstance}" field="businessName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${merchantInstance?.credentials}">
				<li class="fieldcontain">
					<span id="credentials-label" class="property-label"><g:message code="merchant.credentials.label" default="Credentials" /></span>
					
						<span class="property-value" aria-labelledby="credentials-label"><g:link controller="credentials" action="show" id="${merchantInstance?.credentials?.id}">${merchantInstance?.credentials?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${merchantInstance?.physicalAddress}">
				<li class="fieldcontain">
					<span id="physicalAddress-label" class="property-label"><g:message code="merchant.physicalAddress.label" default="Physical Address" /></span>
					
						<span class="property-value" aria-labelledby="physicalAddress-label"><g:link controller="address" action="show" id="${merchantInstance?.physicalAddress?.id}">${merchantInstance?.physicalAddress?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${merchantInstance?.postalAddress}">
				<li class="fieldcontain">
					<span id="postalAddress-label" class="property-label"><g:message code="merchant.postalAddress.label" default="Postal Address" /></span>
					
						<span class="property-value" aria-labelledby="postalAddress-label"><g:link controller="address" action="show" id="${merchantInstance?.postalAddress?.id}">${merchantInstance?.postalAddress?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${merchantInstance?.id}" />
					<g:link class="edit" action="edit" id="${merchantInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
