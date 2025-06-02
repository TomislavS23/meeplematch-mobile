package com.meeplematch.ui.util.config

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.automirrored.filled.Help
import androidx.compose.material.icons.automirrored.filled.OpenInNew
import androidx.compose.material.icons.automirrored.outlined.Help
import androidx.compose.material.icons.automirrored.outlined.Logout
import androidx.compose.material.icons.automirrored.outlined.OpenInNew
import androidx.compose.material.icons.filled.CopyAll
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material.icons.outlined.Brush
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Difference
import androidx.compose.material.icons.outlined.Fingerprint
import androidx.compose.material.icons.outlined.GridView
import androidx.compose.material.icons.outlined.Help
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Password
import androidx.compose.material.icons.outlined.Policy
import androidx.compose.material3.Icon
import com.meeplematch.domain.model.composable.SettingsOption
import com.meeplematch.domain.model.composable.SettingsSection
import com.meeplematch.ui.util.Route

object SettingsUIConfig {
    val settingsOptions = listOf(
        SettingsOption(
            optionIcon = Icons.Outlined.Lock,
            actionIcon = Icons.AutoMirrored.Default.ArrowForwardIos,
            optionTitle = "Account Security",
            navigationRoute = Route.ACCOUNT
        ),
        SettingsOption(
            optionIcon = Icons.Outlined.Brush,
            actionIcon = Icons.AutoMirrored.Default.ArrowForwardIos,
            optionTitle = "Appearance",
            navigationRoute = Route.APPEARANCE
        ),
        SettingsOption(
            optionIcon = Icons.Outlined.GridView,
            actionIcon = Icons.AutoMirrored.Default.ArrowForwardIos,
            optionTitle = "Other",
            navigationRoute = Route.OTHER
        ),
        SettingsOption(
            optionIcon = Icons.Outlined.Info,
            actionIcon = Icons.AutoMirrored.Default.ArrowForwardIos,
            optionTitle = "About",
            navigationRoute = Route.ABOUT
        )
    )

    val accountSecuritySections = listOf(
        SettingsSection(
            sectionTitle = "GENERAL",
            sectionOptions = listOf(
                SettingsOption(
                    optionIcon = Icons.Outlined.Fingerprint,
                    actionIcon = Icons.AutoMirrored.Default.ArrowForwardIos,
                    optionTitle = "Unlock with Biometrics",
                    navigationRoute = ""
                )
            )
        ),
        SettingsSection(
            sectionTitle = "OTHER",
            sectionOptions = listOf(
                SettingsOption(
                    optionIcon = Icons.Outlined.Password,
                    actionIcon = Icons.AutoMirrored.Default.ArrowForwardIos,
                    optionTitle = "Change Password",
                    navigationRoute = ""
                ),
                SettingsOption(
                    optionIcon = Icons.Outlined.Lock,
                    actionIcon = Icons.AutoMirrored.Default.ArrowForwardIos,
                    optionTitle = "Lock Now",
                    navigationRoute = Route.LOGIN_SCREEN
                ),
            )
        ),
        SettingsSection(
            sectionTitle = "DANGER ZONE",
            sectionOptions = listOf(
                SettingsOption(
                    optionIcon = Icons.AutoMirrored.Outlined.Logout,
                    actionIcon = Icons.AutoMirrored.Default.ArrowForwardIos,
                    optionTitle = "Logout",
                    navigationRoute = Route.LOGIN_SCREEN
                ),
                SettingsOption(
                    optionIcon = Icons.Outlined.Delete,
                    actionIcon = Icons.AutoMirrored.Default.ArrowForwardIos,
                    optionTitle = "Delete account",
                    navigationRoute = ""
                ),
            )
        )
    )

    val appearanceSections = listOf(
        SettingsSection(
            sectionTitle = "GENERAL",
            sectionOptions = listOf()
        )
    )

    val otherSections = listOf(
        SettingsSection(
            sectionTitle = "GENERAL",
            sectionOptions = listOf()
        )
    )

    val aboutSections = listOf(
        SettingsSection(
            sectionTitle = "",
            sectionOptions = listOf(
                SettingsOption(
                    optionIcon = Icons.Outlined.Info,
                    actionIcon = Icons.AutoMirrored.Outlined.OpenInNew,
                    optionTitle = "Meeplematch support",
                    navigationRoute = Route.SETTINGS_MAIN
                ),
                SettingsOption(
                    optionIcon = Icons.Outlined.Policy,
                    actionIcon = Icons.AutoMirrored.Outlined.OpenInNew,
                    optionTitle = "Privacy Policy",
                    navigationRoute = Route.SETTINGS_MAIN
                ),
                SettingsOption(
                    optionIcon = Icons.AutoMirrored.Outlined.Help,
                    actionIcon = Icons.AutoMirrored.Outlined.OpenInNew,
                    optionTitle = "About Us",
                    navigationRoute = Route.SETTINGS_MAIN
                ),
                SettingsOption(
                    optionIcon = Icons.Outlined.Difference,
                    actionIcon = Icons.Default.CopyAll,
                    optionTitle = "Version: 1.0",
                    navigationRoute = Route.SETTINGS_MAIN
                ),
            )
        )
    )
}