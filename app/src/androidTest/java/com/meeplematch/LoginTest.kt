package com.meeplematch

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.meeplematch.data.client.RetrofitClient
import com.meeplematch.data.datastore.ID_USER
import com.meeplematch.data.datastore.userStore
import com.meeplematch.data.repository.UserRepository
import com.meeplematch.ui.components.auth.LoginForm
import com.meeplematch.ui.util.Route.MAIN_SCREEN
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.HttpException

@RunWith(AndroidJUnit4::class)
class LoginTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private val testUsername = "user"
    private val testPassword = "user"

    @Test
    fun loginForm_successfullyFoundUser() {
        val authRepo = RetrofitClient.authApi
        val res = runBlocking {
            authRepo.login(testUsername, testPassword)
        }

        assertNotNull("Response should not be null after login", res)
    }

    @Test
    fun loginForm_unsuccessfulLogin() {
        val authRepo = RetrofitClient.authApi
        var exceptionThrown = false

        try {
            runBlocking {
                authRepo.login("bad", "req")
            }
        } catch (e: Exception) {
            exceptionThrown = true
        }

        assertTrue("HttpException should be thrown for invalid login", exceptionThrown)

    }
}