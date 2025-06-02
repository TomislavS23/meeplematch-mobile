package com.meeplematch.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.meeplematch.ui.navigation.graph.appStartDestinations
import com.meeplematch.ui.util.Route

@Composable
fun ApplicationStart() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Route.SPLASH_SCREEN) {
        appStartDestinations(navController)
    }
}