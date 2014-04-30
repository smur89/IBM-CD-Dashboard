<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>${workItem.getWorkItemId()}</title>
</head>

<body>

<h1>${workItem.getWorkItemId()}</h1>
<table>
    <tr>
        <th>Modified Date</th>
        <td>${workItem.getModified()}</td>
    </tr>
    <tr>
        <th>Duration</th>
        <td>${workItem.getDuration()}</td>
    </tr>
    <tr>
        <th>Creation Date</th>
        <td>${workItem.getCreationDate()}</td>
    </tr>
    <tr>
        <th>Resolution Date</th>
        <td>${workItem.getResolutionDate()}</td>
    </tr>
    <tr>
        <th>Type</th>
        <td>${workItem.getType()}</td>
    </tr>
    <tr>
        <th>Severity</th>
        <td>${workItem.getSeverity().toString()}</td>
    </tr>
</table>

</body>
</html>