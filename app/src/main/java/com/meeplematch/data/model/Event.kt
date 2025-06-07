package com.meeplematch.data.model

import com.google.gson.annotations.SerializedName

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


