<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<table>
    <g:each in="${workItems}">
        <tr>
            <td>${it.getWorkItemId()}</td>
            <td>${it.getBuildOwner().getName()}</td>
        </tr>
    </g:each>

</table>
</body>
</html>