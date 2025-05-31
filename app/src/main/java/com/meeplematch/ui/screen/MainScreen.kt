package com.meeplematch.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.meeplematch.ui.components.BottomBar
import com.meeplematch.ui.navigation.route.Route
import com.meeplematch.ui.navigation.graph.mainScreenDestinations

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomBar(modifier = Modifier, navController = navController) }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            NavHost(navController = navController, startDestination = Route.HOME_SCREEN) {
                mainScreenDestinations(navController)
            }
        }
    }
}