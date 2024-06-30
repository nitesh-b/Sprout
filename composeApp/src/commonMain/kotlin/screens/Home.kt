package screens

import Routes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import au.com.redmonk.resources.Res
import au.com.redmonk.resources.fun_fact
import au.com.redmonk.resources.image_fun_fact
import components.RadioGroup
import components.Text
import components.TextType
import io.github.alexzhirkevich.compottie.Compottie
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import io.github.alexzhirkevich.compottie.rememberLottiePainter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import models.Fact
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import utils.customTypoGraphy
import viewmodels.FactViewModel

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun Home(navigationController: NavHostController) {
    val lottieComposition by rememberLottieComposition {
        LottieCompositionSpec.JsonString(
            Res.readBytes("files/day.json").decodeToString()
        )
    }
    val quizOptions = listOf("Charles Babbage", "Issac Newton", "Jensen Ankles", "Lady Anna")
    val (selected, setSelected) = remember { mutableStateOf("") }
    val viewModel: FactViewModel = viewModel { FactViewModel() }

    LaunchedEffect(Unit) {
        viewModel.getFact()
    }
    MaterialTheme(typography = customTypoGraphy()) {
        val factState by viewModel.data.collectAsState()
        Column(
            modifier = Modifier.fillMaxSize()
                .background(Color.Transparent),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(modifier = Modifier.fillMaxWidth().weight(0.33f).background(color = Color.Red)) {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth,
                    painter = rememberLottiePainter(
                        composition = lottieComposition,
                        iterations = Compottie.IterateForever,

                        ),
                    contentDescription = null
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.67f)
                    .padding(12.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(text = stringResource(Res.string.fun_fact), preset = TextType.SUBTITLE1)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(modifier = Modifier.size(72.dp)) {
                        Image(
                            painter = painterResource(Res.drawable.image_fun_fact),
                            contentDescription = "",
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier.fillMaxSize()
                                .clip(shape = RoundedCornerShape(12.dp))
                        )
                    }
                    Column(
                        modifier = Modifier
                            .clickable(enabled = true,
                                onClick = {

                                    navigationController.currentBackStackEntry?.savedStateHandle?.set(
                                        Routes.FactDetail.route,
                                        Json.encodeToString(factState)
                                    )
                                    navigationController.navigate(Routes.FactDetail.route)
                                })
                    ) {
                        Text(text = factState.title, preset = TextType.H6)
                        Text(
                            text = factState.description,
                            maxLines = 2
                        )
                    }
                }

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
}
