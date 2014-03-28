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

    <script type="text/javascript" charset="utf-8">
        function showHide(elementid) {
            if (document.getElementById(elementid).style.display == 'none') {
                document.getElementById(elementid).style.display = '';
            } else {
                document.getElementById(elementid).style.display = 'none';
            }
        }
    </script>

</head>

<body>

<table>
    <tbody>
    %{--Column Headings--}%
    <tr class="lotusFirst lotusSort">
        <th class="lotusFirstCell"><a class="lotusActiveSort lotusAscending" aria-sort="ascending" href="javascript:;"
                                      title="Reverse sort" onclick="clearSort(this);
                reverseSort(this)">Team Name</a></th>
        <th><a href="javascript:;" title="Reverse sort" onclick="clearSort(this);
        reverseSort(this)">ID</a></th>
        <th><a href="javascript:;" title="Reverse sort" onclick="clearSort(this);
        reverseSort(this)">Team Members</a></th>
        <th>&nbsp;</th>
    </tr>
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
            <td class="lotusFirstCell">&nbsp;</td>
            <td class="lotusLastCell" colspan="2">

                %{--Render Partial View _teamData--}%
                <fieldset class="form">
                    <g:render template="teamData" model="${[team: it]}"/>
                </fieldset>


            </td>
        </tr>
    </g:each>
    </tbody>
</table>

</body>
</html>