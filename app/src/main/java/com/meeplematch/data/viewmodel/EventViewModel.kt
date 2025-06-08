package com.meeplematch.data.viewmodel

import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meeplematch.data.client.RetrofitClient
import com.meeplematch.data.model.Event
import com.meeplematch.data.model.EventParticipant
import com.meeplematch.data.util.getStringFromTimestamp
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class EventViewModel(private val id: Int) : ViewModel() {
    private val _events = MutableStateFlow<List<Event>>(emptyList())
    val events: StateFlow<List<Event>> = _events

    private val _subscribedEvents = MutableStateFlow<List<EventParticipant>>(emptyList())
    val subscribedEvents: StateFlow<List<EventParticipant>> = _subscribedEvents

    init {
        initializeData()
    }

    private fun initializeData() {
        viewModelScope.launch {
            try {
                _events.value = RetrofitClient.eventApi.getEvents()
                _subscribedEvents.value = RetrofitClient.eventApi.getSubscribedEvents(id = id)
            } catch (e: Exception) {
                Log.e("ERR", e.message.toString())
            }
        }
    }

    fun refreshSubscribedEvents() {
        viewModelScope.launch {
            try {
                _subscribedEvents.value = RetrofitClient.eventApi.getSubscribedEvents(id = id)
            } catch (e: Exception) {
                Log.e("ERR", e.message.toString())
            }
        }
    }

    fun getEventById(id: Int): Event? {
        return events.value.find { e -> e.idEvent == id }
    }

    fun isSubscribed(eventId: Int): Boolean {
        return subscribedEvents.value.find { e -> e.idEvent == eventId } != null
    }

    fun subscribe(idEvent: Int) {
        viewModelScope.launch {
            RetrofitClient.eventApi.subscribe(
                EventParticipant(
                    idEventParticipant = 0,
                    idEvent = idEvent,
                    idUser = id,
                    joined = getStringFromTimestamp(LocalDateTime.now())
                )
            )
        }
    }

    fun unsubscribe(idEvent: Int) {
        viewModelScope.launch {
            RetrofitClient.eventApi.unsubscribe(eventId = idEvent, userId = id)
        }
    }
}