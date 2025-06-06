package com.meeplematch.ui.components.settings.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.meeplematch.data.model.composable.SettingsButtonType
import com.meeplematch.data.model.composable.SettingsOption

@Composable
fun SettingsOptions(
    modifier: Modifier = Modifier,
    settingsOptions: List<SettingsOption>,
    navController: NavController
) {
    Card(
        modifier = modifier
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        settingsOptions.forEach { option ->
            when (option.buttonType) {
                SettingsButtonType.NAVIGATION -> {
                    SettingsButtonNavigation(
                        modifier = Modifier
                            .clickable(onClick = { navController.navigate(option.navigationRoute) })
                            .fillMaxWidth()
                            .padding(16.dp),
                        option = option,
                    )
                }

                SettingsButtonType.SWITCH -> {
                    SettingsButtonSwitch(
                        modifier = Modifier
                            .clickable(onClick = {  })
                            .fillMaxWidth()
                            .padding(16.dp),
                        option = option
                    )
                }
                SettingsButtonType.DIALOG -> TODO()
            }
        }
    }
}