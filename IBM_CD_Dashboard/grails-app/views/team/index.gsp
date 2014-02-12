<%--
  Created by IntelliJ IDEA.
  User: shanemurphy
  Date: 29/01/2014
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Teams</title>
</head>
<body>

<table>
    <tbody>
    %{--Column Headings--}%
    <tr class="lotusFirst lotusSort">
        <th class="lotusFirstCell"><a class="lotusActiveSort lotusAscending" aria-sort="ascending" href="javascript:;" title="Reverse sort" onclick="clearSort(this);reverseSort(this)">Team Name</a></th>
        <th><a href="javascript:;" title="Reverse sort" onclick="clearSort(this);reverseSort(this)">ID</a></th>
        <th><a href="javascript:;" title="Reverse sort" onclick="clearSort(this);reverseSort(this)">Team Members</a></th>
    </tr>
    %{--Teams--}%
    <g:each in="${teams}">
        <tr>
            <td class="lotusFirstCell"><g:link action="teamInfo" id="${it.teamId}">${it.teamName}</g:link></td>
            <td class="lotusMeta lotusNowrap lotusAltCell"><g:link action="teamInfo" id="${it.teamId}">${it.teamId}</g:link></td>
            <td class="lotusMeta lotusNowrap"><g:link action="teamInfo" id="${it.getTeamMembers()}">${it.getTeamMembers()}</g:link></td>
        </tr>
    </g:each>
    </tbody>
</table>

</body>
</html>