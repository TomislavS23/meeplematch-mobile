package com.meeplematch.ui.components.main

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
import androidx.navigation.NavController
import com.meeplematch.ui.theme.PrimaryAccentColor
import com.meeplematch.ui.theme.White
import com.meeplematch.ui.util.Route

@Composable
fun SingleChoiceSegmentedButton(modifier: Modifier = Modifier, navController: NavController, index: Int) {
    var selectedIndex by remember { mutableIntStateOf(index) }
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

                    if (index == 1) {
                        navController.navigate(Route.SUBSCRIBED)
                    } else {
                        navController.navigate(Route.HOME_SCREEN)
                    }
                },
                selected = index == selectedIndex,
                label = { Text(label) }
            )
        }
    }
}