package com.meeplematch.ui.util.config

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material.icons.filled.Settings
import com.meeplematch.R
import com.meeplematch.data.model.composable.NavigationBarItem
import com.meeplematch.ui.util.Route

object UIConfig {
    val navigationBarItems = listOf(
        NavigationBarItem(
            icon = Icons.Default.Home,
            labelResource = R.string.bottom_bar_home,
            isSelected = false,
            navigationRoute = Route.HOME_SCREEN,
        ),
        NavigationBarItem(
            icon = Icons.Default.QrCode,
            labelResource = R.string.scan_qr_code,
            isSelected = false,
            navigationRoute = Route.HOME_SCREEN,
        ),
        NavigationBarItem(
            icon = Icons.Default.Settings,
            labelResource = R.string.settings,
            isSelected = false,
            navigationRoute = Route.SETTINGS_SCREEN,
        )
    )
}