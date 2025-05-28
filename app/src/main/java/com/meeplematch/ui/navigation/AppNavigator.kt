package com.meeplematch.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.meeplematch.domain.utils.LOGIN_SCREEN
import com.meeplematch.domain.utils.MAIN_SCREEN
import com.meeplematch.domain.utils.SPLASH_SCREEN
import com.meeplematch.ui.screen.LoginScreen
import com.meeplematch.ui.screen.MainScreen
import com.meeplematch.ui.screen.SplashScreen

@Composable
fun AppNavigator() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = SPLASH_SCREEN) {
        composable(LOGIN_SCREEN) { LoginScreen(navController = navController) }
        composable(SPLASH_SCREEN) {
            SplashScreen(onTimeout = { navController.navigate(LOGIN_SCREEN)})
        }
        composable(MAIN_SCREEN) { MainScreen(navController = navController) }
    }
}