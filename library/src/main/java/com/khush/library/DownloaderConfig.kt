package com.khush.library

data class DownloaderConfig(
    val connectTimeOut: Int = Constants.DEFAULT_CONNECT_TIMEOUT_MILLS,
    val readTimeOut: Int = Constants.DEFAULT_READ_TIMEOUT_MILLS
)
