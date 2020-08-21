package org.bravo.storage.instance

import org.bravo.model.Instance
import java.util.concurrent.CopyOnWriteArrayList
import javax.inject.Singleton

@Singleton
class InstanceStorage {

    private val storage = CopyOnWriteArrayList<Instance>()

    fun put(item: Instance): Boolean =
        storage.add(item)

    fun getByHost(host: String): List<Instance> =
        storage.filter {
            it.host == host
        }

    fun get(host: String, port: Int): Instance? =
        storage.find {
            it.host == host && it.port == port
        }

    fun remove(host: String, port: Int): Boolean =
        get(host, port)?.let {
            storage.remove(it)
        } ?: false

    fun exists(host: String, port: Int): Boolean =
        get(host, port) != null
}
