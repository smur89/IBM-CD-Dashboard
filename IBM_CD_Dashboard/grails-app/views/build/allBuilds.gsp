<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>All Builds</title>
</head>

<body>
<table>
    <g:each in="${builds}">
        <tr>
            <td>${it.buildId}</td>
        </tr>
    </g:each>

</table>

</body>
</html>