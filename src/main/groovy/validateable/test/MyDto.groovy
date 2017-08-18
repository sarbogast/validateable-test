package validateable.test

import grails.validation.Validateable

class MyDto implements Validateable {
    String name

    static constraints = {
        name shared: 'nonEmpty'
    }
}
