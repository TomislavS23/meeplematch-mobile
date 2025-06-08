package com.meeplematch.ui.components.event

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.meeplematch.data.model.Event
import com.meeplematch.data.viewmodel.EventViewModel
import com.meeplematch.data.worker.EventReminderWorker
import com.meeplematch.ui.theme.PrimaryAccentColor
import java.util.concurrent.TimeUnit

@SuppressLint("MissingPermission")
@Composable
fun EventDetails(
    event: Event,
    eventViewModel: EventViewModel
) {
    val subscribed = eventViewModel.isSubscribed(event.idEvent)
    var isSubscribed by rememberSaveable { mutableStateOf(subscribed) }
    val context = LocalContext.current
    val pendingWorkRequest = remember { mutableStateOf<OneTimeWorkRequest?>(null) }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            if (isGranted) {
                pendingWorkRequest.value?.let { work ->
                    WorkManager.getInstance(context).enqueue(work)
                    pendingWorkRequest.value = null
                }
            } else {
                Toast.makeText(context, "Notification permission denied", Toast.LENGTH_SHORT).show()
            }
        }
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            color = PrimaryAccentColor,
            text = event.name,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(Modifier.height(8.dp))

        Text("Type: ${event.type}")
        Text("Game: ${event.game}")
        Text("Location: ${event.location}")
        Text("Date: ${event.eventDate}")

        event.capacity?.let {
            Text("Capacity: $it")
        }
        event.minParticipants?.let {
            Text("Minimum Participants: $it")
        }
        event.description?.let {
            Spacer(Modifier.height(8.dp))
            Text("Description: $it")
        }

        Spacer(Modifier.height(24.dp))

        Button(
            onClick = {
                if (isSubscribed) {
                    eventViewModel.unsubscribe(event.idEvent)
                    isSubscribed = false
                } else {
                    eventViewModel.subscribe(event.idEvent)
                    isSubscribed = true

                    val workRequest = OneTimeWorkRequestBuilder<EventReminderWorker>()
                        .setInitialDelay(10, TimeUnit.SECONDS)
                        .setInputData(
                            Data.Builder()
                                .putString("name", event.name)
                                .putString("date", event.eventDate)
                                .build()
                        )
                        .build()

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                        if (ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS)
                            == PackageManager.PERMISSION_GRANTED
                        ) {
                            WorkManager.getInstance(context).enqueue(workRequest)
                        } else {
                            pendingWorkRequest.value = workRequest
                            permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                        }
                    } else {
                        WorkManager.getInstance(context).enqueue(workRequest)
                    }
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(if (isSubscribed) "Unsubscribe" else "Subscribe")
        }
    }
}
