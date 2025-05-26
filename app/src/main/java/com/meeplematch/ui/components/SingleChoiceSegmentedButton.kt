package com.meeplematch.ui.components

import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.meeplematch.ui.theme.PrimaryAccentColor
import com.meeplematch.ui.theme.White

@Composable
fun SingleChoiceSegmentedButton(modifier: Modifier = Modifier) {
    var selectedIndex by remember { mutableIntStateOf(0) }
    val options = listOf("Events", "Subscribed")

    SingleChoiceSegmentedButtonRow(
        modifier = modifier
    ){
        options.forEachIndexed { index, label ->
            SegmentedButton(
                colors = SegmentedButtonDefaults.colors(
                    activeContainerColor = PrimaryAccentColor,
                    activeContentColor = White
                ),
                icon = {},
                shape = SegmentedButtonDefaults.itemShape(
                    index = index,
                    count = options.size
                ),
                onClick = {
                    selectedIndex = index

                    // TODO: depending on selected index show either event or subscribed screen
                },
                selected = index == selectedIndex,
                label = { Text(label) }
            )
        }
    }
}