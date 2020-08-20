package org.bravo.config

import io.quarkus.arc.config.ConfigProperties
import org.eclipse.microprofile.config.inject.ConfigProperty

@ConfigProperties(prefix = "qbdb")
class QBDBProperties {

    @ConfigProperties(prefix = "self")
    object Self {
        @ConfigProperty(name = "host")
        val host: String = ""

        @ConfigProperty(name = "port")
        val port: Int = 0
    }

    @ConfigProperties(prefix = "other")
    object Other {
        @ConfigProperty(name = "host")
        val host: String = ""

        @ConfigProperty(name = "port")
        val port: Int = 0
    }
}