package snippets;
/*******************************************************************************
 * Licensed Materials - Property of IBM
 * (c) Copyright IBM Corporation 2006, 2012. All Rights Reserved. 
 * 
 * Note to U.S. Government Users Restricted Rights:  Use, 
 * duplication or disclosure restricted by GSA ADP Schedule 
 * Contract with IBM Corp.
 *******************************************************************************/
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;

import com.ibm.team.process.client.IClientProcess;
import com.ibm.team.process.client.IProcessItemService;
import com.ibm.team.process.client.workingcopies.IProcessAreaWorkingCopy;
import com.ibm.team.process.common.IDescription;
import com.ibm.team.process.common.IDevelopmentLine;
import com.ibm.team.process.common.IDevelopmentLineHandle;
import com.ibm.team.process.common.IProcessArea;
import com.ibm.team.process.common.IProcessDefinition;
import com.ibm.team.process.common.IProcessItem;
import com.ibm.team.process.common.IProjectArea;
import com.ibm.team.process.common.IProjectAreaHandle;
import com.ibm.team.process.common.IRole;
import com.ibm.team.process.common.ITeamArea;
import com.ibm.team.process.common.ITeamAreaHandle;
import com.ibm.team.repository.client.IItemManager;
import com.ibm.team.repository.client.ITeamRepository;
import com.ibm.team.repository.client.TeamPlatform;
import com.ibm.team.repository.common.IContributor;
import com.ibm.team.repository.common.TeamRepositoryException;

/**
 * Plain Java Snippet: Creating a project area and team area.
 */
public class Snippet3 {

    public static void main(String[] args) {
        TeamPlatform.startup();
        try {          
            IProgressMonitor monitor = new SysoutProgressMonitor();
            ITeamRepository repo = Snippet1.login(monitor);
            createProject(repo, "Snippet 3");
        } catch (TeamRepositoryException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            TeamPlatform.shutdown();
        }
    }

    public static ITeamAreaHandle createProject(ITeamRepository repo, String projectName) throws TeamRepositoryException {
        IProgressMonitor monitor = new NullProgressMonitor();            
        IProcessItemService service= (IProcessItemService) repo.getClientLibrary(IProcessItemService.class);
        String SCRUM_PROCESS = "scrum2.process.ibm.com";
        IProcessDefinition[] definitions = service.deployPredefinedProcessDefinitions(new String[] { SCRUM_PROCESS }, new NullProgressMonitor());
        if (definitions.length == 0) {
            throw new TeamRepositoryException("Process template " + SCRUM_PROCESS + " does not exist.");
        }
        IProjectArea area = service.createProjectArea();
        
        area.setName(projectName + " - " + System.currentTimeMillis());
        area.setProcessDefinition(definitions[0]);
        IDescription description = area.getDescription();
        description.setSummary(projectName + " example project based on the Scrum project template");
        area = (IProjectArea) service.save(area, monitor);
        // Create team
        ITeamArea teamArea = service.createTeamArea();
        teamArea.setName(projectName);
        teamArea.addMember(repo.loggedInContributor());
        teamArea.setProjectArea(area);
        area = (IProjectArea) service.getMutableCopy(area);
        
        area.getTeamAreaHierarchy().addRoot(teamArea, area.getDevelopmentLines()[0]);
        IProcessItem[] items = service.save(new IProcessItem[] {area, teamArea}, monitor);
        service.initialize(area, monitor);
        
        IRole role = getRole(area);
        teamArea = (ITeamArea) items[1];
        
        IProcessAreaWorkingCopy areaWc = (IProcessAreaWorkingCopy)service.getWorkingCopyManager().createPrivateWorkingCopy(teamArea);
        areaWc.getTeam().addContributorsSettingRoleCast(
                new IContributor[] {repo.loggedInContributor()}, 
                new IRole[] {role});
        areaWc.save(monitor);
        
        monitor.subTask("Created project and team called " + area.getName());
        return teamArea; 
    }
    
    public static IRole getRole(IProcessArea area) throws TeamRepositoryException {
        ITeamRepository repo = (ITeamRepository) area.getOrigin();
        IProcessItemService service =(IProcessItemService) repo
            .getClientLibrary(IProcessItemService.class);
        IClientProcess clientProcess = service.getClientProcess(area, null);
        IRole[] availableRoles = clientProcess.getRoles(area, null);
        for (int i = 0; i < availableRoles.length; i++) {
            return availableRoles[i];
        }
        throw new IllegalArgumentException("Couldn't find role");
    }
    
    public static IDevelopmentLineHandle getDevelopmentLine(IProjectAreaHandle projectAreaHandle, String developmentLineId, IProgressMonitor monitor) throws TeamRepositoryException {
        if (monitor == null) {
            monitor = new NullProgressMonitor();
        }
        ITeamRepository teamRepository = (ITeamRepository) projectAreaHandle.getOrigin();
        IProjectArea projectArea = (IProjectArea) teamRepository.itemManager().fetchCompleteItem(projectAreaHandle, IItemManager.DEFAULT, new SubProgressMonitor(monitor, 500));
        IDevelopmentLineHandle[] developmentLineHandles = projectArea.getDevelopmentLines();
        if (developmentLineHandles != null) {
            List developmentLines = teamRepository.itemManager().fetchCompleteItems(Arrays.asList(developmentLineHandles), IItemManager.DEFAULT, new SubProgressMonitor(monitor, 500));
            for (Iterator e = developmentLines.iterator(); e.hasNext();) {
                IDevelopmentLine line = (IDevelopmentLine) e.next();
                if (line != null) {
                    if (developmentLineId.equals(line.getId())) {
                        return line;
                    }
                }
            }
        }
        throw new TeamRepositoryException("Cannot find a development line");
    }
}
