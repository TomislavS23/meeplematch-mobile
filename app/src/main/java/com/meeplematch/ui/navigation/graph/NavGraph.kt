package com.meeplematch.ui.navigation.graph

import androidx.compose.material3.Text
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.meeplematch.data.viewmodel.EventViewModel
import com.meeplematch.ui.components.event.EventDetails
import com.meeplematch.ui.components.main.SubscribedEvents
import com.meeplematch.ui.components.main.Home
import com.meeplematch.ui.components.settings.general.About
import com.meeplematch.ui.components.settings.general.AccountSecurity
import com.meeplematch.ui.components.settings.general.SettingsMain
import com.meeplematch.ui.screen.LoginScreen
import com.meeplematch.ui.screen.MainScreen
import com.meeplematch.ui.screen.SettingsScreen
import com.meeplematch.ui.screen.SplashScreen
import com.meeplematch.ui.util.Route

fun NavGraphBuilder.appStartDestinations(navController: NavController) {
    composable(Route.LOGIN_SCREEN) { LoginScreen(navController = navController) }
    composable(Route.SPLASH_SCREEN) { SplashScreen(onTimeout = { navController.navigate(Route.LOGIN_SCREEN) }) }
    composable(Route.MAIN_SCREEN) { MainScreen() }
}


fun NavGraphBuilder.mainScreenDestinations(
    navController: NavController,
    eventViewModel: EventViewModel
) {
    composable(Route.HOME_SCREEN) { Home(eventViewModel, navController) }
    composable(Route.SETTINGS_SCREEN) { SettingsScreen(navController) }
    composable(Route.SUBSCRIBED) { SubscribedEvents(eventViewModel, navController) }
    composable(
        route = Route.EVENT_DETAILS_SCREEN,
        arguments = listOf(navArgument("id") { type = NavType.IntType })
    ) { entry ->
        val eventId = entry.arguments?.getInt("id")
        val event = eventId?.let { eventViewModel.getEventById(it) }

        if (event != null) {
            EventDetails(event = event, eventViewModel = eventViewModel)
        } else {
            Text("Event not found")
        }
    }
}

fun NavGraphBuilder.settingsDestinations(navController: NavController) {
    composable(Route.SETTINGS_MAIN) { SettingsMain(navController) }
    composable(Route.ACCOUNT) { AccountSecurity(navController) }
    composable(Route.APPEARANCE) { /* TODO */ }
    composable(Route.OTHER) { /* TODO */ }
    composable(Route.ABOUT) { About(navController) }
}