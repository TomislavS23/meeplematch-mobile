package com.meeplematch.data.model.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meeplematch.data.client.RetrofitClient
import com.meeplematch.data.model.Event
import com.meeplematch.data.model.EventParticipant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

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
}