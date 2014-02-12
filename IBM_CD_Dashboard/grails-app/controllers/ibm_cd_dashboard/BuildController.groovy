package ibm_cd_dashboard

import org.codehaus.groovy.grails.commons.ApplicationHolder

class BuildController {

    def allBuilds(){
        [builds:Build.getAll()]
    }

    def buildInfo(){
        [build:Build.get(params.id)]
    }

}
