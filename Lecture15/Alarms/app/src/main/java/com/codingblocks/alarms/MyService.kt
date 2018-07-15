package com.codingblocks.alarms

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService: Service() {
    val TAG  = "SRC"

    var startCount = 0

    override fun onCreate() {
        Log.d(TAG, "onCreate")
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand ${++startCount}")
        val startTime = System.currentTimeMillis()

        while (System.currentTimeMillis() < startTime + 10000);

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

}