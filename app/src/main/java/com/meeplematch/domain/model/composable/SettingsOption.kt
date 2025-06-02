package com.meeplematch.domain.model.composable

import androidx.compose.ui.graphics.vector.ImageVector

data class SettingsOption(
    val optionIcon: ImageVector,
    val actionIcon: ImageVector,
    val optionTitle: String,
    val navigationRoute: String
)
