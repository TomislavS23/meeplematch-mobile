package com.meeplematch.ui.components.settings.general

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.meeplematch.ui.components.settings.components.SettingsSection
import com.meeplematch.ui.util.config.SettingsUIConfig

@Composable
fun About(navController: NavController) {
    SettingsSection(
        modifier = Modifier.fillMaxWidth(),
        SettingsUIConfig.aboutSections,
        navController
    )
}