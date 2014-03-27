<%@ page import="ibm_cd_dashboard.User; ibm_cd_dashboard.Team; ibm_cd_dashboard.UserProfile" %>



<div class="fieldcontain ${hasErrors(bean: userProfileInstance, field: 'user', 'error')} required">
    <label for="user">
        <g:message code="userProfile.user.label" default="User"/>
        <span class="required-indicator">*</span>
    </label>
    <g:select id="user" name="user.id" from="${userProfileInstance.user}" optionKey="id" required=""
              value="${userProfileInstance?.user?.id}" class="many-to-one"/>

    <g:each var="team" in="${Team.getAll()}">
        <p>
            <g:if test="${userProfileInstance?.projects?.contains(team.getId())}">
                <g:checkBox name="checkbox.${team.getTeamId()}" checked="true" value="${team.id}"/>
            </g:if>
            <g:else>
                <g:checkBox name="checkbox.${team.getTeamId()}" checked="false" value="${team.id}"/>
            </g:else>
            <label for="${team}">
                ${team.teamName}
            </label>
        </p>
    </g:each>
</div>

