package com.meeplematch.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.meeplematch.ui.components.Home
import com.meeplematch.ui.navigation.BottomBar

@Composable
fun MainScreen(modifier: Modifier = Modifier, navController: NavController) {
    Scaffold(
        bottomBar = { BottomBar(modifier = Modifier) }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Home(navController = navController)
        }
    }
}