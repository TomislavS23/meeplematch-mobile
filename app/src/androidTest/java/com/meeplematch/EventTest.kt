package com.meeplematch

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.meeplematch.data.client.RetrofitClient
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EventTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun getEvents_successfulFoundEvents() {
        val eventRepo = RetrofitClient.eventApi
        val res = runBlocking {
            eventRepo.getEvents()
        }

        assertNotNull("Response should not be null after fetching events", res)
    }
}