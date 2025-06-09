package com.meeplematch.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.meeplematch.ui.components.TopBar
import com.meeplematch.ui.navigation.graph.settingsDestinations
import com.meeplematch.ui.util.Route

@Composable
fun SettingsScreen(navController: NavController) {
    val settingsNavController = rememberNavController()

    Scaffold(
        topBar = {
            TopBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surface),
                navController = navController
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            NavHost(
                navController = settingsNavController,
                startDestination = Route.SETTINGS_MAIN
            ) {
                settingsDestinations(settingsNavController)
            }
        }
    }
}