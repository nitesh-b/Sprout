package screens

import Routes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import au.com.redmonk.resources.Res
import au.com.redmonk.resources.login_background
import components.Text
import components.TextType
import io.github.aakira.napier.Napier
import models.ResponseModel
import models.SignUp
import org.jetbrains.compose.resources.painterResource
import utils.customTypoGraphy
import viewmodels.AuthViewModel


@Composable
fun SignUp(
    rootNavController: NavHostController,
    authViewModel: AuthViewModel,
) {
    val TAG = "SignUp"
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var mobile by remember { mutableStateOf("") }
    var dob by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rePassword by remember { mutableStateOf("") }

    val signUpUser = SignUp()

    val loginState by authViewModel.data.collectAsState()
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
        Image(
            painter = painterResource(Res.drawable.login_background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )

        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .background(Color.Transparent)

            ) {
                Text(text = "Sign Up", modifier = Modifier.align(Alignment.Center))
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(12.dp)
                    .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(20.dp))
                    .background(
                        color = Color(red = 100, green = 100, blue = 52, alpha = 200),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(20.dp)
            ) {

                Row(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = "First Name", preset = TextType.H4, color = Color.White)
                        TextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = firstName,
                            colors = TextFieldDefaults.textFieldColors(
                                textColor = Color.White,
                                cursorColor = Color.White,
                                focusedIndicatorColor = Color.Transparent
                            ),
                            onValueChange = {
                                firstName = it
                                signUpUser.firstName = it
                            })
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = "Last name", preset = TextType.H4, color = Color.White)
                        TextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = lastName,
                            colors = TextFieldDefaults.textFieldColors(
                                textColor = Color.White,
                                cursorColor = Color.White,
                                focusedIndicatorColor = Color.Transparent
                            ),
                            onValueChange = {
                                lastName = it
                                signUpUser.lastName = it
                            })
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text(text = "Email", preset = TextType.H4, color = Color.White)
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = email,
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.White,
                        cursorColor = Color.White,
                        focusedIndicatorColor = Color.Transparent
                    ),
                    onValueChange = {
                        email = it
                        signUpUser.email = it
                    })
                Spacer(modifier = Modifier.height(24.dp))

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
                        signUpUser.password = it
                    })
                Spacer(modifier = Modifier.height(24.dp))

                Text(text = "Re-password", preset = TextType.H4, color = Color.White)
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = rePassword,
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.White,
                        cursorColor = Color.White,
                        focusedIndicatorColor = Color.Transparent
                    ),
                    onValueChange = {
                        rePassword = it
                        signUpUser.retryPassword = it
                    })
                Spacer(modifier = Modifier.height(24.dp))
                Text(text = "Birth year", preset = TextType.H4, color = Color.White)
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = dob,
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.White,
                        cursorColor = Color.White,
                        focusedIndicatorColor = Color.Transparent
                    ),
                    onValueChange = {
                        dob = it
                        signUpUser.dob = it
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
                        print(signUpUser)
                        authViewModel.signUpUser(signUpUser)
                    }) {
                    Text(text = "Create account")
                }
            }

        }


    }

}
