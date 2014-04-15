<%@ page import="ibm_cd_dashboard.Build; ibm_cd_dashboard.Team; com.ibm.team.workitem.common.internal.setup.builders.DefaultIdentifiers; com.ibm.team.workitem.common.model.WorkItemTypes;" %>
    <%
        //      AreaChart
        def buildColumns = [['string', 'Build Id'], ['number', 'Build Time (ms)'], ['number', 'Average Build Time (ms)']]
        def testColumns = [['string', 'Build Id'], ['number', 'Test Time (ms)']]
        def totalBuildTime = 0
        def buildTimes = []
        def testTimes = []
        def builds = team?.getBuilds()?.sort { a, b -> a?.getModified() <=> b?.getModified() }
        def avgBuildTime = (team?.getBuilds()?.buildTimeInMillis?.sum { it } / builds?.size())
        for (Build build in builds) {
            buildTimes.add([build?.buildId, build?.buildTimeInMillis, avgBuildTime])
            testTimes.add([build.buildId, build?.getTestResults()?.getCommitPhaseTestingTime()])
            totalBuildTime += build?.buildTimeInMillis
        }

        def totalDefects = 0 //Total
        def s3 = 0 // Normal, Minor
        def s2 = 0 // Major
        def s1 = 0 // Critical or Blocker

        team?.getBuilds()?.each {
            it?.workItems?.each {
                if (it?.getType() == WorkItemTypes.DEFECT) {
                    totalDefects++
                    if (it?.severity == DefaultIdentifiers.Severity.UNASSIGNED.toString() ||
                            it?.severity == DefaultIdentifiers.Severity.MINOR.toString() ||
                            it?.severity == DefaultIdentifiers.Severity.NORMAL.toString()) {
                        s3++
                    } else if (it?.severity == DefaultIdentifiers.Severity.MAJOR.toString()) {
                        s2++
                    } else if (it?.severity == DefaultIdentifiers.Severity.CRITICAL.toString() ||
                            it.severity == DefaultIdentifiers.Severity.BLOCKER.toString()) {
                        s1++
                    }

                }
            }
        }
        if(totalDefects > 0 && builds.size > 0){
            def avgDefects = (totalDefects / builds.size())
        }
    %>
<div>
    <table class="lotusVertTable" summary="Build Summary">
        <h4 class="lotusTitle"><g:link action="teamInfo" id="${team?.teamId}">${team?.teamId}</g:link></h4>
        <table class="lotusTable">


            <tr>
                    <%
                        def pieColumns = [['string', 'Team Name'], ['number', 'numDefects']]
                        def pieData = [["S3", s3], ["S2", s2], ["S1", s1]]
                    %>

                    <gvisualization:pieCoreChart elementId="piechart${team.teamId}" title="Commit Stage Defects"
                                                 width="${300}"
                                                 height="${300}"
                                                 colors="['red', '#FF8600', '#1B5200']"
                                                 columns="${pieColumns}"
                                                 data="${pieData}"/>
                    <th id="piechart${team?.teamId}"></th>
                    <gvisualization:areaCoreChart elementId="buildChart${team.teamId}"
                                                  title="Build Times"
                                                  height="${300}"
                                                  width="${490}"
                                                  colors="['#0892D0', '#2A4480', '#BBBB00']"
                                                  columns="${buildColumns}"
                                                  data="${buildTimes}"/>
                    <td id="buildChart${team?.teamId}"></td>
                    <gvisualization:areaCoreChart elementId="testChart${team.teamId}"
                                                  title="Commit Test Times (Expanded)"
                                                  height="${300}"
                                                  width="${490}"
                                                  colors="['#FFEB00']"
                                                  columns="${testColumns}"
                                                  data="${testTimes}"/>
                    <td id="testChart${team?.teamId}"></td>

            </tr>

            <tr>
                <th scope="row">Total Commits:</th>
                <%
                    int buildCount = team?.getBuilds()?.count { it }?.intValue()
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
                <th>Average Defects per Commit</th>
                <td><g:formatNumber
                        number="${avgDefects}"
                        type="number"
                        maxFractionDigits="2"/>
                </td>
            </tr>

        </table>
</div>
