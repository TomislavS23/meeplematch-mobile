package com.meeplematch.data.model

data class Event(
    val idEvent: Int,
    val name: String,
    val type: String,
    val game: String,
    val location: String,
    val eventDate: String,
    val capacity: Int?,
    val minParticipants: Int?,
    val description: String?
)


