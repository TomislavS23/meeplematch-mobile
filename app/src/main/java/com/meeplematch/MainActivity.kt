package com.meeplematch

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.meeplematch.data.viewmodel.EventViewModel
import com.meeplematch.ui.navigation.ApplicationStart
import com.meeplematch.ui.theme.MeepleMatchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createNotificationChannel(this)
        enableEdgeToEdge()
        setContent {
            MeepleMatchTheme {
                ApplicationStart()
            }
        }
    }
}

private fun createNotificationChannel(context: Context) {
    val channel = NotificationChannel(
        "event_channel",
        "Event Notifications",
        NotificationManager.IMPORTANCE_DEFAULT
    ).apply {
        description = "Notifications about events"
    }

    val notificationManager: NotificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    notificationManager.createNotificationChannel(channel)
}
