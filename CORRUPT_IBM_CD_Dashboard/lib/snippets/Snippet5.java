package snippets;
/*******************************************************************************
 * Licensed Materials - Property of IBM
 * (c) Copyright IBM Corporation 2006, 2012. All Rights Reserved. 
 * 
 * Note to U.S. Government Users Restricted Rights:  Use, 
 * duplication or disclosure restricted by GSA ADP Schedule 
 * Contract with IBM Corp.
 *******************************************************************************/
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;

import com.ibm.team.foundation.common.text.XMLString;
import com.ibm.team.process.common.IProjectAreaHandle;
import com.ibm.team.process.common.ITeamArea;
import com.ibm.team.process.common.ITeamAreaHandle;
import com.ibm.team.repository.client.IItemManager;
import com.ibm.team.repository.client.ITeamRepository;
import com.ibm.team.repository.client.TeamPlatform;
import com.ibm.team.repository.common.TeamRepositoryException;
import com.ibm.team.workitem.client.IDetailedStatus;
import com.ibm.team.workitem.client.IWorkItemClient;
import com.ibm.team.workitem.client.WorkItemWorkingCopy;
import com.ibm.team.workitem.common.model.ICategory;
import com.ibm.team.workitem.common.model.IWorkItem;
import com.ibm.team.workitem.common.model.IWorkItemHandle;
import com.ibm.team.workitem.common.model.IWorkItemType;

/**
 * Plain Java Snippet: Creating a work item
 */
public class Snippet5 {

    public static void main(String[] args) {
        TeamPlatform.startup();
        try {            
            IProgressMonitor monitor = new SysoutProgressMonitor();
            ITeamRepository repo = Snippet1.login(monitor);                        
            createWorkItem(repo, monitor);
        } catch (TeamRepositoryException e) {
            System.out.println("Unable to login: " + e.getMessage());
        } finally {
            TeamPlatform.shutdown();
        }
    }

    public static IWorkItemHandle createWorkItem(ITeamRepository repo, IProgressMonitor monitor) throws TeamRepositoryException {
        ITeamAreaHandle teamAreaHandle = Snippet3.createProject(repo, "Snippet 5");
        ITeamArea teamArea = (ITeamArea) repo.itemManager().fetchCompleteItem(teamAreaHandle, IItemManager.DEFAULT, monitor);
        IProjectAreaHandle projectArea = teamArea.getProjectArea();
        IWorkItemClient service = (IWorkItemClient) repo.getClientLibrary(IWorkItemClient.class);
        IWorkItemType workItemType = service.findWorkItemType(projectArea, "defect", monitor);
        IWorkItemHandle handle = service.getWorkItemWorkingCopyManager().connectNew(workItemType, monitor);
        WorkItemWorkingCopy wc = service.getWorkItemWorkingCopyManager().getWorkingCopy(handle);
        IWorkItem workItem = wc.getWorkItem();
        try {
            List<ICategory> findCategories= service.findCategories(projectArea, ICategory.FULL_PROFILE, monitor);
            ICategory category = findCategories.get(0);
            workItem.setCategory(category);
            workItem.setCreator(repo.loggedInContributor());
            workItem.setOwner(repo.loggedInContributor());
            workItem.setHTMLSummary(XMLString.createFromPlainText("Example work item"));
            IDetailedStatus s = wc.save(null);
            if(! s.isOK()) {
                throw new TeamRepositoryException("Error saving work item", s.getException());
            }
        } finally {
            service.getWorkItemWorkingCopyManager().disconnect(workItem);
        }
        workItem = (IWorkItem) repo.itemManager().fetchCompleteItem(workItem, IItemManager.DEFAULT, monitor);        
        monitor.subTask("Created a work item " + workItem.getId());
        return workItem;
    }
}
