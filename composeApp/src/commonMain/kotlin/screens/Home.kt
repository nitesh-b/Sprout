package screens

import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import components.tiles.DiscoverTile
import components.tiles.FactView
import components.tiles.ScoreCardTile
import components.tiles.WordOfDayView
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import utils.customFontFamily
import utils.customTypoGraphy
import utils.gradient_kashmir
import viewmodels.FactViewModel

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun Home(tabNavController: NavHostController) {
    val viewModel: FactViewModel = viewModel { FactViewModel() }

    LaunchedEffect(Unit) {
        viewModel.getHomeData()
    }

    MaterialTheme(typography = customTypoGraphy()) {
        val factState by viewModel.data.collectAsState()
        Column(
            modifier = Modifier.fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            FactView(modifier = Modifier.fillMaxWidth(), data = factState.fact)
            Column(
                Modifier.fillMaxSize().padding(12.dp).padding(top = 8.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                WordOfDayView(data = factState.wod)
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
                            text = factState.nationalDay.title,
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
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth(),

                    flingBehavior = ScrollableDefaults.flingBehavior()
                ) {
                    items(factState.discover) {
                        DiscoverTile(it)
                    }
                }
                Divider()

            }
        }
    }
}
