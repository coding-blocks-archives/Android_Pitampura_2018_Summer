package com.codingblocks.firebaseapp

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class ReceiveMessageService: FirebaseMessagingService() {

    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                    "notifs",
                    "App Notifications",
                    NotificationManager.IMPORTANCE_HIGH
            )
            channel.description = "All App Notifications"
            val nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            nm.createNotificationChannel(channel)
        }
    }

    override fun onMessageReceived(message: RemoteMessage?) {
        Log.d("MSG", "onMessageReceived")

        message?.let {
            val notif = NotificationCompat.Builder(this, "notifs")
                    .setSmallIcon(android.R.drawable.ic_input_add)
                    .setContentTitle(it.notification?.title)
                    .setContentText(it.notification?.body)
                    .build()
            val nm = NotificationManagerCompat.from(this)
            nm.notify(12, notif)

        }

        super.onMessageReceived(message)
    }
}