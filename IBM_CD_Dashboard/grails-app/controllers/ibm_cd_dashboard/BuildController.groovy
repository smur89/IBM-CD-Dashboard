package ibm_cd_dashboard

/**
 * Controls all logic and requests relating to the Build domain model.
 *
 * @author  Shane Murphy
 * @version 1.0
 * @since   2014-05-07
 */
class BuildController {

    /**
     * Show a list of all builds
     *
     * @return allBuilds.gsp
     */
    def allBuilds() {
        [builds: Build.getAll()]
    }

    /**
     * Display the buildInfo page which shows build metrics for this
     * particular build and links to it's workitems.
     *
     * @param The Build object to be displayed
     */
    def buildInfo() {
        [build: Build.get(params.id)]
    }

}
