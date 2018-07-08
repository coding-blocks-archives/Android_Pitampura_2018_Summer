package com.codingblocks.broadcastreceivers

import android.Manifest
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val receiver = ScreenToggleReceiver()
        val intentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_SCREEN_ON)
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF)

        registerReceiver(
                receiver,
                intentFilter
        )

        ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.PROCESS_OUTGOING_CALLS),
                111
        )

    }
}
