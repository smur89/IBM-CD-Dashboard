package snippets;
/*******************************************************************************
 * Licensed Materials - Property of IBM
 * (c) Copyright IBM Corporation 2006, 2012. All Rights Reserved. 
 * 
 * Note to U.S. Government Users Restricted Rights:  Use, 
 * duplication or disclosure restricted by GSA ADP Schedule 
 * Contract with IBM Corp.
 *******************************************************************************/
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;

import com.ibm.team.repository.client.IItemManager;
import com.ibm.team.repository.client.ITeamRepository;
import com.ibm.team.repository.client.TeamPlatform;
import com.ibm.team.repository.common.TeamRepositoryException;
import com.ibm.team.scm.client.IConfiguration;
import com.ibm.team.scm.client.IWorkspaceConnection;
import com.ibm.team.scm.common.IComponent;
import com.ibm.team.scm.common.IFolderHandle;
import com.ibm.team.scm.common.IVersionableHandle;

/**
 * Prints all the contents of a repository workspace or stream.
 */
public class Snippet4 {
	public static void main(String[] args) {
        TeamPlatform.startup();
        try {            
            IProgressMonitor monitor = new SysoutProgressMonitor();
            ITeamRepository repo = Snippet1.login(monitor);            
            IWorkspaceConnection workspace = Snippet2.addFilesToStream(repo, monitor);
            printTree(repo, workspace, monitor);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        } finally {
            TeamPlatform.shutdown();
        }
    }
    
    public static void printTree(ITeamRepository repo, IWorkspaceConnection workspace, IProgressMonitor monitor) throws TeamRepositoryException {
        List components = repo.itemManager().fetchCompleteItems(workspace.getComponents(), IItemManager.DEFAULT, null);        
        for (Iterator<IComponent> it = components.iterator(); it.hasNext();) {
			IComponent component = it.next();
			monitor.subTask(component.getName());
			printComponentFileTree(workspace, component, workspace.configuration(component), null, "  ", monitor);
		}
    }
    
    private static void printComponentFileTree(IWorkspaceConnection workspace,
			IComponent component, IConfiguration configuration, IFolderHandle parent, String indent, IProgressMonitor monitor) throws TeamRepositoryException {
    	Map<String, IVersionableHandle> children = null;
    	if(parent == null) {
    		children = configuration.childEntriesForRoot(null);
    	} else {
    		children = configuration.childEntries(parent, null);
    	}
    	if(children != null) {
    		for (String name : children.keySet()) {
    		    monitor.subTask(indent + name);
				IVersionableHandle item = children.get(name);
				if(item instanceof IFolderHandle)
					printComponentFileTree(workspace, component, configuration, (IFolderHandle)item, indent + "  ", monitor);
			} 
    	}
	}
}
