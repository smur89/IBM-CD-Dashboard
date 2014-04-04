package ibm_cd_dashboard

class BuildTestMetrics {

    static belongsTo = [build:Build]

    static constraints = {
    }

    def BuildTestMetrics(int commitPhaseTime){
        commitPhaseTestingTime = commitPhaseTime
    }

    def commitPhaseTestingTime = 0
}
