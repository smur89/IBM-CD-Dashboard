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
import com.ibm.team.repository.common.TeamRepositoryException;

/**
 * Plain Java Snippet: Connecting to a repository
 */
public class Snippet1 {

    private static String REPOSITORY_ADDRESS = System.getProperty("repositoryAddress", "https://localhost:9443/jazz");
    private static String USER_AND_PASSWORD = System.getProperty("snippetUserAndPassword", "test");
    
    public static void main(String[] args) {
        TeamPlatform.startup();
        try {     
            IProgressMonitor monitor = new SysoutProgressMonitor();
            login(monitor);
        } catch (TeamRepositoryException e) {
            System.out.println("Unable to login: " + e.getMessage());
        } finally {
            TeamPlatform.shutdown();
        }
    }

    public static ITeamRepository login(IProgressMonitor monitor) throws TeamRepositoryException {
        ITeamRepository repository = TeamPlatform.getTeamRepositoryService().getTeamRepository(REPOSITORY_ADDRESS);
        repository.registerLoginHandler(new ITeamRepository.ILoginHandler() {
            public ILoginInfo challenge(ITeamRepository repository) {
                return new ILoginInfo() {
                    public String getUserId() {
                        return USER_AND_PASSWORD;
                    }
                    public String getPassword() {
                        return USER_AND_PASSWORD;                        
                    }
                };
            }
        });
        monitor.subTask("Contacting " + repository.getRepositoryURI() + "...");
        repository.login(monitor);
        monitor.subTask("Connected");
        return repository;
    }
}
