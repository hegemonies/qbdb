package org.bravo.service

import org.bravo.model.Instance
import org.bravo.storage.instance.InstanceStorage
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InstanceService {

    @Inject
    lateinit var instanceStorage: InstanceStorage

    fun registrationIfNotExists(instance: Instance): Boolean {
        if (!instanceStorage.exists(instance.host, instance.port)) {
            return instanceStorage.put(instance)
        }

        return true
    }
}