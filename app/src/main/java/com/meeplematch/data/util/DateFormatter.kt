package com.meeplematch.data.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

fun getTimestampFromString(s: String): String {
    return try {
        val inputFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME
        val dateTime = LocalDateTime.parse(s, inputFormatter)

        val outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss", Locale.UK)
        dateTime.format(outputFormatter)
    } catch (e: Exception) {
        e.toString()
    }
}

fun getStringFromTimestamp(date: LocalDateTime): String {
    return date.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME).toString()
}

