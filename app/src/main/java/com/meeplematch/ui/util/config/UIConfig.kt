package com.meeplematch.ui.util.config

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.automirrored.outlined.Logout
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Brush
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Fingerprint
import androidx.compose.material.icons.outlined.GridView
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Password
import com.meeplematch.R
import com.meeplematch.domain.model.composable.NavigationBarItem
import com.meeplematch.domain.model.composable.SettingsOption
import com.meeplematch.domain.model.composable.SettingsSection
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