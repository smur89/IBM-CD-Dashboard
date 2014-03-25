<%@ page import="ibm_cd_dashboard.UserProfile" %>



<div class="fieldcontain ${hasErrors(bean: userProfileInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="userProfile.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${ibm_cd_dashboard.User.list()}" optionKey="id" required="" value="${userProfileInstance?.user?.id}" class="many-to-one"/>
</div>

