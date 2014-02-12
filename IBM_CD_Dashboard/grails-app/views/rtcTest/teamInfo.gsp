<%--
  Created by IntelliJ IDEA.
  User: shanemurphy
  Date: 28/01/2014
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>${team.teamName}</title>
</head>
<body>
<td>${team.teamName}</td>
<table>
    %{--Column Headings--}%
    <tr>
        <td>buildId</td>
        <td>name<td>
        <td>buildDefinitionId</td>
        <td>buildTimeInMillis</td>
        <td>startTime</td>
        <td>buildStatus</td>
        <td>buildState</td>
        <td>modified</td>
</tr>
    <g:each in="${team.getBuilds()}">
        <tr>
            <td>${it.buildId}</td>
            <td>${it.name}<td>
            <td>${it.buildDefinitionId}</td>
            <td>${it.buildTimeInMillis}</td>
            <td>${it.startTime}</td>
            <td>${it.buildStatus}</td>
            <td>${it.buildState}</td>
            <td>${it.modified}</td>
        </tr>
    </g:each>
</table>

</body>
</html>