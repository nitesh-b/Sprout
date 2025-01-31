package screens

import Routes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import au.com.redmonk.resources.Res
import au.com.redmonk.resources.right_arrow
import components.TextType
import org.jetbrains.compose.resources.painterResource
import utils.baseColors
import utils.navBarColor
import utils.tertiary
import viewmodels.AuthViewModel

@Composable
fun ChildInfoScreen(rootNavController: NavHostController, viewModel: AuthViewModel) {
    // State variables for user input
    var childName by remember { mutableStateOf(TextFieldValue("")) }
    var birthYear by remember { mutableStateOf("") }
    var parentEmail by remember { mutableStateOf(TextFieldValue("")) }


    val inputFieldBackground = Color(0xFFEFEFEF) // Light grey for input background
    val buttonColor = Color(0xFFB2E4D5) // Light teal button color
    val darkTextColor = Color(0xFF2E3D49) // Dark Slate Gray for text

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(baseColors.secondary),
    ) {

        Box(
            modifier = Modifier.fillMaxWidth().height(200.dp)
                .background(color = navBarColor, RoundedCornerShape(0, 0, 100, 0))
                .padding(50.dp),
        ) {
            // Header Section
            components.Text(
                text = "Tell us about your child.",
                preset = TextType.H2,
                modifier = Modifier.align(Alignment.CenterStart)
            )
        }

        Column(
            modifier = Modifier
                .weight(1F)
                .fillMaxSize()
                .background(baseColors.secondary)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(16.dp))

            // Child's Name Input
            Text(
                text = "Child's Name",
                color = darkTextColor,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = childName,
                onValueChange = { childName = it },
                placeholder = { Text("Child's Name") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = inputFieldBackground,
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(inputFieldBackground)
                    .padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Birth Year Input (Dropdown Simulation)
            Text(
                text = "Birth Year",
                color = darkTextColor,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = birthYear,
                onValueChange = { birthYear = it },
                placeholder = { Text("Year") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = inputFieldBackground,
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(inputFieldBackground)
                    .padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Parent's Email Input
            Text(
                text = "Parent's Email Address",
                color = darkTextColor,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = parentEmail,
                onValueChange = { parentEmail = it },
                placeholder = { Text("parent@email.com") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = inputFieldBackground,
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(inputFieldBackground)
                    .padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))


        }

        Box(
            modifier = Modifier.fillMaxWidth().height(100.dp)
                .background(color = tertiary, RoundedCornerShape(50, 50, 0, 0)),
        ) {
            // "Next" Button
            Button(
                onClick = { rootNavController.navigate(Routes.ChildAutismDetail.route) },
                colors = ButtonDefaults.buttonColors(backgroundColor = baseColors.primary),
                shape = CircleShape,
                modifier = Modifier.size(60.dp).align(Alignment.Center)
            ) {
                Image(
                    painterResource(Res.drawable.right_arrow),
                    contentDescription = "Right arrow",
                    modifier = Modifier.size(24.dp)
                )
            }
        }

    }
}
