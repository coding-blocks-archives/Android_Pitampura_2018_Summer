package com.codingblocks.broadcastreceivers

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log

class OutgoingCallReceiver: BroadcastReceiver() {
    @SuppressLint("MissingPermission")
    override fun onReceive(context: Context?, intent: Intent?) {

        intent?.let {
            it.getStringExtra(Intent.EXTRA_PHONE_NUMBER)?.let { num ->


                if (num.startsWith("011")) {
                    // 01199999 -> +911199999
                    val newnum = "tel:+9111" + num.substring(3)
                    val intent = Intent(Intent.ACTION_CALL)
                    intent.data = Uri.parse(newnum)
                    context?.startActivity(intent)
                }

                if (!num.contains("+91")) {
                    resultData = null
                }
            }

        }

    }

}