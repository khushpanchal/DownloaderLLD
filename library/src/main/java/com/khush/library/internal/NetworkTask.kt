package com.khush.library.internal

import com.khush.library.httpclient.HttpClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class NetworkTask(private val httpClient: HttpClient, private val request: NetworkRequest) {

    suspend fun run(
        onStart: () -> Unit = {},
        onSuccess: (res: String) -> Unit = {_->},
        onError: (error: String) -> Unit = {_->}
    ) {
        withContext(Dispatchers.IO) {
            // dummy code for downloading the file

            onStart()

            try {
                // use of HttpClient
                httpClient.connect(request)
                onSuccess("Success")
            } catch (e: Exception) {
                onError(e.message.toString())
            }

        }
    }
}