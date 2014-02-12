<%--
  Created by IntelliJ IDEA.
  User: shanemurphy
  Date: 29/01/2014
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="com.ibm.team.workitem.common.model.WorkItemTypes" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>${team.getTeamName()}</title>
</head>
<body>
<h2>Team Members</h2>
<table>
    <g:each in="${team.getTeamMembers()}">
        %{--Column Headings--}%
        <tr>
            <td>Member Name</td>
        </tr>
        <tr>
            <td>${it.getName()}</td>
        </tr>
    </g:each>
</table>

<table class="lotusVertTable" border="0" summary="Team Summary Information.">
    <tr>
        <th>Average Build Time</th>
        <td>${avgBuildTime}ms</td>
    </tr>
    <tr>
        <th>Total Defects</th>
        <td>${team.builds.each {it}.workItems.count {it.type.equals({WorkItemTypes.DEFECT})}}</td>
    </tr>
</table>

<h2>Builds</h2>
<table class="lotusTable" border="0" cellspacing="0" cellpadding="0" summary="Team Builds">
    %{--Column Headings--}%
    <tbody>
    <tr class="lotusFirst lotusSort">
        <th class="lotusFirstCell"><a class="lotusActiveSort lotusAscending" aria-sort="ascending" href="javascript:;" title="Reverse sort" onclick="clearSort(this);reverseSort(this)">Name</a></th>

        <th><a href="javascript:;" title="Reverse sort" onclick="clearSort(this);reverseSort(this)">Build Status</a></th>
        <th><a href="javascript:;" title="Reverse sort" onclick="clearSort(this);reverseSort(this)">Build State</a></th>
        <th><a href="javascript:;" title="Reverse sort" onclick="clearSort(this);reverseSort(this)">Modified</a></th>
        <th><a href="javascript:;" title="Reverse sort" onclick="clearSort(this);reverseSort(this)">WorkItems</a></th>
        <th>&nbsp;</th>
    </tr>

    %{--Sort builds by last modified date, most recent first--}%
    <% def builds = team.getBuilds().sort{a,b-> b.getModified() <=> a.getModified()}%>
    %{--Each build is a row--}%
    <g:each status="i" in="${builds}" var="it">
        %{--Apply the lotusFirst class to the first row of the table--}%
        <tr class="${ i  == 0 ? 'lotusFirst' : ''}">
            <td class="lotusFirstCell"><h4 class="lotusTitle"><g:link action="buildInfo" controller="build" id="${it.buildId}">
                %{--If no name associated with build, print N/A--}%
                <g:if test="${it.name.equals(null)}">
                    N/A
                </g:if>
                <g:else>
                    ${it.name}
                </g:else>
            </g:link></h4></td>
            <td class="lotusMeta lotusNowrap lotusAltCell">${it.getBuildStatus()}</td>
            <td class="lotusMeta lotusNowrap ">${it.getBuildState()}</td>
            <td class="lotusMeta lotusNowrap lotusAltCell">${it.getModified().format('dd/MM/yyyy',TimeZone.getTimeZone('GMT'))}</td>
            <td class="lotusMeta lotusNowrap ">${it.getWorkItems().count {it}}</td>
            <td class="lotusAlignRight lotusAltCell lotusLastCell"><a class="lotusAction" href="javascript:;" role="button" aria-expanded="false" aria-controls="[detailRowID]" title="Show details"><img class="lotusIcon16 lotusIconShow" src="../../css/images/blank.gif" alt="" aria-label="Show details" /><span class="lotusAltText"></span></a></td>
        </tr>
    </g:each>
    </tbody>
</table>

</body>
</html>