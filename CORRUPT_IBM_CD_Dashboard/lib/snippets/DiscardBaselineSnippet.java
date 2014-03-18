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

import com.ibm.team.repository.client.IItemManager;
import com.ibm.team.repository.client.ITeamRepository;
import com.ibm.team.repository.client.TeamPlatform;
import com.ibm.team.repository.client.util.IClientLibraryContext;
import com.ibm.team.repository.client.util.IClientLibraryContext.IServiceRunnable;
import com.ibm.team.repository.common.TeamRepositoryException;
import com.ibm.team.repository.common.UUID;
import com.ibm.team.scm.client.IHistoricBaselineIterator;
import com.ibm.team.scm.client.IWorkspaceConnection;
import com.ibm.team.scm.client.SCMPlatform;
import com.ibm.team.scm.common.AcceptFlags;
import com.ibm.team.scm.common.IBaselineHandle;
import com.ibm.team.scm.common.IChangeSetHandle;
import com.ibm.team.scm.common.IComponent;
import com.ibm.team.scm.common.IComponentHandle;
import com.ibm.team.scm.common.IScmService;
import com.ibm.team.scm.common.IWorkspace;
import com.ibm.team.scm.common.IWorkspaceHandle;
import com.ibm.team.scm.common.dto.IWorkspaceSearchCriteria;

/**
 * Plain Java Snippet: Creating a work item
 */
public class DiscardBaselineSnippet {

    public static void main(String[] args) {
        if (args.length != 5) {
            System.err.println("Usage: " + DiscardBaselineSnippet.class.getName() + " <repository uri> <username> <password> <workspace> <component>");
            return;
        }
        TeamPlatform.startup();
        try {            
            IProgressMonitor monitor = new SysoutProgressMonitor();
            ITeamRepository repo = login(args[0], args[1], args[2], monitor);
            
            IWorkspaceConnection conn = findWorkspace(repo, args[3], monitor);
            if (conn == null) {
                return;
            }
            IComponentHandle cmp = findComponentInWorkspace(conn, args[4], monitor);
            if (cmp == null) {
                return;
            }
            discardBaseline(conn, cmp, monitor);
        } catch (TeamRepositoryException e) {
            e.printStackTrace();
        } finally {
            TeamPlatform.shutdown();
        }
    }
    
    private static ITeamRepository login(String repoAddress, final String userId, final String password, IProgressMonitor monitor) throws TeamRepositoryException {
        ITeamRepository repository = TeamPlatform.getTeamRepositoryService().getTeamRepository(repoAddress);
        repository.registerLoginHandler(new ITeamRepository.ILoginHandler() {
            public ILoginInfo challenge(ITeamRepository repository) {
                return new ILoginInfo() {
                    public String getUserId() {
                        return userId;
                    }
                    public String getPassword() {
                        return password;                        
                    }
                };
            }
        });
        monitor.subTask("Contacting " + repository.getRepositoryURI() + "...");
        repository.login(monitor);
        monitor.subTask("Connected");
        return repository;
    }
    
    private static UUID toUUID(String id) {
        try {
            return UUID.valueOf(id);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    
    private static IWorkspaceConnection findWorkspace(ITeamRepository repo, String workspace, IProgressMonitor monitor) throws TeamRepositoryException {
        IWorkspaceHandle wh;
        UUID workspaceId = toUUID(workspace);
        if (workspaceId != null) {
            wh = (IWorkspaceHandle)IWorkspace.ITEM_TYPE.createItemHandle(workspaceId, null);
        } else {
            //not a UUID, could be a name.
            IWorkspaceSearchCriteria wsc = IWorkspaceSearchCriteria.FACTORY.newInstance();
            wsc.setExactName(workspace);
            wsc.getFilterByOwnerOptional().add(repo.loggedInContributor());
            List<IWorkspaceHandle> ws = SCMPlatform.getWorkspaceManager(repo).findWorkspaces(wsc, 2, monitor);
            switch (ws.size()) {
            case 0:
                wsc = IWorkspaceSearchCriteria.FACTORY.newInstance();
                wsc.setExactName(workspace);
                ws = SCMPlatform.getWorkspaceManager(repo).findWorkspaces(wsc, 2, monitor);
                switch (ws.size()) {
                case 0:
                    System.err.println("Failed to find workspace named " + workspace);
                    return null;
                case 1:
                    wh = ws.get(0);
                    break;
                default:
                    System.err.println("Multiple workspaces named " + workspace);
                    return null;
                }
            case 1:
                wh = ws.get(0);
                break;
            default:
                System.err.println("Multiple workspaces named " + workspace + " owned by " + repo.loggedInContributor().getUserId());
                return null;
            }
        }
        return SCMPlatform.getWorkspaceManager(repo).getWorkspaceConnection(wh, monitor);
    }
    
    private static IComponentHandle findComponentInWorkspace(IWorkspaceConnection conn, String component, IProgressMonitor monitor) 
            throws TeamRepositoryException {
        UUID componentId = toUUID(component);
        if (componentId != null) {
            for (Object o : conn.getComponents()) {
                IComponentHandle cmp = (IComponentHandle)o;
                if (cmp.getItemId().equals(componentId)) {
                    return cmp;
                }
            }
        } else {
            List components = conn.teamRepository().itemManager().fetchCompleteItems(conn.getComponents(), IItemManager.DEFAULT, monitor);
            for (Object o : components) {
                IComponent cmp = (IComponent)o;
                if (component.equals(cmp.getName())) {
                    return cmp;
                }
            }
        }
        
        System.err.println("Failed to find component named " + component + " in workspace " + conn.getName());
        return null;
    }
    
    private static void discardBaseline(final IWorkspaceConnection conn, IComponentHandle cmp, IProgressMonitor monitor) throws TeamRepositoryException {
        IHistoricBaselineIterator it = conn.getBaselinesInHistory(cmp, 2, monitor);
        IBaselineHandle previous = null;
        boolean skipped = false;
        while (true) {
            List<? extends IBaselineHandle> baselines = it.getBaselines();
            if (!baselines.isEmpty()) {
                if (skipped) {
                    previous = baselines.get(0);
                    break;
                }
                if (baselines.size() == 1) {
                    skipped = true;
                } else {
                    previous = baselines.get(1);
                    break;
                }
            }
            if (!it.hasPrevious()) {
                System.err.println("The initial baseline cannot be discarded");
                return;
            }
        }
        
        IClientLibraryContext ctx = (IClientLibraryContext)conn.teamRepository();
        final IScmService scmSvc = (IScmService)ctx.getServiceInterface(IScmService.class);
        final IBaselineHandle prevBaseline = previous;
        ctx.callCancelableService(new IServiceRunnable<Object>() {
            @Override
            public Object run(IProgressMonitor monitor) throws TeamRepositoryException {
                scmSvc.acceptCombined(conn.getResolvedWorkspace(), AcceptFlags.DEFAULT, conn.getResolvedWorkspace(),
                        null, new IBaselineHandle[] { prevBaseline }, new IChangeSetHandle[0], null, null, null);
                return null;
            }
        }, monitor);
    }
}
