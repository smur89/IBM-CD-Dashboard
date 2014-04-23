package ibm_cd_dashboard

import com.ibm.team.build.client.ITeamBuildClient
import com.ibm.team.build.common.model.IBuildDefinition
import com.ibm.team.build.common.model.IBuildDefinitionHandle
import com.ibm.team.build.common.model.IBuildResult
import com.ibm.team.build.common.model.IBuildResultHandle
import com.ibm.team.build.common.model.query.IBaseBuildResultQueryModel
import com.ibm.team.build.internal.client.iterator.ItemQueryIterator
import com.ibm.team.build.internal.client.workitem.WorkItemHelper
import com.ibm.team.filesystem.client.internal.rest.util.LoginUtil
import com.ibm.team.process.client.IProcessItemService
import com.ibm.team.process.common.IProjectArea
import com.ibm.team.repository.client.IItemManager
import com.ibm.team.repository.client.ITeamRepository
import com.ibm.team.repository.client.TeamPlatform
import com.ibm.team.repository.common.TeamRepositoryException
import com.ibm.team.repository.common.query.IItemQuery
import com.ibm.team.repository.common.service.IQueryService
import com.ibm.team.workitem.client.IWorkItemClient
import com.ibm.team.workitem.client.IWorkItemWorkingCopyManager
import com.ibm.team.workitem.client.WorkItemWorkingCopy
import com.ibm.team.workitem.common.internal.model.impl.WorkItemHandleImpl
import com.ibm.team.workitem.common.model.IWorkItem
import com.ibm.team.workitem.common.model.IWorkItemHandle
import grails.transaction.Transactional
import grails.util.Holders
import org.eclipse.core.runtime.NullProgressMonitor

@Transactional
/**
 * Service class for handling any functionality that requires access to the RTC server.
 */
class RTCService {
    final NullProgressMonitor monitor = new NullProgressMonitor()
    static final String USERID = "smur89"; // Retrieve the userId in a secure way
    static final String PASSWORD = "smur89"; // Retrieve the password in a secure way
    static final String URI = "https://localhost:9443/ccm";

    /**
     * If the Team Platform is not started already, start it.
     */
    def startService() {
        if (!TeamPlatform.isStarted()) {
            try {
                TeamPlatform.startup()
            } catch (Exception e) {
                println(e)
            }
        }
    }

    /**
     * Shutdown the RTC TeamPlatform
     */
    def shutdownService() {
        try {
            TeamPlatform.shutdown()
        } catch (Exception e) {
            println(e)
        }
    }

    /**
     * Login to the repository
     *
     * @param Uri
     * @param UserId
     * @param Password
     * @return Repository instance
     */
    def loginToRepo(String Uri, String UserId, String Password) {
        def teamRepository = null
        try {
            teamRepository = TeamPlatform.getTeamRepositoryService().getTeamRepository(Uri)
            teamRepository.registerLoginHandler(new LoginUtil.LoginHandler(UserId, Password))
            teamRepository.login(monitor)

        } catch (TeamRepositoryException tre) {
            log.error("loginToRepo Team Repository Exception: ${tre.getMessage()}}")
        } finally {

            //TeamPlatform.shutdown();
        }
        return teamRepository
    }

    /**
     * Gets all projects on the RTC server.
     *
     * @return List of Project Area objects on the RTC server
     */
    def List<IProjectArea> getAllProjects() {
        startService()
        def projects = null   // List<IProjectArea>
        try {
            ITeamRepository teamRepository = loginToRepo(URI, USERID, PASSWORD)
            IProcessItemService connect = (IProcessItemService) teamRepository.getClientLibrary(IProcessItemService.class)
            projects = connect.findAllProjectAreas(null, monitor)

        } catch (TeamRepositoryException e) {
            println(e.getMessage())
        } catch (IllegalStateException ise) {
            ise.printStackTrace()
        } finally {
            //shutdownService()
        }
        return projects
    }

    /**
     * Gets all project areas on the RTC server that are in an active state (i.e. not archived)
     *
     * @return List of Project Area objects active on the RTC server
     */
    def List<IProjectArea> getActiveProjects() {
        startService()
        try {
            def teamRepository = loginToRepo(URI, USERID, PASSWORD)

            IProcessItemService connect = (IProcessItemService) teamRepository.getClientLibrary(IProcessItemService.class);
            List<IProjectArea> projects = connect.findAllProjectAreas(null, monitor);
            List<IProjectArea> activeProjects = new ArrayList();

            //Create list of all project areas that are not in an archived state
            for (currProject in projects) {
                if (!currProject.archived) {
                    activeProjects.add(currProject)
                }
            }
            return activeProjects

        } catch (TeamRepositoryException e) {
            e.printStackTrace()
        } finally {
            //shutdownService()
        }
    }

    /**
     * Get all Builds for a given project area.
     *
     * @param project The project Area to return BuildResults for
     * @return List of BuildResult objects associated with the project area
     */
    def List<IBuildResult> getProjectBuildResults(IProjectArea project) {
        startService()
        try {
            def teamRepository = loginToRepo(URI, USERID, PASSWORD)
            ITeamBuildClient buildClient = (ITeamBuildClient) teamRepository.getClientLibrary(ITeamBuildClient.class)
            IItemManager itemManager = teamRepository.itemManager()
            IItemQuery itemQuery = IItemQuery.FACTORY.newInstance(IBaseBuildResultQueryModel.IBuildResultQueryModel.ROOT)
            ItemQueryIterator<IBuildResultHandle> iter = new ItemQueryIterator<IBuildResultHandle>(buildClient, itemQuery, IQueryService.EMPTY_PARAMETERS)

            List<IBuildResult> buildResults = new LinkedList<IBuildResult>()
            while (iter.hasNext(monitor)) {
                List<IBuildResultHandle> definitionHandles = iter.next(IQueryService.ITEM_QUERY_MAX_PAGE_SIZE, monitor)
                List<IBuildResult> items = itemManager.fetchCompleteItems(definitionHandles, IItemManager.DEFAULT, monitor)
                for (item in items) {
                    if (item != null && item.contextId == project.contextId) {
                        buildResults.add(item)
                    }
                }
            }
            //teamRepository.logout()
            return buildResults

        } catch (TeamRepositoryException tre) {
            log.error("getProjectBuildResults Team Repository Exception: ${tre.getMessage()}")
        } catch (NullPointerException npe) {
            log.error("getProjectBuildResults Null Pointer Exception: ${npe.getMessage()}")
        } catch (IllegalStateException ise) {
            log.error("getProjectBuildResults Illegal State Exception: ${ise.getMessage()}")
        } finally {
            //shutdownService()
        }
    }

    /**
     * Get all Builds for a given project area.
     *
     * @param buildResult The Build to return Work Items for
     * @return List of WorkItem objects associated with the project area
     */
    def ArrayList<IWorkItem> getBuildWorkItems(IBuildResult buildResult) {
        try {
            ITeamRepository teamRepository = loginToRepo(URI, USERID, PASSWORD)

            IWorkItemHandle[] workItemHandles = WorkItemHelper.getFixedInBuild(teamRepository, buildResult, monitor)
            List<IWorkItem> workItems = []
            if (!workItemHandles.toList().isEmpty()) {
                for (int i = 0; i < workItemHandles.length; i++) {
                    if (workItemHandles[i].class == WorkItemHandleImpl) {
                        IWorkItemClient itemClient = (IWorkItemClient) teamRepository.getClientLibrary(IWorkItemClient.class)
                        IWorkItemWorkingCopyManager copyManager = itemClient.getWorkItemWorkingCopyManager()
                        copyManager.connect(workItemHandles[i], IWorkItem.FULL_PROFILE, monitor)
                        WorkItemWorkingCopy itemCopy = copyManager.getWorkingCopy(workItemHandles[i])
                        workItems.add(itemCopy.getWorkItem())
                    }
                }
                return workItems
            } else {
                return null
            }
        } catch (TeamRepositoryException tre) {
            log.error("getBuildWorkItems Team Repository Exception: ${tre.getMessage()}")
        } catch (NullPointerException npe) {
            log.error("getBuildWorkItems Null Pointer Exception: ${npe.getMessage()}")
        } catch (IllegalStateException ise) {
            log.error("getBuildWorkItems Illegal State Exception: ${ise.getMessage()}")
        } finally {

        }
    }

    /**
     * Gets the build definition from a BuildDefinitionHandle
     *
     * @param buildDefHandle
     * @return The full BuildDefinition for the Handle
     */
    def getBuildDefinition(IBuildDefinitionHandle buildDefHandle) {
        try {
            ITeamRepository teamRepository = loginToRepo(URI, USERID, PASSWORD)
            IItemManager itemManager = teamRepository.itemManager();

            IBuildDefinition buildDef = (IBuildDefinition) itemManager.fetchPartialItem(buildDefHandle, IItemManager.DEFAULT,
                    Collections.singletonList(IBuildDefinition.PROPERTY_ID), monitor);

            return buildDef
        } catch (TeamRepositoryException tre) {
            log.error("getBuildDefinition Team Repository Exception: ${tre.getMessage()}")
        } catch (NullPointerException npe) {
            log.error("getBuildDefinition Null Pointer Exception: ${npe.getMessage()}")
        } catch (IllegalStateException ise) {
            log.error("getBuildDefinition Illegal State Exception: ${ise.getMessage()}")
        } finally {

        }
    }

    /**
     * Checks all projects on the server and returns the last time
     * the server was updated.
     *
     * @return time server was last updated
     */
    def checkServerLastUpdate() {
        try {
            def projects = getAllProjects()
            def serverModified = Holders.getGrailsApplication().config.ServerLastModified
            projects.each {
                if (it.modified() > serverModified) {
                    serverModified = it.modified()
                }
            }
            Holders.getGrailsApplication().config.ServerLastModified = serverModified
            log.info("Server Checked on: ${new Date()}. Server last updated : " << serverModified)
            return serverModified
        } catch (Exception e) {
            println(e.getMessage())
        }
    }
}
