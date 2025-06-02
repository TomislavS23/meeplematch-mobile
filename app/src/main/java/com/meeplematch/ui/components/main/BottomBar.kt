package com.meeplematch.ui.components.main

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.meeplematch.domain.model.composable.NavigationBarItem
import com.meeplematch.ui.theme.PrimaryAccentColor

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navController: NavController,
    navBarItems: List<NavigationBarItem>
) {
    NavigationBar(
        modifier = modifier,
        contentColor = PrimaryAccentColor,
    ) {
        navBarItems.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = null) },
                label = { Text(text = stringResource(item.labelResource)) },
                selected = item.isSelected,
                onClick = { navController.navigate(item.navigationRoute) }
            )
        }
    }
}