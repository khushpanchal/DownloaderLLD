package com.khush.downloader

import android.app.Application
import com.khush.library.Downloader

class MyApplication: Application() {

    lateinit var downloader: Downloader
    override fun onCreate() {
        super.onCreate()
        downloader = Downloader.create()
    }
}