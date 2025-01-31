package screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import au.com.redmonk.resources.Res
import au.com.redmonk.resources.vector_bubble
import components.ActionTile
import components.Carousel
import components.Divider
import components.PageHeader
import components.RecentCard
import components.Text
import components.TextType
import io.github.aakira.napier.Napier
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.animateLottieCompositionAsState
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import isLandscape
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import models.Action
import models.HomeModel
import models.Mood
import models.ResponseModel
import nl.marc_apps.tts.TextToSpeechInstance
import nl.marc_apps.tts.rememberTextToSpeechOrNull
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.vectorResource
import utils.baseColors
import utils.navBarColor
import viewmodels.HomeViewModel

@OptIn(ExperimentalResourceApi::class, ExperimentalFoundationApi::class)
@Composable
fun Home(tabNavController: NavHostController, homeViewModel: HomeViewModel) {
    val TAG = "Home"

    val columnCount = if (isLandscape()) 8 else 4

    val ttsCoroutineScope = rememberCoroutineScope()
    val tts = rememberTextToSpeechOrNull()
    var spokenWord by remember { mutableStateOf("") }

    val speakComposition by rememberLottieComposition {
        LottieCompositionSpec.JsonString(
            Res.readBytes("files/boy_talking.json").decodeToString()
        )
    }
    val progress by animateLottieCompositionAsState(speakComposition)

    var showPopup by remember { mutableStateOf(false) }  // state to control popup visibility
    var selectedItem by remember { mutableStateOf<String?>(null) }  // store the selected item

    var actionState by remember { mutableStateOf<List<Action>>(listOf()) }
    val recentActivities = remember { mutableStateListOf<Action>() }
    var moods by remember { mutableStateOf<List<Mood>>(listOf()) }

    val homeDataState by homeViewModel.data.collectAsState()

    LaunchedEffect(homeDataState) {

        when (homeDataState) {
            is ResponseModel.Error -> {
                Napier.d(tag = TAG, message = "Failed to Load Home data")
            }

            ResponseModel.Loading -> Napier.d(tag = TAG, message = "Loading")

            ResponseModel.Ready -> {}
            is ResponseModel.Success -> {
                (homeDataState as ResponseModel.Success<HomeModel>).data?.let { homeData ->
                    actionState = homeData.activities
                    moods = homeData.mood
                }
            }
        }
    }


    Column(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {

            PageHeader(title = "Hello!")

            Row(
                modifier = Modifier.fillMaxWidth().height(250.dp)
                    .background(navBarColor),

                horizontalArrangement = Arrangement.Center
            ) {

                Box(
                    modifier = Modifier
                        .weight(0.6f)
                        .background(
                            MaterialTheme.colors.surface,
                            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                        )
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
//                            Image(
//                                modifier = Modifier.wrapContentWidth().fillMaxHeight()
//                                    .clickable(enabled = true, onClick = {
//                                        if (tts != null) textToSpeech(
//                                            spokenWord,
//                                            ttsCoroutineScope,
//                                            tts
//                                        ) {
//                                            spokenWord = "I want to "
//                                        }
//
//                                    }),
//                                painter = rememberLottiePainter(
//                                    speakComposition,
//                                    progress = { progress }
//                                ),
//                                contentDescription = "Speak"
//                            )

                        Box(
                            modifier = Modifier.weight(1f)

                        ) {
                            Image(
                                modifier = Modifier
                                    .align(Alignment.TopStart),
                                imageVector = vectorResource(Res.drawable.vector_bubble),
                                contentDescription = null,
                                contentScale = ContentScale.FillBounds
                            )
                            Text(
                                text = spokenWord,
                                preset = TextType.H3,
                                modifier = Modifier
                                    .padding(40.dp)
                                    .align(Alignment.TopStart)
                                    .fillMaxWidth(if (isLandscape()) 0.84f else 0.9f)
                                    .fillMaxHeight()
                            )

                        }


                    }
                }

                Column(
                    modifier = Modifier
                        .weight(0.4f)
                        .padding(16.dp)
                        .background(
                            navBarColor,
                            shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
                        ),

                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Recent",
                        preset = TextType.H5,
                        modifier = Modifier.wrapContentSize().align(Alignment.Start)
                    )
                    VerticalPager(
                        pageCount = { recentActivities.size },
                        modifier = Modifier.fillMaxWidth().weight(1f)
                    ) {

                    }
                    LazyColumn(
                        modifier = Modifier.wrapContentWidth().fillMaxHeight(),
                        verticalArrangement = Arrangement.spacedBy(
                            16.dp,
                            Alignment.CenterVertically
                        )
                    ) {
                        items(recentActivities) { item ->
                            RecentCard(image = item.localImage, title = item.title)
                        }

                    }
                }

            }
        }

        Divider(height = 2.dp, vertical = 8.dp)

        LazyColumn(
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            stickyHeader {
                Column(
                    modifier = Modifier.fillMaxWidth().wrapContentHeight()
                ) {
                    Text(
                        text = "Activities",
                        preset = TextType.H3,
                        modifier = Modifier.wrapContentSize().padding(horizontal = 16.dp)
                    )
                }


            }

            items(actionState.chunked(columnCount)) { rowItems ->
                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    rowItems.forEach { item ->
                        Button(
                            onClick = {
                                spokenWord += item.title.lowercase().plus(" ")
                                // selectedItem = item.key // Store the selected item
                                showPopup = false  // Trigger showing the popup
                                if (recentActivities.contains(item)) {
                                    recentActivities.remove(item)
                                }
                                recentActivities.add(item)
                            },
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1f)
                                .padding(2.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = MaterialTheme.colors.primaryVariant
                            ),
                            shape = RoundedCornerShape(12.dp)

                        ) {
                            ActionTile(item)

                        }
                    }
                    // Fill empty space if the row has fewer items than the number of columns
                    repeat(columnCount - rowItems.size) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }


            item {
                Box(
                    modifier = Modifier.fillMaxWidth().wrapContentHeight()
                        .background(color = baseColors.background)
                ) {

                    Carousel(
                        modifier = Modifier.fillMaxWidth().wrapContentHeight()
                            .align(Alignment.BottomEnd),
                        carouselContents = moods
                    )
                    Text(
                        text = "How are you feeling Today?",
                        color = Color.White,
                        preset = TextType.H1,
                        modifier = Modifier.fillMaxWidth(0.5f).padding(horizontal = 16.dp)
                            .align(Alignment.CenterStart)
                    )
                }
            }


        }
    }

    if (showPopup && selectedItem != null) {
        OverlayView {
            showPopup = false
            selectedItem = null
        }
    }

}


fun textToSpeech(
    text: String,
    scope: CoroutineScope,
    ttsInstance: TextToSpeechInstance,
    onCompleted: ((isSuccess: Boolean) -> Unit)? = {},
) {
    scope.launch {
        ttsInstance.say(text, callback = { result ->
            if (onCompleted != null) {
                onCompleted(result.isSuccess)
            }

        })
    }


}

@Composable
fun OverlayView(callback: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0x80000000)) // Semi-transparent background to dim the underlying content
    ) {
        // Popup content with another LazyColumn
        Surface(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .align(Alignment.Center)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxHeight()
            ) {
                // Example data for the popup's LazyColumn
                items(listOf("Item 1", "Item 2", "Item 3", "Item 4")) { item ->
                    Text(
                        text = item,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .clickable { callback() }
                    )
                }
            }
        }
    }
}