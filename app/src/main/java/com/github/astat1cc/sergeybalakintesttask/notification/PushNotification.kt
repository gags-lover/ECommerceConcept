package com.github.astat1cc.sergeybalakintesttask.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.github.astat1cc.sergeybalakintesttask.presentation.MainActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class PushNotification : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
    }
}

const val FIREBASE_NOTIFICATION_ACTION_KEY = "FIREBASE_NOTIFICATION_ACTION_KEY"
const val FIREBASE_ACTION_OPEN_CART = "OPEN_CART"