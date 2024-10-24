package screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import au.com.redmonk.resources.Res
import au.com.redmonk.resources.braniac_small
import au.com.redmonk.resources.calendar
import components.CardView
import components.Divider
import components.Text
import components.TextType
import components.tiles.FactView
import components.tiles.ScoreCardTile
import components.tiles.WordOfDayView
import io.github.aakira.napier.Napier
import models.HomeModel
import models.ResponseModel
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import utils.customFontFamily
import utils.customTypoGraphy
import utils.gradient_kashmir
import viewmodels.HomeViewModel

@Composable
@Preview
fun Home(tabNavController: NavHostController) {
    val TAG = "Home"
    val viewModel: HomeViewModel = viewModel { HomeViewModel() }
    var home: HomeModel? by remember { mutableStateOf(null) }
    LaunchedEffect(Unit) {
        viewModel.getHomeData()
    }

    val factState by viewModel.data.collectAsState()
    LaunchedEffect(factState) {
        when (factState) {
            is ResponseModel.Error -> {
                Napier.d(tag = TAG, message = "Failed to Load Home")
            }

            ResponseModel.Loading -> Napier.d(tag = TAG, message = "Loading")
            ResponseModel.Ready -> {}
            is ResponseModel.Success -> {
                home = (factState as ResponseModel.Success).data

            }
        }
    }


    MaterialTheme(typography = customTypoGraphy()) {

        Column(
            modifier = Modifier.fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            FactView(modifier = Modifier.fillMaxWidth(), data = home?.fact)
            Column(
                Modifier.fillMaxSize().padding(12.dp).padding(top = 8.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                WordOfDayView(data = home?.dictionary)
                Divider()
                Row(modifier = Modifier.fillMaxWidth()) {
                    Column(
                        modifier = Modifier.weight(1f)
                            .padding(6.dp)
                            .paint(
                                painter = painterResource(Res.drawable.calendar),
                                contentScale = ContentScale.Fit,
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center

                    ) {

                        Text(
                            text = "National Day",
                            color = Color.White,
                            preset = TextType.SUBTITLE1,
                            modifier = Modifier.fillMaxWidth().padding(top = 24.dp),
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = home?.nationalDay?.title ?: "Dummy Title",
                            preset = TextType.H4,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.weight(1f).padding(12.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(Modifier.weight(1f).aspectRatio(1f)) {
                        CardView(
                            modifier = Modifier.fillMaxWidth(),
                            image = Res.drawable.braniac_small,
                            backgroundGradient = gradient_kashmir
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(vertical = 12.dp, horizontal = 12.dp),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "Trivia Quiz Game",
                                    preset = TextType.SUBTITLE1,
                                    color = Color.White
                                )
                                Text(
                                    text = "Get ahead of your friends or create quizes for them",
                                    preset = TextType.BODY1,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }

                Divider()
                Text(
                    text = "Leaderboard",
                    preset = TextType.H6,
                    modifier = Modifier.align(Alignment.Start),
                    color = Color.White
                )
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Rank",

                        color = Color.White
                    )
                    Text(
                        text = "38",
                        style = TextStyle(
                            fontFamily = customFontFamily(),
                            fontSize = 60.sp,
                            lineHeight = 64.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        color = Color.White
                    )

                }

                ScoreCardTile()

                Text(
                    text = "Discover",
                    preset = TextType.H6,
                    modifier = Modifier.align(Alignment.Start),
                    color = Color.White
                )
//                LazyRow(
//                    modifier = Modifier
//                        .fillMaxWidth(),
//
//                    flingBehavior = ScrollableDefaults.flingBehavior()
//                ) {
//                    items(factState.discover) {
//                        DiscoverTile(it)
//                    }
//                }
                Divider()

            }
        }
    }
}
