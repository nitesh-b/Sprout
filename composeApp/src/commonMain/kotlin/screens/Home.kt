package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import au.com.redmonk.resources.Res
import components.RadioGroup
import components.Text
import components.TextType
import components.tiles.FactView
import components.tiles.WordOfDay
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview
import utils.customTypoGraphy
import viewmodels.FactViewModel

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun Home(rootNavController: NavHostController, tabNavController: NavHostController) {
    val lottieComposition by rememberLottieComposition {
        LottieCompositionSpec.JsonString(
            Res.readBytes("files/day.json").decodeToString()
        )
    }
    val quizOptions = listOf("Charles Babbage", "Issac Newton", "Jensen Ankles", "Lady Anna")
    val (selected, setSelected) = remember { mutableStateOf("") }
    val viewModel: FactViewModel = viewModel { FactViewModel() }

    LaunchedEffect(Unit) {
        viewModel.getHomeData()
    }
    MaterialTheme(typography = customTypoGraphy()) {
        val factState by viewModel.data.collectAsState()
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            FactView(factState.fact)
            WordOfDay(factState.wod)
            Column {
                Text(text = "Word of the day", preset = TextType.SUBTITLE1)
                Text(text = "expatriate \\ ɛksˈpeɪtrieɪt \\ noun ", preset = TextType.CAPTION)
                Text(text = ": a person who is voluntarily absent from home or country")
            }
            Column(
                modifier = Modifier.fillMaxWidth()
                    .background(
                        color = Color.LightGray,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "National day", preset = TextType.H6)
                Text(text = "International Fairy Day!", preset = TextType.H4)
            }
            Column(
                modifier = Modifier.fillMaxWidth()
                    .background(Color.Yellow, shape = RoundedCornerShape(12.dp))
                    .border(
                        width = 2.dp,
                        color = Color.Black,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Daily Quiz", preset = TextType.H4)

                Column {
                    Text(text = "Who is the father of computer?")
                    RadioGroup(
                        mItems = quizOptions,
                        selected = selected,
                        setSelected = setSelected
                    )
                    Button(onClick = {
                        println("Home: clicked")
                    }) {
                        Text(text = "Submit", preset = TextType.SUBTITLE1)
                    }
                }

            }
        }
    }
}
