package com.meeplematch.ui.components.settings.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meeplematch.data.model.composable.SettingsOption

@Composable
fun SettingsButtonNavigation(modifier: Modifier, option: SettingsOption) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    imageVector = option.optionIcon,
                    contentDescription = null
                )
                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = option.optionTitle,
                    fontSize = 16.sp,
                )
            }
        }

        Icon(
            modifier = Modifier.size(16.dp),
            imageVector = option.actionIcon,
            contentDescription = null
        )
    }

    HorizontalDivider()
}