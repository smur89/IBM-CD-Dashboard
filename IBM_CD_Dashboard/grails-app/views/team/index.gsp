<%--
  Created by IntelliJ IDEA.
  User: shanemurphy
  Date: 29/01/2014
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="ibm_cd_dashboard.Team; com.ibm.team.build.common.model.BuildState; com.ibm.team.workitem.common.model.WorkItemTypes" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Teams</title>
    <meta name="layout" content="application">

    <r:script type="text/javascript" charset="utf-8">
        function showHide(elementid) {
            if (document.getElementById(elementid).style.display == 'none') {
                document.getElementById(elementid).style.display = '';
            } else {
                document.getElementById(elementid).style.display = 'none';
            }
        }
    </r:script>
    <r:require module="jquery"/>
    <g:javascript src="d3/d3.js"/>
    <g:javascript src="d3/nv.d3.min.js"/>

</head>

<body>

<table id=teamTable>
    <thead>
    %{--Column Headings--}%
    <tr class="lotusFirst lotusSort">
        <th class="lotusFirstCell">Team Name</th>
        <th>ID</th>
        <th>Team Members</th>
        <th>&nbsp;</th>
    </tr>
    </thead>
    <tbody>
    %{--Teams--}%
    <g:each status="i" in="${teams}" var="it">
    %{--Apply the lotusFirst class to the first row of the table--}%
        <tr class="${i == 0 ? 'lotusFirst' : ''}">
            <td class="lotusFirstCell"><g:link action="teamInfo" id="${it.teamId}">${it.teamName}</g:link></td>
            <td class="lotusMeta lotusNowrap lotusAltCell"><g:link action="teamInfo"
                                                                   id="${it.teamId}">${it.teamId}</g:link></td>
            <td class="lotusMeta lotusNowrap"><g:link action="teamInfo"
                                                      id="${it.getTeamMembers()}">${it.getTeamMembers()}</g:link></td>
            <td class="lotusAlignRight lotusAltCell lotusLastCell"><a class="lotusAction" role="button"
                                                                      aria-expanded="false"
                                                                      aria-controls="[detailRowID]" title="Show details"
                                                                      href='javascript:showHide("detailRowID_${it.getTeamId()}")'><img
                        class="lotusIcon16 lotusIconShow" src="../../css/images/blank.gif" alt=""
                        aria-label="Show details"/><span class="lotusAltText"></span></a></td>
        </tr>
        <tr id="detailRowID_${it.getTeamId()}" class="lotusDetails" style="display:none">

            <td class="lotusFirstCell" colspan="4">

                %{--
                    Render Partial View _teamData
                    Pass in jsonTimes for SVG
                --}%
                <%
                    def jsonTimes = []
                    it.getBuilds().each {
                        def timeMap = [
                                name: it.getName(),
                                time: it.getBuildTimeInMillis(),
                                modified: it.getModified()
                        ]
                        jsonTimes.add(timeMap)
                    }
                %>
                <fieldset class="form">
                    <g:render template="teamData" model="${[team: it, jsonTimes:jsonTimes]}"/>
                </fieldset>

            </td>
        </tr>
    </g:each>
    </tbody>
</table>
<g:if test="${teams.size()<1}">
    <p>No Teams? Check your subscriptions in your user profile</p>
</g:if>
<sec:ifNotLoggedIn>
    <ul>
        <li>
            <g:link controller="login" action="auth" >Log in</g:link> in to customise what teams you subscribe to.
        </li>
    </ul>
</sec:ifNotLoggedIn>
</body>
</html>