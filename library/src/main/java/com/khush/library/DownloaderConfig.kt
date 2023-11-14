package com.khush.library

import com.khush.library.httpclient.DefaultHttpClient
import com.khush.library.httpclient.HttpClient

data class DownloaderConfig(
    val httpClient: HttpClient = DefaultHttpClient(),
    val connectTimeOut: Int = Constants.DEFAULT_CONNECT_TIMEOUT_MILLS,
    val readTimeOut: Int = Constants.DEFAULT_READ_TIMEOUT_MILLS
)
