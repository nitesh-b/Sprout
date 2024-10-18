package screens

import Routes
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import au.com.redmonk.resources.Res
import au.com.redmonk.resources.login_background
import au.com.redmonk.resources.srpout_logo_white
import components.Text
import components.TextType
import io.github.aakira.napier.Napier
import models.ResponseModel
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import utils.customTypoGraphy
import viewmodels.AuthViewModel

@Composable
@Preview
fun Login(rootNavController: NavHostController, viewModel: AuthViewModel) {
    val TAG = "Login"
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val localFocusManager = LocalFocusManager.current

    val loginState by viewModel.data.collectAsState()
    LaunchedEffect(loginState) {
        when (loginState) {
            is ResponseModel.Error -> {
                Napier.d(tag = TAG, message = "Failed to Login")
            }

            ResponseModel.Loading -> Napier.d(tag = TAG, message = "Loading")
            ResponseModel.Ready -> {}
            is ResponseModel.Success -> {
                Napier.d(tag = TAG, message = "Login Successful")
                rootNavController.navigate(route = Routes.TabNav.route)
            }
        }
    }


    MaterialTheme(typography = customTypoGraphy()) {

        Box(
            modifier = Modifier.fillMaxSize().pointerInput(Unit) {
                detectTapGestures(onTap = {
                    localFocusManager.clearFocus()
                })
            }
        ) {
            Image(
                painter = painterResource(Res.drawable.login_background),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(Res.drawable.srpout_logo_white),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(200.dp)
                )

                Column(
                    modifier = Modifier.fillMaxWidth().padding(16.dp)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.Start,
                ) {

                    Text(text = "Username", preset = TextType.H4, color = Color.White)
                    TextField(
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = Color.White,
                            cursorColor = Color.White,
                            focusedIndicatorColor = Color.Transparent
                        ),
                        value = username,
                        onValueChange = {
                            username = it
                        })
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Password", preset = TextType.H4, color = Color.White)
                    TextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = password,
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = Color.White,
                            cursorColor = Color.White,
                            focusedIndicatorColor = Color.Transparent
                        ),
                        onValueChange = {
                            password = it
                        })
                    Spacer(modifier = Modifier.height(24.dp))
                    Button(modifier = Modifier.fillMaxWidth(0.5f)
                        .align(Alignment.CenterHorizontally),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.White,
                            contentColor = Color.Black,
                            disabledBackgroundColor = Color.Gray,
                            disabledContentColor = Color.Gray
                        ),
                        onClick = {
                            viewModel.loginUser(email = "abc@abc.com", password = password)
                        }) {
                        Text(text = "Login")
                    }
                }

                Button(modifier = Modifier.fillMaxWidth(0.5f)
                    .align(Alignment.CenterHorizontally),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.White,
                        contentColor = Color.Black,
                        disabledBackgroundColor = Color.Gray,
                        disabledContentColor = Color.Gray
                    ),
                    onClick = {
                        rootNavController.navigate(Routes.SignUp.route)
                    }) {
                    Text(text = "SignUp")
                }
            }
        }

    }
}