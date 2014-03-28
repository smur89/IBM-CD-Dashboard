<%@ page import="com.ibm.team.workitem.common.model.WorkItemTypes;" %>

<div>
    <table class="lotusVertTable" border="0" summary="Build Summary">

        <div id='chart${team.teamId}'>
            <svg style='height:250px'></svg>
        </div>
        <%
            def jsonTimes = []
            team.getBuilds().each {
                def timeMap = [
                        name: it.getName(),
                        time: it.getBuildTimeInMillis(),
                        modified: it.getModified()
                ]
                jsonTimes.add(timeMap)
            }
        %>
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

  d3.select('#chart${team.teamId} svg')    //Select the <svg> element you want to render the chart in.
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



        <tr>
            <th scope="row">Total number of builds:</th>
            <%
                int buildCount = team.getBuilds().count { it }.intValue()
            %>
            <td>${buildCount}</td>
        </tr>
        <tr>
            <th scope="row">Total Defects</th>
            <% //Calculate total defects
            def totalDefects = 0
            team.getBuilds().each {
                it.workItems.each {
                    if (it.getType() == WorkItemTypes.DEFECT) {
                        totalDefects++
                    }
                }
            }
            %>
            <td>${totalDefects}</td>
        </tr>
        <tr>
            <th>Average defect count per Build</th>
            <td><g:formatNumber
                    number="${(totalDefects / buildCount)}"
                    type="number"
                    maxFractionDigits="2"/>
                </td>
        </tr>
        %{--TODO Add Open and defferred defects count BuildState group should be IN_PROGRESS_STATES--}%
        <tr>
            <th scope="row">Average Build Time:</th>
            <td><g:formatNumber
                    number="${(team?.getBuilds()?.buildTimeInMillis?.sum { it } / buildCount)}"
                    type="number"
                    maxFractionDigits="2"/>ms
            </td>
        </tr>
    </table>

    <div class="lotusChunk"><ul class="lotusInlinelist lotusLeft lotusActions"><li class="lotusFirst"><a
            href="javascript:;" role="button">Edit</a></li><li><a href="javascript:;"
                                                                  onclick="MenuPopup.showMenu('dogEntryActionMenu', event, { focus: this });"
                                                                  role="button" aria-haspopup="true"
                                                                  aria-owns="dogEntryActionMenu">More actions <img
                class="lotusArrow lotusDropDownSprite" src="../../css/images/blank.gif" alt=""/><span
                class="lotusAltText">&#x25bc;</span></a></li></ul></div>

</div>