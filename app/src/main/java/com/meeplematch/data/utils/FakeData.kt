package com.meeplematch.data.utils

import com.meeplematch.data.model.Event
import java.time.LocalDateTime

val events = listOf(
    Event(
        id = 1,
        uuid = "UUID.randomUUID()",
        name = "Street Fighter 6 Tournament",
        type = "Competitive",
        game = "Street Fighter 6",
        location = "Game Haven Arcade",
        eventDate = LocalDateTime.of(2023, 12, 15, 18, 0),
        capacity = 32,
        minParticipants = 8,
        description = "Monthly SF6 tournament with cash prizes. Double elimination bracket."
    ),
    Event(
        id = 2,
        uuid = "UUID.randomUUID()",
        name = "Mario Kart 8 Casual Night",
        type = "Friendly",
        game = "Mario Kart 8 Deluxe",
        location = "Player's Lounge",
        eventDate = LocalDateTime.of(2023, 12, 10, 19, 30),
        capacity = 16,
        minParticipants = 4,
        description = "Bring your friends for some casual Mario Kart races!"
    ),
    Event(
        id = 3,
        uuid = "UUID.randomUUID()",
        name = "Valorant Showmatch",
        type = "Exhibition",
        game = "Valorant",
        location = "CyberZone Internet Cafe",
        eventDate = LocalDateTime.of(2023, 12, 20, 17, 0),
        capacity = 10,
        minParticipants = 10,
        description = "Pro players vs community all-stars match"
    ),
    Event(
        id = 4,
        uuid = "UUID.randomUUID()",
        name = "Smash Ultimate Weekly",
        type = "Competitive",
        game = "Super Smash Bros. Ultimate",
        location = "The Gaming Spot",
        eventDate = LocalDateTime.of(2023, 12, 8, 20, 0),
        capacity = 24,
        minParticipants = 12,
        description = "Weekly Smash Ultimate tournament with ranking points"
    ),
    Event(
        id = 1,
        uuid = "UUID.randomUUID()",
        name = "Street Fighter 6 Tournament",
        type = "Competitive",
        game = "Street Fighter 6",
        location = "Game Haven Arcade",
        eventDate = LocalDateTime.of(2023, 12, 15, 18, 0),
        capacity = 32,
        minParticipants = 8,
        description = "Monthly SF6 tournament with cash prizes. Double elimination bracket."
    ),
    Event(
        id = 2,
        uuid = "UUID.randomUUID()",
        name = "Mario Kart 8 Casual Night",
        type = "Friendly",
        game = "Mario Kart 8 Deluxe",
        location = "Player's Lounge",
        eventDate = LocalDateTime.of(2023, 12, 10, 19, 30),
        capacity = 16,
        minParticipants = 4,
        description = "Bring your friends for some casual Mario Kart races!"
    ),
    Event(
        id = 3,
        uuid = "UUID.randomUUID()",
        name = "Valorant Showmatch",
        type = "Exhibition",
        game = "Valorant",
        location = "CyberZone Internet Cafe",
        eventDate = LocalDateTime.of(2023, 12, 20, 17, 0),
        capacity = 10,
        minParticipants = 10,
        description = "Pro players vs community all-stars match"
    ),
    Event(
        id = 4,
        uuid = "UUID.randomUUID()",
        name = "Smash Ultimate Weekly",
        type = "Competitive",
        game = "Super Smash Bros. Ultimate",
        location = "The Gaming Spot",
        eventDate = LocalDateTime.of(2023, 12, 8, 20, 0),
        capacity = 24,
        minParticipants = 12,
        description = "Weekly Smash Ultimate tournament with ranking points"
    )
)