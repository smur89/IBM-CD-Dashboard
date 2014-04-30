<%@ page import="ibm_cd_dashboard.Team; com.ibm.team.build.common.model.BuildState; com.ibm.team.workitem.common.model.WorkItemTypes" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <gvisualization:apiImport/>
    <title>Teams</title>
    <meta name="layout" content="application">
    <r:require module="jquery"/>
    <g:javascript src="d3/d3.js"/>
    <g:javascript src="d3/nv.d3.min.js"/>

</head>

<body>
<g:if test="${teams?.size() < 1}">
    <p>No Teams? Check your subscriptions in your user profile</p>
</g:if>
<sec:ifNotLoggedIn>
    <ul>
        <li>
            <g:link controller="login" action="auth">Log in</g:link> in to customise what teams you subscribe to.
        </li>
    </ul>
</sec:ifNotLoggedIn>

<table id="teamTable" class="lotusTable">
    <tbody>
    %{--Teams--}%
    <g:each status="i" in="${teams}" var="it">
    %{--Apply the lotusFirst class to the first row of the table--}%
        <tr class="${i == 0 ? 'lotusFirst' : 'lotusCell'}">
            <td class="lotusFirstCell">
                <h4 class="lotusTitle">
                    <g:link action="teamInfo" id="${it?.teamId}">${it?.teamName}</g:link>
                </h4>
            </td>
        </tr>
        <tr id="detailRowID_${it?.getTeamId()}" class="lotusDetails">
            <td class="lotusFirstCell" colspan="4">
            %{--
                Render Partial View _teamData
                Pass in jsonTimes for SVG
            --}%
                <%
                    def jsonTimes = []
                    if (it?.getBuilds()?.count { it } > 0) {
                        it?.getBuilds()?.each {
                            def timeMap = [
                                    name: it?.getName(),
                                    time: it?.getBuildTimeInMillis(),
                                    modified: it?.getModified()
                            ]
                            jsonTimes?.add(timeMap)
                        }
                    }
                %>

            %{--If there are no builds, there will be no graphs to display.--}%
                <g:if test="${jsonTimes.size() > 0}">
                    <fieldset class="form">
                        <g:render template="teamData" model="${[team: it, jsonTimes: jsonTimes]}"/>
                    </fieldset>
                </g:if>
                <g:else>
                    <table class="lotusVertTable" summary="No Commits">
                    <tr>
                        <th>There are no commits defined for this project</th>
                    </tr>
                    </table
                </g:else>
            </td>
        </tr>
    </g:each>
</table>

</body>
</html>