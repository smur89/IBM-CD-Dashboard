<%--
  Created by IntelliJ IDEA.
  User: shanemurphy
  Date: 08/02/2014
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<table>
    <g:each in="${teams}">
        <tr>
            <td>${it.getTeamId()}</td>
        </tr>
    </g:each>

</table>
</body>
</html>