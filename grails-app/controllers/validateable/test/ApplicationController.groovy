package validateable.test

import grails.core.GrailsApplication
import grails.util.Environment
import grails.plugins.*

class ApplicationController implements PluginManagerAware {

    GrailsApplication grailsApplication
    GrailsPluginManager pluginManager

    def index() {
        MyDto dto = new MyDto(name: 'foo')
        if(dto.validate()){
            [grailsApplication: grailsApplication, pluginManager: pluginManager]
        } else {
            render status: 500
        }
    }
}
