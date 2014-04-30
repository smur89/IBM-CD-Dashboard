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