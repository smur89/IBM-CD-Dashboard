<%@ page import="ibm_cd_dashboard.Team; com.ibm.team.workitem.common.internal.setup.builders.DefaultIdentifiers; com.ibm.team.workitem.common.model.WorkItemTypes;" %>
<div>
    <%
        def buildColumns = [['string', 'Build Id'], ['number', 'Build Time (ms)'], ['number', 'Average Build Time']]
        def totalBuildTime = 0
        def buildTimes = []
        def builds = team?.getBuilds()?.sort { a, b -> a.getModified() <=> b.getModified() }
        def avgBuildTime = (team?.getBuilds()?.buildTimeInMillis?.sum { it } / builds.size())
        for (build in builds) {
            buildTimes.add([build.buildId, build.buildTimeInMillis, avgBuildTime])
            totalBuildTime += build.buildTimeInMillis
        }

        def totalDefects = 0
        def unassignedSev = 0
        def minorSev = 0
        def normalSev = 0
        def majorSev = 0
        def criticalSev = 0
        def blockerSev = 0

        team.getBuilds().each {
            it.workItems.each {
                if (it.getType() == WorkItemTypes.DEFECT) {
                    totalDefects++
                    if (it.severity == DefaultIdentifiers.Severity.UNASSIGNED.toString()) {
                        unassignedSev++
                    }
                    if (it.severity == DefaultIdentifiers.Severity.MINOR.toString()) {
                        minorSev++
                    }
                    if (it.severity == DefaultIdentifiers.Severity.NORMAL.toString()) {
                        normalSev++
                    }
                    if (it.severity == DefaultIdentifiers.Severity.MAJOR.toString()) {
                        majorSev++
                    }
                    if (it.severity == DefaultIdentifiers.Severity.CRITICAL.toString()) {
                        criticalSev++
                    }
                    if (it.severity == DefaultIdentifiers.Severity.BLOCKER.toString()) {
                        blockerSev++
                    }
                }
            }
        }
        def avgDefects = (totalDefects / builds.size())
    %>

    <table class="lotusVertTable" summary="Build Summary">
        <h4 class="lotusTitle"><g:link action="teamInfo" id="${team.teamId}">${team.teamId}</g:link></h4>

        <tr>
            <gvisualization:areaCoreChart elementId="googlechart${team.teamId}"
                                          title="Build Times"
                                          height="${250}"
                                          colors="['#0892D0', '#000']"
                                          columns="${buildColumns}"
                                          data="${buildTimes}"/>
            <div id="googlechart${team.teamId}"></div>
        </tr>
        <tr>
            <gvisualization:barCoreChart elementId="barChart${team.teamId}"
                                         title="Defects"
                                         height="${250}"
                                         columns="${[['number', 'Total'], ['number', 'Unassigned'], ['number', 'Minor'], ['number', 'Normal'], ['number', 'Major'], ['number', 'Critical'], ['number', 'Blocker']]}"
                                         data="${[totalDefects, unassignedSev, minorSev, normalSev, majorSev, criticalSev, blockerSev]}"/>
            <div id="barChart${team.teamId}"></div>

        </tr>

        <tr>
            <th scope="row">Total number of builds:</th>
            <%
                int buildCount = team.getBuilds().count { it }.intValue()
            %>
            <td>${buildCount}</td>
        </tr>

        %{--TODO Add Open and defferred defects count BuildState group should be IN_PROGRESS_STATES--}%

        <tr>
            <th scope="row">Average Build Time:</th>
            <td><g:formatNumber
                    number="${avgBuildTime}"
                    type="number"
                    maxFractionDigits="2"/>ms
            </td>
        </tr>
        <tr>
            <th>Average defects per Build</th>
            <td><g:formatNumber
                    number="${avgDefects}"
                    type="number"
                    maxFractionDigits="2"/>
            </td>
        </tr>
        <tr>
            <table class="lotusTable">
                <thead>
                <tr>
                    <th>Total</th>
                    <th>Unassigned</th>
                    <th>Minor</th>
                    <th>Normal</th>
                    <th>Major</th>
                    <th>Critical</th>
                    <th>Blocker</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${totalDefects}</td>
                    <td>${unassignedSev}</td>
                    <td>${minorSev}</td>
                    <td>${normalSev}</td>
                    <td>${majorSev}</td>
                    <td>${criticalSev}</td>
                    <td>${blockerSev}</td>
                </tr>
                </tbody>
            </table>
        </tr>
</div>
