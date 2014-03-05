package ibm_cd_dashboard

import com.ibm.team.process.common.IProjectArea
import grails.test.mixin.TestFor
import org.mockito.Mockito
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(DomainService)
class DomainServiceSpec extends Specification {
    IProjectArea mockProjectArea = Mockito.mock(IProjectArea.class)

    def setup() {
        //Setup Mock ProjectArea
        Mockito.when(mockProjectArea.getItemId()).thenReturn(com.ibm.team.repository.common.UUID.generate())
        Mockito.when(mockProjectArea.getName()).thenReturn("Mock Project Name")
    }

    def cleanup() {
    }

    void "test something"() {
        setup:

        when:
        mockProjectArea.getName()
        then:
        mockProjectArea.getName() == "Mock Project Name"
    }
}
