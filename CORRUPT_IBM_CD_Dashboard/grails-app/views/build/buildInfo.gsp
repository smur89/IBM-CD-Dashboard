<%--
  Created by IntelliJ IDEA.
  User: shanemurphy
  Date: 30/01/2014
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="com.ibm.team.workitem.common.model.WorkItemTypes" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>${build.getName()}</title>
</head>
<body>

<h1>${build.getName()}</h1>
<h2>Team Members</h2>
<table class="lotusVertTable" border="0" summary="Build Summary">
    <tr>
        <th scope="row">Build ID</th>
        <td>${build.buildId}</td>
    </tr>
    <tr>
        <th scope="row">Build Name</th>
        <td>${build.name}</td>
    </tr>
    <tr>
        <th scope="row">Build Definition</th>
        <td>${build.buildDefinitionId}</td>
    </tr>
    <tr>
        <th scope="row">Build Time</th>
        <td>${build.buildTimeInMillis}</td>
    </tr>
    <tr>
        <th scope="row">Start Time</th>
        <td>${build.startTime}</td>
    </tr>
    <tr>
        <th scope="row">Build Status</th>
        <td>${build.buildStatus}</td>
    </tr>
    <tr>
        <th scope="row">Build State</th>
        <td>${build.buildState}</td>
    </tr>
    <tr>
        <th scope="row">Date Modified</th>
        <td>${build.modified}</td>
    </tr>
</table>

<table>
    <tr>
        <th>Total Defects</th>
        <td>${build.getWorkItems().count {it.getType().equals(WorkItemTypes.DEFECT)}}</td>
    </tr>
</table>

%{--Sort builds by last modified date, most recent first--}%
<% def workItems = build.getWorkItems().sort{a,b-> b.getModified() <=> a.getModified()}%>
<h2>Work Items (${workItems.count {it}})</h2>
<table>
    %{--Column Headings--}%
    <tr>
        <td>ID<td>
        <td>Created</td>
    </tr>
    %{--Each build is a row--}%
    <g:each in="${workItems}">
        <tr>
            <td><g:link action="workItemInfo" controller="workItem" id="${it.getWorkItemId()}">${it.type}</g:link><td>
            <td>${it.getCreationDate().format('dd/MM/yyyy',TimeZone.getTimeZone('GMT'))}</td>
        </tr>
    </g:each>
</table>

</body>
</html>