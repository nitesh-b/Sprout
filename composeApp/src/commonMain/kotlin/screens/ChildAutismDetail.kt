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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import au.com.redmonk.resources.Res
import au.com.redmonk.resources.right_arrow
import components.DropdownMenu
import components.InterestChips
import components.MultiCheckBoxList
import components.RadioButtonGroup
import components.Text
import components.TextType
import models.InterestItem
import org.jetbrains.compose.resources.painterResource
import utils.baseColors
import utils.navBarColor
import utils.tertiary
import viewmodels.AuthViewModel

@Composable
fun ChildAutismDetail(rootNavController: NavHostController, viewModel: AuthViewModel) {


    val scrollState = rememberScrollState()
    val spectrumLevels =
        listOf("Level 1", "Level 2", "Level 3")
    val spectrumLevelState =
        remember { mutableStateOf(0) }

    val communicationLevel =
        listOf("Verbal", "Non-verbal", "Limited-speech", "Write", "Image interaction")
    val communicationLevelState =
        remember { mutableStateOf(List(communicationLevel.size) { false }) }

    val sensorySensitivities = listOf(
        "Visual ( bright lights, patterns)",
        "Auditory (loud noises, background sounds)",
        "Tactile (textures, light touch)",
        "Olfactory (strong scents)",
        "Gustatory (food texture, taste aversions)",
        "Proprioceptive (body awareness, deep pressure)",
        "Vestibular (motion, balance)",
        "Temperature (sensitivity to heat or cold)",
        "Pain (heightened or reduced pain response)",
        "Social (difficulty with social cues, eye contact)"
    )
    val sensorySensitivitiesState =
        remember { mutableStateOf(List(sensorySensitivities.size) { false }) }


    val socialInteractions = listOf(
        "One-on-one",
        "Group play",
        "Turn-taking activities",
        "Parallel play",
        "Cooperative play",
        "Non-verbal communication",
        "Role-playing",
        "Imitation and modeling",
    )

    val socialInteractionsState =
        remember { mutableStateOf("Select one") }


    val commonInterests = remember {
        mutableStateListOf(
            InterestItem(id = 1, value = "Animals"),
            InterestItem(id = 2, value = "Trains"),
            InterestItem(id = 3, value = "Cars"),
            InterestItem(id = 4, value = "Numbers"),
            InterestItem(id = 5, value = "Patterns"),
            InterestItem(id = 6, value = "Technology"),
            InterestItem(id = 7, value = "Art and drawing"),
            InterestItem(id = 8, value = "Music"),
            InterestItem(id = 9, value = "Books and stories"),
            InterestItem(id = 10, value = "Nature"),
            InterestItem(id = 11, value = "Legos"),
            InterestItem(id = 12, value = "Toys"),
            InterestItem(id = 13, value = "Collecting")
        )
    }
    // Handle selection changes
    val onCommonInterestsSelectionChanged: (InterestItem) -> Unit = { selectedItem ->
        val index = commonInterests.indexOfFirst { it.id == selectedItem.id }
        if (index != -1) {
            commonInterests[index] = selectedItem.copy(isChecked = !(selectedItem.isChecked))
        }
    }

    Column(
        modifier = Modifier.fillMaxSize()
            .background(baseColors.secondary)
    ) {

        Box(
            modifier = Modifier.fillMaxWidth().height(200.dp)
                .background(color = navBarColor, RoundedCornerShape(0, 0, 100, 0))
                .padding(50.dp),
        ) {
            // Header Section
            Text(
                text = "Understanding your child's needs and abilities",
                preset = TextType.H2,
                modifier = Modifier.align(Alignment.CenterStart)
            )
        }



        Column(
            modifier = Modifier.fillMaxWidth().weight(1f).padding(16.dp)
                .verticalScroll(scrollState)
        ) {

            Column(
                modifier = Modifier.fillMaxWidth().wrapContentHeight()
                    .background(color = baseColors.secondary, shape = RoundedCornerShape(16.dp))
                    .padding(16.dp)
            ) {
                Text(text = "Autism Spectrum Disorder level", preset = TextType.H4)
                RadioButtonGroup(
                    items = spectrumLevels,
                    selectedOption = spectrumLevelState
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            //Communication Level
            Column(
                modifier = Modifier.fillMaxWidth().wrapContentHeight()
                    .background(color = baseColors.secondary, shape = RoundedCornerShape(16.dp))
                    .padding(16.dp)
            ) {
                Text(text = "Communication level:", preset = TextType.H4)
                MultiCheckBoxList(
                    items = communicationLevel,
                    checkedState = communicationLevelState
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            //Sensory sensitivities
            Column(
                modifier = Modifier.fillMaxWidth().wrapContentHeight()
                    .background(color = baseColors.background, shape = RoundedCornerShape(16.dp))
                    .padding(16.dp)
            ) {
                Text(text = "Sensory sensitivities:", preset = TextType.H4)
                MultiCheckBoxList(
                    items = sensorySensitivities,
                    checkedState = sensorySensitivitiesState
                )

            }

            Spacer(modifier = Modifier.height(16.dp))

            //Sensory sensitivities
            Column(
                modifier = Modifier.fillMaxWidth().wrapContentHeight()
                    .background(
                        color = baseColors.secondary,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(16.dp)
            ) {

                Text(text = "Social interaction", preset = TextType.H4)
                DropdownMenu(
                    items = socialInteractions,
                    selectedItem = socialInteractionsState.value,
                    onItemSelected = { item -> socialInteractionsState.value = item },
                )

            }

            Spacer(modifier = Modifier.height(16.dp))

            //Common interests
            Column(
                modifier = Modifier.fillMaxWidth().wrapContentHeight()
                    .background(
                        color = baseColors.secondary,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(16.dp)
            ) {

                Text(text = "Area of interests: ", preset = TextType.H4)
                InterestChips(commonInterests, onCommonInterestsSelectionChanged)
            }

        }

        Box(
            modifier = Modifier.fillMaxWidth().height(100.dp)
                .background(color = tertiary, RoundedCornerShape(20, 20, 0, 0)),
        ) {
            // "Next" Button
            Button(
                onClick = { rootNavController.navigate(Routes.TabNav.route) },
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
