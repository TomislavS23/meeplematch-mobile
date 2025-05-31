package com.meeplematch.ui.navigation.route

object Route {
    // Application Start
    const val SPLASH_SCREEN = "splash"
    const val LOGIN_SCREEN = "login"

    // Bottom bar
    const val HOME_SCREEN = "home"
    const val PROFILE_SCREEN = "profile"

    // Main Screen
    const val MAIN_SCREEN = "main"
    const val SUBSCRIBED = "subscribed"

    // Dynamic
    const val EVENT_DETAILS_SCREEN = "event/{id}"
    fun eventDetails(id: String) = "event/$id"
}