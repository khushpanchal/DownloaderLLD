package com.khush.library.httpclient

import com.khush.library.internal.NetworkRequest

interface HttpClient {

    fun connect(req: NetworkRequest)
}