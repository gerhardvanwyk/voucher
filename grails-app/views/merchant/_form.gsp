<%@ page import="za.co.ang.voucher.Merchant" %>



<div class="fieldcontain ${hasErrors(bean: merchantInstance, field: 'businessName', 'error')} ">
	<label for="businessName">
		<g:message code="merchant.businessName.label" default="Business Name" />
		
	</label>
	<g:textField name="businessName" value="${merchantInstance?.businessName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: merchantInstance, field: 'credentials', 'error')} required">
	<label for="credentials">
		<g:message code="merchant.credentials.label" default="Credentials" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="credentials" name="credentials.id" from="${za.co.ang.voucher.Credentials.list()}" optionKey="id" required="" value="${merchantInstance?.credentials?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: merchantInstance, field: 'physicalAddress', 'error')} required">
	<label for="physicalAddress">
		<g:message code="merchant.physicalAddress.label" default="Physical Address" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="physicalAddress" name="physicalAddress.id" from="${za.co.ang.voucher.Address.list()}" optionKey="id" required="" value="${merchantInstance?.physicalAddress?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: merchantInstance, field: 'postalAddress', 'error')} required">
	<label for="postalAddress">
		<g:message code="merchant.postalAddress.label" default="Postal Address" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="postalAddress" name="postalAddress.id" from="${za.co.ang.voucher.Address.list()}" optionKey="id" required="" value="${merchantInstance?.postalAddress?.id}" class="many-to-one"/>
</div>

