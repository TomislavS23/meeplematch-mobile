package com.meeplematch.ui.components.settings.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.meeplematch.data.model.composable.SettingsSection

@Composable
fun SettingsSection(
    modifier: Modifier = Modifier,
    settingsSections: List<SettingsSection>,
    navController: NavController
) {
    LazyColumn {
        items(settingsSections) { section ->
            Column {

                if (section.sectionTitle != "") {
                    Text(
                        modifier = Modifier.padding(start = 20.dp, top = 12.dp),
                        text = section.sectionTitle,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                    )
                }

                SettingsOptions(
                    modifier = modifier,
                    settingsOptions = section.sectionOptions,
                    navController = navController
                )
            }
        }
    }
}