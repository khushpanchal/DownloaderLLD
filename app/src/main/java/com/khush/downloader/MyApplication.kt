package com.khush.downloader

import android.app.Application
import com.khush.library.Networker

class MyApplication: Application() {

    lateinit var networker: Networker
    override fun onCreate() {
        super.onCreate()
        networker = Networker.create()
    }
}