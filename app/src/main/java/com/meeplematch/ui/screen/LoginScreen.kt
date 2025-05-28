package com.meeplematch.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.meeplematch.ui.components.LoginForm
import com.meeplematch.ui.theme.PrimaryBackground

@Composable
fun LoginScreen(navController: NavController) {
    Scaffold (
        modifier = Modifier
            .background(PrimaryBackground)
            .fillMaxSize()
    ){ innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            LoginForm(navController = navController)
        }
    }
}