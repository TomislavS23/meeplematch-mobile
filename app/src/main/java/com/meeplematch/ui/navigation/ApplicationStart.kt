package com.meeplematch.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.meeplematch.data.factory.EventViewModelFactory
import com.meeplematch.data.model.viewmodel.EventViewModel
import com.meeplematch.ui.navigation.graph.appStartDestinations
import com.meeplematch.ui.util.Route
import kotlinx.serialization.json.internal.encodeByWriter

@Composable
fun ApplicationStart() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Route.SPLASH_SCREEN) {
        appStartDestinations(navController)
    }
}