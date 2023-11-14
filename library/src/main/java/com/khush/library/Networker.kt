package com.khush.library

import com.khush.library.internal.NetworkDispatcher
import com.khush.library.internal.NetworkRequest
import com.khush.library.internal.NetworkRequestQueue

class Networker private constructor(private val config: NetworkConfig){

    companion object {
        fun create(config: NetworkConfig = NetworkConfig()): Networker {
            return Networker(config)
        }
    }

    private val reqQueue = NetworkRequestQueue(NetworkDispatcher(config.httpClient))

    fun newBuilder(url: String): NetworkRequest.Builder {
        return NetworkRequest.Builder(url).readTimeout(config.readTimeOut)
            .connectTimeout(config.connectTimeOut)
    }

    fun enqueue(
        req: NetworkRequest,
        onStart: () -> Unit = {},
        onSuccess: (res: String) -> Unit = { _ -> },
        onError: (error: String) -> Unit = { _ -> }
    ): Int {
        req.onStart = onStart
        req.onSuccess = onSuccess
        req.onError = onError
        return reqQueue.enqueue(req)
    }

    fun cancel(id: Int) {
        reqQueue.cancel(id)
    }

    fun cancel(tag: String) {
        reqQueue.cancel(tag)
    }

    fun cancelAll() {
        reqQueue.cancelAll()
    }
}