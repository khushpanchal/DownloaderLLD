package com.khush.downloader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val downloader = (application as MyApplication).networker
        val request = downloader.newBuilder("someUrl")
            .readTimeout(10000)
            .connectTimeout(10000)
            .tag("someTag")
            .build()

        downloader.enqueue(request,
            onStart = {
                //binding.textViewStatus.text = "onStart"
            },
            onSuccess = {
                //binding.textViewStatus.text = it
            },
            onError = {
                //binding.textViewStatus.text = it
            })
    }
}