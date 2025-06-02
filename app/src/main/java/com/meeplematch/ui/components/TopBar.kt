package com.meeplematch.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.meeplematch.ui.util.Route

@Composable
fun TopBar(modifier: Modifier = Modifier, navController: NavController) {
    Row(
        modifier = modifier
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            Icons.AutoMirrored.Default.ArrowBack,
            contentDescription = null,
            modifier = Modifier
                .clickable(onClick = { navController.navigate(Route.SETTINGS_SCREEN) })
                .size(24.dp)
        )
        Text(
            modifier = Modifier.padding(start = 12.dp),
            text = "Settings",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
    }
}