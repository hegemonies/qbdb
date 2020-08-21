package org.bravo.config

import io.quarkus.arc.config.ConfigProperties
import org.eclipse.microprofile.config.inject.ConfigProperty
import javax.validation.constraints.Max
import javax.validation.constraints.Min

@ConfigProperties(prefix = "qbdb.other")
class OtherInstanceProperties {

    @ConfigProperty(defaultValue = "localhost")
    lateinit var host: String

    @Min(8000)
    @Max(9000)
    var port: Int = 8919
}
