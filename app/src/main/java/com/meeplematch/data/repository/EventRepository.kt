package com.meeplematch.data.repository

import com.meeplematch.data.model.Event
import com.meeplematch.data.model.EventParticipant
import retrofit2.http.GET
import retrofit2.http.Path

interface EventRepository {
    @GET("events")
    suspend fun getEvents(): List<Event>

    @GET("event-participant/get_by_user/{id}")
    suspend fun getSubscribedEvents(@Path("id") id: Int): List<EventParticipant>
}