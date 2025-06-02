package com.meeplematch.ui.components.settings.general

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.meeplematch.ui.components.settings.components.SettingsOptions
import com.meeplematch.ui.util.config.SettingsUIConfig

@Composable
fun SettingsMain(navController: NavController) {
    SettingsOptions(
        modifier = Modifier.fillMaxWidth(),
        SettingsUIConfig.settingsOptions,
        navController
    )
}