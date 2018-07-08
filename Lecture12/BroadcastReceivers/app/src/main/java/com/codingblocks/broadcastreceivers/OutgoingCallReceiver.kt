package com.codingblocks.broadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class OutgoingCallReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        Log.d("CALL", "Outgoing call made to " +
                "${intent?.getStringExtra(Intent.EXTRA_PHONE_NUMBER)}")

        resultData = null
    }

}