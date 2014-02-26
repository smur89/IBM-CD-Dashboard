package ibm_cd_dashboard

import com.ibm.team.build.client.ITeamBuildClient
import com.ibm.team.build.common.model.IBuildDefinition
import com.ibm.team.build.common.model.IBuildDefinitionHandle
import com.ibm.team.build.common.model.IBuildResult
import com.ibm.team.build.common.model.IBuildResultHandle
import com.ibm.team.build.common.model.query.IBaseBuildResultQueryModel
import com.ibm.team.build.internal.client.iterator.ItemQueryIterator
import com.ibm.team.build.internal.client.workitem.WorkItemHelper
import com.ibm.team.build.internal.common.links.BuildLinkTypes
import com.ibm.team.filesystem.client.internal.rest.util.LoginUtil
import com.ibm.team.links.client.ILinkManager
import com.ibm.team.links.common.ILink
import com.ibm.team.links.common.ILinkCollection
import com.ibm.team.links.common.IReference
import com.ibm.team.process.client.IProcessItemService
import com.ibm.team.process.common.IProjectArea
import com.ibm.team.repository.client.IItemManager
import com.ibm.team.repository.client.ITeamRepository
import com.ibm.team.repository.client.TeamPlatform
import com.ibm.team.repository.common.IContributor
import com.ibm.team.repository.common.IContributorHandle
import com.ibm.team.repository.common.TeamRepositoryException
import com.ibm.team.repository.common.query.IItemQuery
import com.ibm.team.repository.common.service.IQueryService
import com.ibm.team.workitem.client.IAuditableClient
import com.ibm.team.workitem.client.IQueryClient
import com.ibm.team.workitem.client.IWorkItemClient
import com.ibm.team.workitem.client.IWorkItemWorkingCopyManager
import com.ibm.team.workitem.client.WorkItemWorkingCopy
import com.ibm.team.workitem.common.expression.AttributeExpression
import com.ibm.team.workitem.common.expression.Expression
import com.ibm.team.workitem.common.expression.IQueryableAttribute
import com.ibm.team.workitem.common.expression.QueryableAttributes
import com.ibm.team.workitem.common.internal.model.impl.WorkItemHandleImpl
import com.ibm.team.workitem.common.model.AttributeOperation
import com.ibm.team.workitem.common.model.IWorkItem
import com.ibm.team.workitem.common.model.IWorkItemHandle
import com.ibm.team.workitem.common.query.IQueryResult
import com.ibm.team.workitem.common.query.IResolvedResult
import grails.transaction.Transactional
import grails.util.Holders
import org.eclipse.core.runtime.NullProgressMonitor

@Transactional
class RTCBuildService {
    final NullProgressMonitor monitor = new NullProgressMonitor()
    static final String USERID = "smur89"; // Retrieve the userId in a secure way
    static final String PASSWORD = "smur89"; // Retrieve the password in a secure way
    static final String URI = "https://localhost:9443/ccm";

    /**
     * If the Team Platform is not started already, start it.
     */
    def startService() {
        if (!TeamPlatform.isStarted()) {
            TeamPlatform.startup()
        }
    }

    def shutdownService() {
        TeamPlatform.shutdown()
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
        try {
            ITeamRepository teamRepository = TeamPlatform.getTeamRepositoryService().getTeamRepository(Uri)
            teamRepository.registerLoginHandler(new LoginUtil.LoginHandler(UserId, Password))
            teamRepository.login(monitor)
            return teamRepository

        } catch (TeamRepositoryException e) {
            e.printStackTrace()
        } finally {
            //TeamPlatform.shutdown();
        }
    }

    def List<IProjectArea> getAllProjects() {
        startService()
        try {
            ITeamRepository teamRepository = loginToRepo(URI, USERID, PASSWORD)
            IProcessItemService connect = (IProcessItemService) teamRepository.getClientLibrary(IProcessItemService.class)
            List<IProjectArea> projects = connect.findAllProjectAreas(null, monitor)
            //teamRepository.logout()

            return projects

        } catch (TeamRepositoryException e) {
            e.printStackTrace()
        } catch (IllegalStateException ise) {
            ise.printStackTrace()
        } finally {
            //shutdownService()
        }
    }

    def updateServerLastModified() {
       // startService()
        try {
            def teamRepository = loginToRepo(URI, USERID, PASSWORD)

            IProcessItemService connect = (IProcessItemService) teamRepository.getClientLibrary(IProcessItemService.class);
            List<IProjectArea> projects = connect.findAllProjectAreas(null, null);
            def lastMod = null

            //Create list of all project areas that are not in an archived state
            def grailsApplication = Holders.getGrailsApplication()
            for (currProject in projects) {
                if (currProject.modified() > lastMod ) {
                    lastMod = currProject.modified()
                }
            }
            //teamRepository.logout();
            grailsApplication.config.ServerLastModified = lastMod

        } catch (TeamRepositoryException e) {
            e.printStackTrace()
        } finally {
            //shutdownService()
        }
    }

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

            //teamRepository.logout();
            return activeProjects

        } catch (TeamRepositoryException e) {
            e.printStackTrace()
        } finally {
            //shutdownService()
        }
    }

    def getAllBuildResults() {
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
                    if (item != null) {
                        buildResults.add(item)
                    }
                }
            }
            //teamRepository.logout()
            buildResults

        } catch (TeamRepositoryException e) {
            println("getAllBuildResults Team Repository Exception: " << tre.printStackTrace())
        } catch (NullPointerException npe) {
            println("getAllBuildResults Null Pointer Exception: " << npe.printStackTrace())
        } catch (IllegalStateException ise) {
            println("getAllBuildResults Illegal State Exception: " << ise.printStackTrace())
        } finally {
            //shutdownService()
        }
    }

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
            println("getProjectBuildResults Team Repository Exception: " << tre.printStackTrace())
        } catch (NullPointerException npe) {
            println("getProjectBuildResults Null Pointer Exception: " << npe.printStackTrace())
        } catch (IllegalStateException ise) {
            println("getProjectBuildResults Illegal State Exception: " << ise.printStackTrace())
        } finally {
            //shutdownService()
        }
    }

    def List<IContributor> getProjectMembers(IProjectArea projectArea) {
        try {
            ITeamRepository teamRepository = loginToRepo(URI, USERID, PASSWORD)
            IContributorHandle[] membersHandle = projectArea.getMembers()
            List<IContributor> members = []
            for (IContributorHandle member in membersHandle) {
                members.add((IContributor) teamRepository.itemManager().fetchCompleteItem(member, IItemManager.DEFAULT, monitor))
            }
            return members

        } catch (TeamRepositoryException tre) {
            println("getProjectMembers Team Repository Exception: " << tre.printStackTrace())
        } catch (NullPointerException npe) {
            println("getProjectMembers Null Pointer Exception: " << npe.printStackTrace())
        } catch (IllegalStateException ise) {
            println("getProjectMembers Illegal State Exception: " << ise.printStackTrace())
        } finally {

        }

    }

    def IQueryResult<IResolvedResult<IWorkItem>> getProjectWorkItems(IProjectArea projectArea) {
        try {
            ITeamRepository teamRepository = loginToRepo(URI, USERID, PASSWORD)
            IAuditableClient auditableClient = (IAuditableClient) teamRepository.getClientLibrary(IAuditableClient.class)
            IQueryClient queryClient = (IQueryClient) teamRepository.getClientLibrary(IQueryClient.class)

            IQueryableAttribute attribute = QueryableAttributes.getFactory(IWorkItem.ITEM_TYPE).findAttribute(projectArea, IWorkItem.PROJECT_AREA_PROPERTY, auditableClient, null)
            Expression expression = new AttributeExpression(attribute, AttributeOperation.EQUALS, projectArea)
            IQueryResult<IResolvedResult<IWorkItem>> results = queryClient.getResolvedExpressionResults(projectArea, expression, IWorkItem.FULL_PROFILE)

            return results
        } catch (TeamRepositoryException tre) {
            println("getProjectWorkItems Team Repository Exception: " << tre.printStackTrace())
        } catch (NullPointerException npe) {
            println("getProjectWorkItems Null Pointer Exception: " << npe.printStackTrace())
        } catch (IllegalStateException ise) {
            println("getProjectWorkItems Illegal State Exception: " << ise.printStackTrace())
        } finally {

        }
    }

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
            println("getBuildWorkItems Team Repository Exception: " << tre.printStackTrace())
        } catch (NullPointerException npe) {
            println("getBuildWorkItems Null Pointer Exception: " << npe.printStackTrace())
        } catch (IllegalStateException ise) {
            println("getBuildWorkItems Illegal State Exception: " << ise.printStackTrace())
        } finally {

        }
    }

    def getBuildDefinition(IBuildDefinitionHandle buildDefHandle) {
        try {
            ITeamRepository teamRepository = loginToRepo(URI, USERID, PASSWORD)
            IItemManager itemManager = teamRepository.itemManager();

            IBuildDefinition buildDef = (IBuildDefinition) itemManager.fetchPartialItem(buildDefHandle, IItemManager.DEFAULT,
                    Collections.singletonList(IBuildDefinition.PROPERTY_ID), monitor);

            return buildDef
        } catch (TeamRepositoryException tre) {
            println("getBuildDefinition Team Repository Exception: " << tre.printStackTrace())
        } catch (NullPointerException npe) {
            println("getBuildDefinition Null Pointer Exception: " << npe.printStackTrace())
        } catch (IllegalStateException ise) {
            println("getBuildDefinition Illegal State Exception: " << ise.printStackTrace())
        } finally {

        }

    }

}
