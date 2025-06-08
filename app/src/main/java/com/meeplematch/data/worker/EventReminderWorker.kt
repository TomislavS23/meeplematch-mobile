package com.meeplematch.data.worker

import android.annotation.SuppressLint
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.meeplematch.R

class EventReminderWorker(
    appContext: Context,
    workerParams: WorkerParameters
) : Worker(appContext, workerParams) {

    @SuppressLint("MissingPermission")
    override fun doWork(): Result {
        val name = inputData.getString("name") ?: return Result.failure()
        val date = inputData.getString("date") ?: "soon"

        val context = applicationContext

        val notificationBuilder = NotificationCompat.Builder(context, "event_channel")
            .setSmallIcon(R.drawable.letter_m)
            .setContentTitle("Event Reminder")
            .setContentText("You got an event coming: $name at $date")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(System.currentTimeMillis().toInt(), notificationBuilder.build())

        return Result.success()
    }
}
