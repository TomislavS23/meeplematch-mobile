package com.meeplematch.data.model

data class EventParticipant(
    val idEventParticipant: Int?,
    val idEvent: Int,
    val idUser: Int,
    val joined: String
)