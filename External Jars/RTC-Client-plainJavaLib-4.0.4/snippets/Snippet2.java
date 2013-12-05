/*******************************************************************************
 * Licensed Materials - Property of IBM
 * (c) Copyright IBM Corporation 2006, 2012. All Rights Reserved. 
 * 
 * Note to U.S. Government Users Restricted Rights:  Use, 
 * duplication or disclosure restricted by GSA ADP Schedule 
 * Contract with IBM Corp.
 *******************************************************************************/
package snippets;

import java.util.Collections;
import java.util.Date;

import org.eclipse.core.runtime.IProgressMonitor;

import com.ibm.team.filesystem.client.FileSystemCore;
import com.ibm.team.filesystem.client.IFileContentManager;
import com.ibm.team.filesystem.common.FileLineDelimiter;
import com.ibm.team.filesystem.common.IFileContent;
import com.ibm.team.filesystem.common.IFileItem;
import com.ibm.team.process.common.ITeamAreaHandle;
import com.ibm.team.repository.client.ITeamRepository;
import com.ibm.team.repository.client.TeamPlatform;
import com.ibm.team.repository.common.ItemNotFoundException;
import com.ibm.team.repository.common.TeamRepositoryException;
import com.ibm.team.scm.client.IFlowNodeConnection.IComponentOp;
import com.ibm.team.scm.client.IFlowNodeConnection.IComponentOpFactory;
import com.ibm.team.scm.client.IWorkspaceConnection;
import com.ibm.team.scm.client.IWorkspaceManager;
import com.ibm.team.scm.client.SCMPlatform;
import com.ibm.team.scm.client.content.util.VersionedContentManagerByteArrayInputStreamPovider;
import com.ibm.team.scm.common.ComponentNotInWorkspaceException;
import com.ibm.team.scm.common.IChangeSetHandle;
import com.ibm.team.scm.common.IComponentHandle;
import com.ibm.team.scm.common.IFolder;
import com.ibm.team.scm.common.WorkspaceComparisonFlags;
import com.ibm.team.scm.common.dto.IChangeHistorySyncReport;

/**
 * Plain Java Snippet: Create a stream, a repository workspace, and deliver changes to the stream from the
 * repository workspace.
 */
public class Snippet2 {

    public static void main(String[] args) {
        TeamPlatform.startup();
        try {       
            IProgressMonitor monitor = new SysoutProgressMonitor();
            ITeamRepository repo = Snippet1.login(monitor);
            addFilesToStream(repo, monitor);
        } catch (TeamRepositoryException e) {
            System.out.println("Unable to login: " + e.getMessage());
        } finally {
            TeamPlatform.shutdown();
        }
    }

    public static IWorkspaceConnection addFilesToStream(ITeamRepository repo, IProgressMonitor monitor) throws TeamRepositoryException, ItemNotFoundException, ComponentNotInWorkspaceException {
        ITeamAreaHandle teamArea = Snippet3.createProject(repo, "Snippet 2");
        IWorkspaceManager wm = SCMPlatform.getWorkspaceManager(repo);

        IWorkspaceConnection workspace = wm.createWorkspace(repo.loggedInContributor(), "Example Workspace", "Description", monitor);
        IComponentHandle component = wm.createComponent("Component", repo.loggedInContributor(), monitor);
        IComponentOpFactory componentOpFactory = workspace.componentOpFactory();
        IComponentOp addComponentOp = componentOpFactory.addComponent(component, false);
        workspace.applyComponentOperations(Collections.singletonList(addComponentOp), false, monitor);

        // create the stream seeded from the workspace
        IWorkspaceConnection stream = wm.createStream(teamArea, "Example Stream", "Description", monitor);
        addComponentOp = componentOpFactory.addComponent(component, false);
        stream.applyComponentOperations(Collections.singletonList(addComponentOp), false, monitor);

        // The root folder is created when the component is created.
        // add a folder called 'project' to the workspace
        IChangeSetHandle cs1 = workspace.createChangeSet(component, monitor);
        IFolder rootFolder = (IFolder) workspace.configuration(component).rootFolderHandle(monitor);
                
        // create source folder ("/project")
        IFolder projectFolder= (IFolder) IFolder.ITEM_TYPE.createItem();
        projectFolder.setParent(rootFolder);
        projectFolder.setName("project");
        workspace.commit(cs1, Collections
                        .singletonList(workspace.configurationOpFactory().save(projectFolder)), monitor);      
        
        // add a file called 'file.txt' under the 'project' folder.
        IFileItem file = (IFileItem) IFileItem.ITEM_TYPE.createItem();
        file.setName("file.txt");
        file.setParent(projectFolder);
        IFileContentManager contentManager = FileSystemCore.getContentManager(repo);
        IFileContent storedContent = contentManager.storeContent(
                    IFileContent.ENCODING_US_ASCII,
                    FileLineDelimiter.LINE_DELIMITER_PLATFORM,
                    new VersionedContentManagerByteArrayInputStreamPovider("The contents of my file.txt".getBytes()),
                    null, monitor);
        file.setContentType(IFileItem.CONTENT_TYPE_TEXT);
        file.setContent(storedContent);
        file.setFileTimestamp(new Date());
        workspace.commit(cs1, Collections
                .singletonList(workspace.configurationOpFactory().save(file)), monitor);      

        // deliver the changes to the stream
        IChangeHistorySyncReport sync = 
           workspace.compareTo(stream, WorkspaceComparisonFlags.CHANGE_SET_COMPARISON_ONLY, 
                   Collections.EMPTY_LIST, monitor); 
        workspace.deliver(stream, sync, Collections.EMPTY_LIST, 
           sync.outgoingChangeSets(component), monitor);
        monitor.subTask("Created changes and delivered to " + stream.getName());
        return workspace;
    }
}
