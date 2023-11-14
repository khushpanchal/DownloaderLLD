package com.khush.library.internal

import com.khush.library.utils.getUniqueId
import kotlinx.coroutines.Job

class NetworkRequest private constructor(
    internal var url: String,
    internal val tag: String?,
    internal val networkId: Int,
    internal var readTimeOut: Int,
    internal var connectTimeOut: Int,
) {

    internal var totalBytes: Long = 0
    internal var downloadedBytes: Long = 0
    internal lateinit var job: Job
    internal lateinit var onStart: () -> Unit
    internal lateinit var onSuccess: (res: String) -> Unit
    internal lateinit var onError: (error: String) -> Unit

    data class Builder(
        private val url: String,
    ) {
        private var tag: String? = null
        private var readTimeOut: Int = 0
        private var connectTimeOut: Int = 0

        fun tag(tag: String) = apply {
            this.tag = tag
        }

        fun readTimeout(timeout: Int) = apply {
            this.readTimeOut = timeout
        }

        fun connectTimeout(timeout: Int) = apply {
            this.connectTimeOut = timeout
        }

        fun build(): NetworkRequest {
            return NetworkRequest(
                url = url,
                tag = tag,
                networkId = getUniqueId(url, "", ""),
                readTimeOut = readTimeOut,
                connectTimeOut = connectTimeOut,
            )
        }
    }
}