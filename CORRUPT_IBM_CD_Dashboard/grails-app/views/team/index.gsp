<%--
  Created by IntelliJ IDEA.
  User: shanemurphy
  Date: 29/01/2014
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Teams</title>

    <script type="text/javascript" charset="utf-8">
        function showHide(elementid) {
            if (document.getElementById(elementid).style.display == 'none') {
                document.getElementById(elementid).style.display = '';
            } else {
                document.getElementById(elementid).style.display = 'none';
            }
        }
    </script>

</head>

<body>

<table>
    <tbody>
    %{--Column Headings--}%
    <tr class="lotusFirst lotusSort">
        <th class="lotusFirstCell"><a class="lotusActiveSort lotusAscending" aria-sort="ascending" href="javascript:;"
                                      title="Reverse sort" onclick="clearSort(this);
                reverseSort(this)">Team Name</a></th>
        <th><a href="javascript:;" title="Reverse sort" onclick="clearSort(this);
        reverseSort(this)">ID</a></th>
        <th><a href="javascript:;" title="Reverse sort" onclick="clearSort(this);
        reverseSort(this)">Team Members</a></th>
        <th>&nbsp;</th>
    </tr>
    %{--Teams--}%
    <g:each status="i" in="${teams}" var="it">
    %{--Apply the lotusFirst class to the first row of the table--}%
        <tr class="${i == 0 ? 'lotusFirst' : ''}">
            <td class="lotusFirstCell"><g:link action="teamInfo" id="${it.teamId}">${it.teamName}</g:link></td>
            <td class="lotusMeta lotusNowrap lotusAltCell"><g:link action="teamInfo"
                                                                   id="${it.teamId}">${it.teamId}</g:link></td>
            <td class="lotusMeta lotusNowrap"><g:link action="teamInfo"
                                                      id="${it.getTeamMembers()}">${it.getTeamMembers()}</g:link></td>
            <td class="lotusAlignRight lotusAltCell lotusLastCell"><a class="lotusAction" role="button"
                                                                      aria-expanded="false"
                                                                      aria-controls="[detailRowID]" title="Show details"
                                                                      href='javascript:showHide("detailRowID_${it.getTeamId()}")'><img
                        class="lotusIcon16 lotusIconShow" src="../../css/images/blank.gif" alt=""
                        aria-label="Show details"/><span class="lotusAltText"></span></a></td>
        </tr>
        <tr id="detailRowID_${it.getTeamId()}" class="lotusDetails" style="display:none">
            <td class="lotusFirstCell">&nbsp;</td>
            <td class="lotusLastCell" colspan="2">
                <table class="lotusVertTable" border="0" summary="Build Summary">
                    <tr>
                        <th scope="row">Total number of builds:</th>
                        <td>${it.getBuilds().count { it }}</td>
                    </tr>
                    <tr>
                        <th scope="row">Average Build Time:</th>
                        <td><g:formatNumber
                                number="${(it.builds.buildTimeInMillis.sum { it } / it.builds.count { it })}"
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
            </td>
        </tr>
    </g:each>
    </tbody>
</table>

</body>
</html>