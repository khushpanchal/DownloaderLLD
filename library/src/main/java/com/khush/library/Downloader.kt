package com.khush.library

class Downloader private constructor(private val config: DownloaderConfig){

    companion object {
        fun create(config: DownloaderConfig = DownloaderConfig()): Downloader {
            return Downloader(config)
        }
    }
}