package com.meeplematch

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.meeplematch.data.client.RetrofitClient
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UserTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private val testUsername = "user"
    private val testPassword = "user"

    @Test
    fun getUser_successfulFoundUser() {
        val userRepo = RetrofitClient.userApi
        val res = runBlocking {
            userRepo.getPublicUser(testUsername)
        }

        assertNotNull("Response should not be null after fetching user", res)
    }

    @Test
    fun getUser_unsuccessfulFoundUser() {
        val userRepo = RetrofitClient.userApi
        var exceptionThrown = false

        try {
            runBlocking {
                userRepo.getPublicUser("bad")
            }
        } catch (e: Exception) {
            exceptionThrown = true
        }

        assertTrue("Exception should be thrown for non-existing user", exceptionThrown)
    }
}