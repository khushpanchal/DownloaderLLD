package com.khush.library.internal

class NetworkRequestQueue(private val dispatcher: NetworkDispatcher) {

    private val idRequestMap: HashMap<Int, NetworkRequest> = hashMapOf()

    fun enqueue(request: NetworkRequest): Int {
        idRequestMap[request.networkId] = request
        return dispatcher.enqueue(request)
    }

    fun cancel(id: Int) {
        idRequestMap[id]?.let {
            dispatcher.cancel(it)
        }
        idRequestMap.remove(id)
    }

    fun cancel(tag: String) {
        val requestsWithTag = idRequestMap.values.filter {
            it.tag == tag
        }
        for (req in requestsWithTag) {
            cancel(req.networkId)
        }
    }

    fun cancelAll() {
        idRequestMap.clear()
        dispatcher.cancelAll()
    }

}