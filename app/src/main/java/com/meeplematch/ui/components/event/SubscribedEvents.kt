package com.meeplematch.ui.components.event

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.meeplematch.data.model.viewmodel.EventViewModel
import com.meeplematch.ui.components.main.SingleChoiceSegmentedButton

@Composable
fun SubscribedEvents(viewModel: EventViewModel, navController: NavController) {
    val events by viewModel.events.collectAsState()
    val subscribedEvents by viewModel.subscribedEvents.collectAsState()

    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            SingleChoiceSegmentedButton(navController =  navController, index = 1)
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(events) { event ->
                if (subscribedEvents.find { ep -> ep.idEvent == event.idEvent } != null) {
                    EventCard(
                        event = event,
                        onClick = { /* TODO: navigate to event details */ }
                    )
                }
            }
        }
    }
}