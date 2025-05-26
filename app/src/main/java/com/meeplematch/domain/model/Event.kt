package com.meeplematch.domain.model

import java.time.LocalDateTime

data class Event(
    val id: Int,
    val uuid: String?,
    val name: String,
    val type: String,
    val game: String,
    val location: String,
    val eventDate: LocalDateTime,
    val capacity: Int?,
    val minParticipants: Int?,
    val description: String?,
)