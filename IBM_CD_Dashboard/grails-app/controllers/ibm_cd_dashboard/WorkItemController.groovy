package ibm_cd_dashboard

class WorkItemController {

    def allWorkItems(){
        [workItems:WorkItem.getAll().sort({it.getBuildOwner().getName()})]
    }

    def workItemInfo() {
        [workItem:WorkItem.get(params.id)]
    }
}
