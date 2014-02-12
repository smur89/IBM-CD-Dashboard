<%--
  Created by IntelliJ IDEA.
  User: shanemurphy
  Date: 28/01/2014
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Teams</title>
</head>
<body>

<table>
    <g:each in="${teams}">
        <tr>
            <td><g:link action="teamInfo" id="${it.teamId}">${it.teamName}</g:link></td>
            <td><g:link action="teamInfo" id="${it.teamId}">${it.teamId}</g:link></td>
        </tr>
    </g:each>
</table>

</body>
</html>