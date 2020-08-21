package org.bravo.server.config

import io.quarkus.vertx.web.Route
import io.quarkus.vertx.web.RoutingExchange
import io.smallrye.mutiny.Uni
import io.vertx.core.http.HttpMethod
import org.bravo.config.OtherInstanceProperties
import org.bravo.config.SelfInstanceProperties
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class ConfigRouter {

    @Inject
    lateinit var otherProperties: OtherInstanceProperties

    @Inject
    lateinit var selfProperties: SelfInstanceProperties

    @Route(path = "/otherProperties", methods = [HttpMethod.GET], produces = ["application/json"])
    fun getOtherProperties(routingContext: RoutingExchange): Uni<OtherInstanceProperties> =
        Uni.createFrom().item(otherProperties)

    @Route(path = "/selfProperties", methods = [HttpMethod.GET], produces = ["application/json"])
    fun getSelfProperties(): Uni<SelfInstanceProperties> =
        Uni.createFrom().item(selfProperties)
}
