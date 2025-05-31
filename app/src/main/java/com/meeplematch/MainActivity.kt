package com.meeplematch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.meeplematch.ui.navigation.ApplicationStart
import com.meeplematch.ui.theme.MeepleMatchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MeepleMatchTheme {
                ApplicationStart()
            }
        }
    }
}