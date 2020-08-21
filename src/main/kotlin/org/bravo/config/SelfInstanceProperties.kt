package org.bravo.config

import io.quarkus.vertx.http.runtime.HttpConfiguration
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SelfInstanceProperties {

    @Inject
    private lateinit var httpConfiguration: HttpConfiguration

    val host: String by lazy {
        httpConfiguration.host
    }

    val port: Int by lazy {
        httpConfiguration.port
    }
}
