package validateable.test

import grails.testing.gorm.DataTest
import spock.lang.Specification

class MyDtoSpec extends Specification implements DataTest {

    void "test validateable classes participate in shared constraints"() {
        expect:
        !(new MyDto().validate())
    }
}
