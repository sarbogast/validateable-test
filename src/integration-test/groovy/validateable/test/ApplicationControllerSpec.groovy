package validateable.test

import geb.spock.GebSpec
import grails.plugins.rest.client.RestBuilder
import grails.testing.mixin.integration.Integration
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.web.client.RestTemplate

@Integration
class ApplicationControllerSpec extends GebSpec {
    private RestBuilder restBuilder

    void 'get home index'() {
        when:
        def response = restBuilder().get(url('/'))

        then:
        response.status == 200
    }

    protected RestBuilder restBuilder() {
        if (!restBuilder) {
            RestTemplate restTemplate = new RestTemplate()
            restTemplate.requestFactory = new HttpComponentsClientHttpRequestFactory()
            restBuilder = new RestBuilder(restTemplate)
        }
        restBuilder
    }

    protected String url(String endpoint) {
        if (!endpoint.startsWith('/')) {
            endpoint = '/' + endpoint
        } else if(baseUrl.endsWith('/')) {
            endpoint = endpoint.substring(1)
        }
        "${baseUrl}${endpoint}"
    }
}
