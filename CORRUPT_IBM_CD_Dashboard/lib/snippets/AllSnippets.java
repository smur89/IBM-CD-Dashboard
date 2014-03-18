package snippets;
/*******************************************************************************
 * Licensed Materials - Property of IBM
 * (c) Copyright IBM Corporation 2006, 2012. All Rights Reserved. 
 * 
 * Note to U.S. Government Users Restricted Rights:  Use, 
 * duplication or disclosure restricted by GSA ADP Schedule 
 * Contract with IBM Corp.
 *******************************************************************************/
import org.eclipse.core.runtime.IProgressMonitor;


import com.ibm.team.repository.client.ITeamRepository;
import com.ibm.team.repository.client.TeamPlatform;
import com.ibm.team.scm.client.IWorkspaceConnection;

public class AllSnippets {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TeamPlatform.startup();
        try {           
            IProgressMonitor monitor = new SysoutProgressMonitor();

            // Repository
            ITeamRepository repo = Snippet1.login(monitor);
            
            // Process
            Snippet3.createProject(repo, "All Snippets - " + System.currentTimeMillis());
            
            // SCM
            IWorkspaceConnection workspace = Snippet2.addFilesToStream(repo, monitor);
            Snippet4.printTree(repo, workspace, monitor);
            
            // Work Items
            Snippet5.createWorkItem(repo, monitor);
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(1);
        } finally {
            TeamPlatform.shutdown();
        }
    }
}
