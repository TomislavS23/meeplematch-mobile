package com.meeplematch.ui.theme.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.meeplematch.ui.theme.navigation.BottomBar
import com.meeplematch.ui.theme.navigation.SearchBar

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val textFieldState = remember { TextFieldState() }
    val searchResults = remember { mutableStateOf(emptyList<String>()) }
    val onSearch: (String) -> Unit = { query ->
        searchResults.value = listOf("Result 1 for $query", "Result 2 for $query")
    }

    Scaffold(
        topBar = {
            SearchBar(
                textFieldState = textFieldState,
                onSearch = onSearch,
                searchResults = searchResults.value,
                modifier = Modifier.fillMaxWidth()
            )
        },
        bottomBar = { BottomBar() }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            // Screen content
        }
    }
}