package com.meeplematch.ui.components.main

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.meeplematch.data.model.composable.NavigationBarItem
import com.meeplematch.ui.theme.INTER

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navController: NavController,
    navBarItems: List<NavigationBarItem>
) {
    NavigationBar(
        modifier = modifier,
        contentColor = MaterialTheme.colorScheme.primary,
        containerColor = MaterialTheme.colorScheme.surface
    ) {
        navBarItems.forEach { item ->
            NavigationBarItem(
                icon = { Icon(
                    item.icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurface
                ) },
                label = {
                    Text(
                        text = stringResource(item.labelResource),
                        color = MaterialTheme.colorScheme.onSurface,
                        fontFamily = INTER
                    )
                },
                selected = item.isSelected,
                onClick = { navController.navigate(item.navigationRoute) }
            )
        }
    }
}