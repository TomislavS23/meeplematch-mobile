package com.meeplematch.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.meeplematch.data.datastore.ID_USER
import com.meeplematch.data.datastore.readFromDataStore
import com.meeplematch.data.datastore.userStore
import com.meeplematch.data.viewmodel.EventViewModel
import com.meeplematch.data.viewmodel.factory.EventViewModelFactory
import com.meeplematch.ui.components.main.BottomBar
import com.meeplematch.ui.navigation.graph.mainScreenDestinations
import com.meeplematch.ui.util.Route
import com.meeplematch.ui.util.config.UIConfig

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val context = LocalContext.current
    val userIdFlow = readFromDataStore(context.userStore, ID_USER)
    val userIdState by userIdFlow.collectAsState(initial = null)

    if (userIdState.isNullOrBlank()) return

    val viewModel: EventViewModel = viewModel(
        factory = EventViewModelFactory(userIdState!!.toInt())
    )

    Scaffold(
        bottomBar = {
            BottomBar(
                modifier = Modifier,
                navController = navController,
                navBarItems = UIConfig.navigationBarItems
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            NavHost(navController = navController, startDestination = Route.HOME_SCREEN) {
                mainScreenDestinations(navController, viewModel)
            }
        }
    }
}