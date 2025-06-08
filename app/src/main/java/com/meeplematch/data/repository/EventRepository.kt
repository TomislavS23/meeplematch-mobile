package com.meeplematch.data.repository

import com.meeplematch.data.model.Event
import com.meeplematch.data.model.EventParticipant
import com.meeplematch.data.util.DELETE_EVENT_PARTICIPANT
import com.meeplematch.data.util.GET_EVENTS
import com.meeplematch.data.util.GET_EVENT_ID
import com.meeplematch.data.util.GET_EVENT_PARTICIPANT_ID
import com.meeplematch.data.util.POST_EVENT_PARTICIPANT
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface EventRepository {
    @GET(GET_EVENTS)
    suspend fun getEvents(): List<Event>

    @GET(GET_EVENT_PARTICIPANT_ID)
    suspend fun getSubscribedEvents(@Path("id") id: Int): List<EventParticipant>

    @GET(GET_EVENT_ID)
    suspend fun getEventById(): Event

    @POST(POST_EVENT_PARTICIPANT)
    suspend fun subscribe(@Body eventParticipant: EventParticipant)

    @DELETE(DELETE_EVENT_PARTICIPANT)
    suspend fun unsubscribe(@Query("eventId") eventId: Int, @Query("userId") userId: Int)
}