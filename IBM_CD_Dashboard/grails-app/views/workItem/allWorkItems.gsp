<%--
  Created by IntelliJ IDEA.
  User: shanemurphy
  Date: 08/02/2014
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>

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