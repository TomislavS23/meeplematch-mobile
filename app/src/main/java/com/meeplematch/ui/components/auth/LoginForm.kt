package com.meeplematch.ui.components.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.meeplematch.R
import com.meeplematch.data.datastore.ID_USER
import com.meeplematch.data.datastore.userStore
import com.meeplematch.data.datastore.writeIntoDataStore
import com.meeplematch.ui.theme.INTER
import com.meeplematch.ui.util.Route
import kotlinx.coroutines.launch

@Composable
fun LoginForm(navController: NavController) {
    var usernameFieldValue by rememberSaveable { mutableStateOf("") }
    var passwordFieldValue by rememberSaveable { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    Column(
        modifier = Modifier.width(350.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = Modifier.padding(top = 64.dp),
            painter = painterResource(R.drawable.app_logo_general),
            contentDescription = null
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = stringResource(R.string.meeplematch),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = INTER
        )

        Spacer(modifier = Modifier.height(60.dp))

        OutlinedTextField(
            modifier = Modifier.width(350.dp),
            value = usernameFieldValue,
            onValueChange = {
                usernameFieldValue = it
            },
            singleLine = true,
            label = { Text(stringResource(R.string.username)) },
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            modifier = Modifier.width(350.dp),
            value = passwordFieldValue,
            onValueChange = {
                passwordFieldValue = it
            },
            singleLine = true,
            label = { Text(stringResource(R.string.password)) },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                scope.launch {
                    writeIntoDataStore(context.userStore, ID_USER, "1") // TODO: read from somewhere
                    navController.navigate(Route.MAIN_SCREEN)
                }
            },
        ) {
            Text(
                text = "Submit",
                fontFamily = INTER,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}