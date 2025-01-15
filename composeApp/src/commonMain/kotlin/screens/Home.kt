package screens

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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import au.com.redmonk.resources.Res
import au.com.redmonk.resources.climb
import au.com.redmonk.resources.dance
import au.com.redmonk.resources.drink
import au.com.redmonk.resources.excercise
import au.com.redmonk.resources.go_out
import au.com.redmonk.resources.jump
import au.com.redmonk.resources.listen
import au.com.redmonk.resources.paint
import au.com.redmonk.resources.play
import au.com.redmonk.resources.point
import au.com.redmonk.resources.read
import au.com.redmonk.resources.run
import au.com.redmonk.resources.share
import au.com.redmonk.resources.sing
import au.com.redmonk.resources.sort
import au.com.redmonk.resources.touch
import au.com.redmonk.resources.watch
import components.PageHeader
import components.RecentCard
import components.Text
import components.TextType
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.animateLottieCompositionAsState
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import io.github.alexzhirkevich.compottie.rememberLottiePainter
import isLandscape
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import nl.marc_apps.tts.TextToSpeechInstance
import nl.marc_apps.tts.rememberTextToSpeechOrNull
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import utils.background

@OptIn(ExperimentalResourceApi::class)
@Composable
fun Home(tabNavController: NavHostController) {
    val TAG = "Home"
    val listItems =
        mapOf<String, DrawableResource>(
            "Play" to Res.drawable.play,
            "Exercise" to Res.drawable.excercise,
            "Climb" to Res.drawable.climb,
            "Dance" to Res.drawable.dance,
            "Drink" to Res.drawable.drink,
            "Read" to Res.drawable.read,
            "Go out" to Res.drawable.go_out,
            "Jump" to Res.drawable.jump,
            "Listen" to Res.drawable.listen,
            "Paint" to Res.drawable.paint,
            "Point" to Res.drawable.point,
            "Run" to Res.drawable.run,
            "Share" to Res.drawable.share,
            "Sing" to Res.drawable.sing,
            "Sort" to Res.drawable.sort,
            "Touch" to Res.drawable.touch,
            "Watch" to Res.drawable.watch,

            )

    val recentListItems = remember {
        mutableStateMapOf<String, DrawableResource>(
            "Play" to Res.drawable.play,
            "Exercise" to Res.drawable.excercise,
            "Climb" to Res.drawable.climb,
        )
    }
    val columnCount = if (isLandscape()) 8 else 5

    val ttsCoroutineScope = rememberCoroutineScope()
    val tts = rememberTextToSpeechOrNull()
    var spokenWord by remember { mutableStateOf("I want to ") }

    val speakComposition by rememberLottieComposition {
        LottieCompositionSpec.JsonString(
            Res.readBytes("files/boy_talking.json").decodeToString()
        )
    }
    val progress by animateLottieCompositionAsState(speakComposition)

    var showPopup by remember { mutableStateOf(false) }  // state to control popup visibility
    var selectedItem by remember { mutableStateOf<String?>(null) }  // store the selected item


    Surface(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Header item
            item {
                PageHeader(title = "Hello!")
            }

            // Row with Yes no buttons
            item {
                Row(
                    modifier = Modifier.fillMaxWidth().height(250.dp).padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(
                        16.dp,
                        Alignment.CenterHorizontally
                    )
                ) {

                    Box(
                        modifier = Modifier.background(background, RoundedCornerShape(20.dp))
                            .weight(1f)
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp).fillMaxWidth().fillMaxHeight(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                modifier = Modifier.wrapContentWidth().fillMaxHeight()
                                    .clickable(enabled = true, onClick = {
                                        if (tts != null) textToSpeech(
                                            spokenWord,
                                            ttsCoroutineScope,
                                            tts
                                        ) {
                                            spokenWord = "I want to "
                                        }

                                    }),
                                painter = rememberLottiePainter(
                                    speakComposition,
                                    progress = { progress }
                                ),
                                contentDescription = "Speak"
                            )
                            Text(
                                text = spokenWord,
                                preset = TextType.H1,
                                modifier = Modifier
                                    .padding(horizontal = 20.dp).weight(1f).fillMaxHeight()
                            )

                        }
                    }

                    Column {
                        Text(
                            text = "Recent",
                            preset = TextType.H4,
                            modifier = Modifier.wrapContentSize()
                        )
                        LazyColumn(
                            modifier = Modifier.wrapContentWidth().fillMaxHeight(),
                            verticalArrangement = Arrangement.spacedBy(
                                16.dp,
                                Alignment.CenterVertically
                            )
                        ) {
                            items(recentListItems.entries.toMutableList()) { item ->
                                RecentCard(image = item.value, title = item.key)
                            }

                        }
                    }

                }
            }


            item {

                Text(
                    text = "Popular",
                    preset = TextType.H2,
                    modifier = Modifier.wrapContentSize().padding(horizontal = 16.dp)
                )
            }
            items(listItems.entries.chunked(columnCount)) { rowItems ->
                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    rowItems.forEach { item ->
                        Button(
                            onClick = {
                                spokenWord += item.key.lowercase().plus(" ")
                                selectedItem = item.key // Store the selected item
                                showPopup = false  // Trigger showing the popup
                                recentListItems[item.key] = item.value
                            },
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1f)
                                .padding(2.dp),

                            ) {
                            Column(
                                modifier = Modifier.fillMaxSize().padding(4.dp),
                                verticalArrangement = Arrangement.spacedBy(8.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Image(
                                    painterResource(item.value),
                                    contentDescription = item.toString(),
                                    modifier = Modifier.weight(1f)
                                )
                                Text(
                                    text = item.key,
                                    preset = TextType.H4,
                                    modifier = Modifier.wrapContentSize()
                                )
                            }


                        }
                    }
                    // Fill empty space if the row has fewer items than the number of columns
                    repeat(columnCount - rowItems.size) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
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