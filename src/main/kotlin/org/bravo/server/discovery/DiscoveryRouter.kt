package org.bravo.server.discovery

import io.quarkus.vertx.web.Body
import io.quarkus.vertx.web.Route
import io.vertx.core.http.HttpMethod
import org.bravo.model.Answer
import org.bravo.model.Instance
import org.bravo.service.InstanceService
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class DiscoveryRouter {

    @Inject
    lateinit var instanceService: InstanceService

    @Route(path = "/instanceRegistration", methods = [HttpMethod.POST], produces = ["application/json"])
    fun registration(@Body instance: Instance): Answer {
        if (!instanceService.registrationIfNotExists(instance)) {
            return Answer(status = false, message = "Can not registration of instance [$instance]")
        }

        return Answer()
    }
}
