package com.meeplematch.ui.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
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


fun NavGraphBuilder.mainScreenDestinations(navController: NavController) {
    composable(Route.HOME_SCREEN) { Home() }
    composable(Route.SETTINGS_SCREEN) { SettingsScreen(navController) }
    composable(Route.SUBSCRIBED) { /* TODO */ }
}

fun NavGraphBuilder.settingsDestinations(navController: NavController) {
    composable(Route.SETTINGS_MAIN) { SettingsMain(navController) }
    composable(Route.ACCOUNT) { AccountSecurity(navController) }
    composable(Route.APPEARANCE) { /* TODO */ }
    composable(Route.OTHER) { /* TODO */ }
    composable(Route.ABOUT) { About(navController) }
}