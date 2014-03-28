<%@ page import="com.ibm.team.workitem.common.model.WorkItemTypes; ibm_cd_dashboard.User; ibm_cd_dashboard.Team; ibm_cd_dashboard.UserProfile" %>



<div class="fieldcontain ${hasErrors(bean: userProfileInstance, field: 'user', 'error')} required">
    <table class="lotusVertTable" border="0" summary="Build Summary">
        <tr>
            <th scope="row">Total number of builds:</th>
            <td>${it.getBuilds().count { it }}</td>
        </tr>
        <tr>
            <th scope="row">Total Defects</th>
            <% //Calculate total defects
            def totalDefects = 0
            it.getBuilds().each {
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
            <td>${((totalDefects) / (it.getBuilds().count { it }))}</td>
        </tr>
        %{--TODO Add Open and defferred defects count BuildState group should be IN_PROGRESS_STATES--}%
        <tr>
            <th scope="row">Average Build Time:</th>
            <td><g:formatNumber
                    number="${(it?.builds?.buildTimeInMillis?.sum { it } / it?.builds?.count { it })}"
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

