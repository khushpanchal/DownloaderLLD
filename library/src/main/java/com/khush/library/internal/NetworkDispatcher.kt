package com.khush.library.internal

import com.khush.library.httpclient.HttpClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class NetworkDispatcher(private val httpClient: HttpClient) {

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    fun enqueue(req: NetworkRequest): Int {
        val job = scope.launch {
            execute(req)
        }
        req.job = job
        return req.networkId
    }

    private suspend fun execute(request: NetworkRequest) {
        NetworkTask(httpClient, request).run (
            onStart = {
                executeOnMainThread { request.onStart() }
            },
            onSuccess = {
                executeOnMainThread { request.onSuccess(it) }
            },
            onError = {
                executeOnMainThread { request.onError(it) }
            }
        )
    }

    private fun executeOnMainThread(block: () -> Unit) {
        scope.launch {
            block()
        }
    }

    fun cancel(req: NetworkRequest) {
        req.job.cancel()
    }

    fun cancelAll() {
        scope.cancel()
    }

}