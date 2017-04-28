package grails3rest

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces


@Secured(['ROLE_ADMIN'])
class TestController {

    def renderData() {
        println "hellooooooooooooooooo"
        return "Stringggggggg"
    }
}
