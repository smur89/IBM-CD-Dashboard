package ibm_cd_dashboard

/**
 * Controls all logic and requests relating to the WorkItem domain model.
 *
 * @author  Shane Murphy
 * @version 1.0
 * @since   2014-05-07
 */
class WorkItemController {

    /**
     * Show a list of all WorkItems
     */
    def allWorkItems() {
        [workItems: WorkItem.getAll().sort({ it.getBuildOwner().getName() })]
    }

    /**
     * Display the workItemInfo page which shows WorkItem Information for this
     * particular workitem ID.
     *
     * @param The WorkItem object to be displayed
     */
    def workItemInfo() {
        [workItem: WorkItem.get(params.id)]
    }
}
