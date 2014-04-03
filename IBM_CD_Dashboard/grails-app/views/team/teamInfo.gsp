<%--
  Created by IntelliJ IDEA.
  User: shanemurphy
  Date: 29/01/2014
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="ibm_cd_dashboard.Team; java.text.DecimalFormat; grails.converters.JSON; com.ibm.team.workitem.common.model.WorkItemTypes" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="application">

    <link rel="stylesheet" href="${resource(dir: 'css', file: 'nv.d3.css')}" type="text/css"/>
    <g:javascript src="d3/d3.js"/>
    <g:javascript src="d3/nv.d3.min.js"/>

    <title>${team.getTeamName()}</title>
</head>

<body>

<h2>Team Members</h2>
<table>
    <g:each var="member" in="${team.teamMembers}">
    %{--Column Headings--}%
        <tr>
            <th>Member Name</th>
        <td>
           ${member.name}
        </td>
        </tr>
    </g:each>

</table>


<h2>Build Times</h2>

<div id='chart'>
    <svg style='height:250px'></svg>
</div>

<r:script>
    /*These lines are all chart setup.  Pick and choose which chart features you want to utilize. */
nv.addGraph(function() {
  var chart = nv.models.lineChart()
                .margin({left: 100})  //Adjust chart margins to give the x-axis some breathing room.
                .useInteractiveGuideline(true)  //We want nice looking tooltips and a guideline!
                .transitionDuration(350)  //how fast do you want the lines to transition?
                .showLegend(true)       //Show the legend, allowing users to turn on/off line series.
                .showYAxis(true)        //Show the y-axis
                .showXAxis(true)        //Show the x-axis
  ;

  chart.xAxis     //Chart x-axis settings
      .axisLabel('Build No.')
      .tickFormat(d3.format(',r'));

  chart.yAxis     //Chart y-axis settings
      .axisLabel('Build Time (ms)')
      .tickFormat(d3.format('r'));

  /* Done setting the chart up? Time to render it!*/
  var myData = buildTimes();   //You need data...

  d3.select('#chart svg')    //Select the <svg> element you want to render the chart in.
      .datum(myData)         //Populate the <svg> element with chart data...
      .call(chart);          //Finally, render the chart!

  //Update the chart when window resizes.
  nv.utils.windowResize(function() { chart.update() });
  return chart;
});
/**************************************
 * Simple test data generator
 */
function buildTimes() {
    var names = [];
    var builds = [];
    var i = 0;

    //Data is represented as an array of {x,y} pairs.
    <g:each var="jt" in="${jsonTimes}">
        <g:if test="${jt.getAt("time") > 0}">
            builds.push({x: i, y: ${jt.getAt("time")}});
            names[i++] = "${jt.getAt("name")}";
        </g:if>
    </g:each>

    //Line chart data should be sent as an array of series objects.
    return [
        {
          values: builds, //values - represents the array of {x,y} data points
          key: 'Build Time', //key  - the name of the series.
          color: '#0892D0',  //color - optional: choose your own line color.
          area: true      //area - set to true if you want this line to turn into a filled area chart.
        }
    ];
}

</r:script>

<table class="lotusVertTable" border="0" summary="Team Summary Information.">
    <tr>
        %{--Format Average Build Time to two decimal places--}%
        <% DecimalFormat df = new DecimalFormat("#.##"); %>
        <th>Average Build Time</th>
        <td>${df.format(avgBuildTime)}ms</td>
    </tr>
    <tr>
        <th>Total Defects</th>
        <%  //Calculate total defects
            def count = 0
            team.getBuilds().each { it.workItems.each { if(it.getType() == WorkItemTypes.DEFECT){ count++ }}}
        %>
        <td>${count}</td>
    </tr>
</table>

<h2>Builds</h2>
<table class="lotusTable" border="0" cellspacing="0" cellpadding="0" summary="Team Builds">
    %{--Column Headings--}%
    <tbody>
    <tr class="lotusFirst lotusSort">
        <th class="lotusFirstCell"><a class="lotusActiveSort lotusAscending" aria-sort="ascending" href="javascript:;"
                                      title="Reverse sort" onclick="clearSort(this); reverseSort(this)">Build No.</a></th>

        <th><a href="javascript:;" title="Reverse sort" onclick="clearSort(this); reverseSort(this)">Name</a></th>
        <th><a href="javascript:;" title="Reverse sort" onclick="clearSort(this); reverseSort(this)">Build Status</a></th>
        <th><a href="javascript:;" title="Reverse sort" onclick="clearSort(this); reverseSort(this)">Build State</a></th>
        <th><a href="javascript:;" title="Reverse sort" onclick="clearSort(this); reverseSort(this)">Modified</a></th>
        <th><a href="javascript:;" title="Reverse sort" onclick="clearSort(this); reverseSort(this)">WorkItems</a></th>
        <th>&nbsp;</th>
    </tr>

    %{--Sort builds by last modified date, most recent first--}%
    <% def builds = team.getBuilds().sort { a, b -> a.getModified() <=> b.getModified() } %>
    %{--Each build is a row--}%
    <g:each status="i" in="${builds}" var="it">
    %{--Apply the lotusFirst class to the first row of the table--}%
        <tr class="${i == 0 ? 'lotusFirst' : ''}">
            <td class="lotusMeta lotusNowrap lotusAltCell">${builds.size()-(i+1)}</td>

            <td class="lotusFirstCell"><h4 class="lotusTitle"><g:link action="buildInfo" controller="build"
                                                                      id="${it.buildId}">
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
            <td class="lotusMeta lotusNowrap lotusAltCell">${it.getModified().format('dd/MM/yyyy', TimeZone.getTimeZone('GMT'))}</td>
            <td class="lotusMeta lotusNowrap ">${it.getWorkItems().count { it }}</td>
            <td class="lotusAlignRight lotusAltCell lotusLastCell"><a class="lotusAction" href="javascript:;"
                                                                      role="button" aria-expanded="false"
                                                                      aria-controls="[detailRowID]"
                                                                      title="Show details"><img
                        class="lotusIcon16 lotusIconShow" src="../../css/images/blank.gif" alt=""
                        aria-label="Show details"/><span class="lotusAltText"></span></a></td>
        </tr>
    </g:each>
    </tbody>
</table>
</body>
</html>