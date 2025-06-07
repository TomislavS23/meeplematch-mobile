package com.meeplematch.data.repository

import com.meeplematch.data.model.Event
import com.meeplematch.data.model.EventParticipant
import com.meeplematch.data.util.GET_EVENTS
import com.meeplematch.data.util.GET_EVENT_PARTICIPANT_ID
import retrofit2.http.GET
import retrofit2.http.Path

interface EventRepository {
    @GET(GET_EVENTS)
    suspend fun getEvents(): List<Event>

    @GET(GET_EVENT_PARTICIPANT_ID)
    suspend fun getSubscribedEvents(@Path("id") id: Int): List<EventParticipant>
}