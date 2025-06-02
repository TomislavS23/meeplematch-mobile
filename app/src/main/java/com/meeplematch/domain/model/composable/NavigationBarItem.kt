package com.meeplematch.domain.model.composable

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationBarItem(
    val icon: ImageVector,
    val labelResource: Int,
    val isSelected: Boolean,
    val navigationRoute: String
)
