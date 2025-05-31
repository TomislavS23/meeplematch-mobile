package com.meeplematch.ui.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.meeplematch.ui.components.Home
import com.meeplematch.ui.navigation.route.Route
import com.meeplematch.ui.screen.LoginScreen
import com.meeplematch.ui.screen.MainScreen
import com.meeplematch.ui.screen.SplashScreen

fun NavGraphBuilder.appStartDestinations(navController: NavController){
    composable(Route.LOGIN_SCREEN) { LoginScreen(navController = navController) }
    composable(Route.SPLASH_SCREEN) { SplashScreen(onTimeout = { navController.navigate(Route.LOGIN_SCREEN)}) }
    composable(Route.MAIN_SCREEN) { MainScreen() }
}


fun NavGraphBuilder.mainScreenDestinations(navController: NavController) {
    composable(Route.HOME_SCREEN) { Home() }
    composable(Route.PROFILE_SCREEN) { /* TODO: make profile composable */ }
    composable(Route.SUBSCRIBED) { /* TODO: make profile composable */ }
}