
<%@ page import="ibm_cd_dashboard.UserProfile" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="application">
		<g:set var="entityName" value="${message(code: 'userProfile.label', default: 'UserProfile')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>

	<body>
		<a href="#show-userProfile" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<sec:ifAllGranted roles="ROLE_ADMIN">
        <div class="nav" role="navigation">
			<ul>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
        </sec:ifAllGranted>
		<div id="show-userProfile" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list userProfile">
			
				<g:if test="${userProfileInstance?.user}">
				<li class="fieldcontain">
					<span id="user-label" class="property-label"><g:message code="userProfile.user.label" default="User" /></span>
				    <span class="property-value" aria-labelledby="user-label"><g:link controller="user" action="show" id="${userProfileInstance?.user?.id}">${userProfileInstance?.user?.encodeAsHTML()}</g:link></span>
				</li>
				</g:if>

                <g:each in="${projojojojoj}">
                    <p>dddd</p>
                </g:each>
			
			</ol>
			<g:form url="[resource:userProfileInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${userProfileInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
