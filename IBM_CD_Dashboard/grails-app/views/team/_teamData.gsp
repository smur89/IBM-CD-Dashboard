<%@ page import="ibm_cd_dashboard.Build; org.grails.plugins.google.visualization.formatter.BarFormatter; ibm_cd_dashboard.Team; com.ibm.team.workitem.common.internal.setup.builders.DefaultIdentifiers; com.ibm.team.workitem.common.model.WorkItemTypes; org.grails.plugins.google.visualization.formatter.ColorRange; org.grails.plugins.google.visualization.formatter.ColorFormatter;" %>
    <%
        //      AreaChart
        def buildColumns = [['string', 'Build Id'], ['number', 'Build Time (ms)'], ['number', 'Average Build Time (ms)'], ['number', 'Test Time (ms)']]
        def totalBuildTime = 0
        def buildTimes = []
        def builds = team?.getBuilds()?.sort { a, b -> a.getModified() <=> b.getModified() }
        def avgBuildTime = (team?.getBuilds()?.buildTimeInMillis?.sum { it } / builds.size())
        for (Build build in builds) {
            buildTimes.add([build.buildId, build.buildTimeInMillis, avgBuildTime, build?.getTestResults()?.getCommitPhaseTestingTime()])
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
                    } else if (it.severity == DefaultIdentifiers.Severity.MINOR.toString()) {
                        minorSev++
                    } else if (it.severity == DefaultIdentifiers.Severity.NORMAL.toString()) {
                        normalSev++
                    } else if (it.severity == DefaultIdentifiers.Severity.MAJOR.toString()) {
                        majorSev++
                    } else if (it.severity == DefaultIdentifiers.Severity.CRITICAL.toString()) {
                        criticalSev++
                    } else if (it.severity == DefaultIdentifiers.Severity.BLOCKER.toString()) {
                        blockerSev++
                    }

                }
            }
        }
        def avgDefects = (totalDefects / builds.size())
    %>
<div>
    <table class="lotusVertTable" summary="Build Summary">
        <h4 class="lotusTitle"><g:link action="teamInfo" id="${team.teamId}">${team.teamId}</g:link></h4>
        <table class="lotusTable">


            <tr>
                    <%
                        def pieColumns = [['string', 'Team Name'], ['number', 'numDefects']]
                        def pieData = [["Unassigned", unassignedSev], ["Minor", minorSev], ["Normal", normalSev], ["Major", majorSev], ["Critical", criticalSev], ["Blocker", blockerSev]]
                    %>

                    <gvisualization:pieCoreChart elementId="piechart${team.teamId}" title="Defects Breakdown"
                                                 width="${400}"
                                                 height="${400}"
                                                 columns="${pieColumns}"
                                                 data="${pieData}"/>
                    <th id="piechart${team.teamId}"></th>
                    <gvisualization:areaCoreChart elementId="googlechart${team.teamId}"
                                                  title="Build Times"
                                                  height="${400}"
                                                  width="${700}"
                                                  colors="['#0892D0', '#000', 'red']"
                                                  columns="${buildColumns}"
                                                  data="${buildTimes}"/>
                    <td id="googlechart${team.teamId}"></td>

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

        </table>
</div>
