package com.khush.library.httpclient

import com.khush.library.internal.DownloadRequest

interface HttpClient {

    fun connect(req: DownloadRequest)
}