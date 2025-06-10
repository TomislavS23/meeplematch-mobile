package com.meeplematch.data.util

const val BASE_URL = "https://meeplematch-aud3d4gmbdgkdrgm.westeurope-01.azurewebsites.net/api/meeplematch/"

// Events
const val GET_EVENTS = "events"
const val GET_EVENT_ID = "events/{id}"
const val POST_EVENT_PARTICIPANT = "event-participant"
const val DELETE_EVENT_PARTICIPANT = "event-participant"

// AUTH
const val LOGIN = "auth/login"

// USER
const val PUBLIC_USER = "user/public/{username}"

// Event-participants
const val GET_EVENT_PARTICIPANT_ID = "event-participant/get_by_user/{id}"