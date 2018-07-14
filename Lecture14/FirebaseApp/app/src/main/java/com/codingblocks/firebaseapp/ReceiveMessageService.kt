package com.codingblocks.firebaseapp

import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class ReceiveMessageService: FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage?) {
        Log.d("MSG", "onMessageReceived")

        message?.let {
            val notif = Notification.Builder(this)
                    .setSmallIcon(android.R.drawable.ic_input_add)
                    .setContentTitle(it.notification?.title)
                    .setContentText(it.notification?.body)
                    .build()
            val nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            nm.notify(12, notif)

        }

        super.onMessageReceived(message)
    }
}