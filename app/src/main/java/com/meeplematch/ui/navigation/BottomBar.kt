package com.meeplematch.ui.navigation

import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.meeplematch.R
import com.meeplematch.ui.theme.PrimaryAccentColor

@Composable
fun BottomBar(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    NavigationBar(
        modifier = modifier,
        contentColor = PrimaryAccentColor,
    ){
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = null) },
            label = { Text(text = stringResource(R.string.bottom_bar_home)) },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.QrCode, contentDescription = null) },
            label = { Text(text = stringResource(R.string.scan_qr_code)) },
            selected = false,
            onClick = { Toast.makeText(context, "Not yet implemented!", Toast.LENGTH_SHORT).show() }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.AccountCircle, contentDescription = null) },
            label = { Text(text = stringResource(R.string.bottom_bar_profile)) },
            selected = false,
            onClick = {}
        )
    }
}