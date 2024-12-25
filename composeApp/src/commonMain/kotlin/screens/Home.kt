package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import au.com.redmonk.resources.Res
import au.com.redmonk.resources.climb
import au.com.redmonk.resources.dance
import au.com.redmonk.resources.dislike
import au.com.redmonk.resources.drink
import au.com.redmonk.resources.excercise
import au.com.redmonk.resources.go_out
import au.com.redmonk.resources.jump
import au.com.redmonk.resources.like
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
import components.Text
import components.TextType
import isLandscape
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import utils.secondary

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

    val columnCount = if (isLandscape()) 5 else 3

    var spokenWord by remember { mutableStateOf("I want to ") }

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

            // Row with buttons
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(
                        16.dp,
                        Alignment.CenterHorizontally
                    )
                ) {
                    Button(
                        onClick = {},
                        modifier = Modifier.wrapContentWidth().height(120.dp).padding(16.dp),
                    ) {
                        Image(
                            painterResource(Res.drawable.like),
                            contentDescription = "Yes",
                            modifier = Modifier.size(40.dp)
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Text(text = "Yes", preset = TextType.H2)
                    }
                    Button(
                        onClick = {},
                        modifier = Modifier.wrapContentWidth().height(120.dp).padding(16.dp)
                    ) {
                        Image(
                            painterResource(Res.drawable.dislike),
                            contentDescription = "No",
                            modifier = Modifier.size(40.dp)
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Text(text = "No", preset = TextType.H2)
                    }
                }
            }

            // Text row
            item {
                Row(
                    modifier = Modifier.padding(16.dp).fillMaxWidth()
                        .background(secondary, RoundedCornerShape(20.dp))
                        .padding(horizontal = 24.dp)
                ) {
                    Text(text = spokenWord, preset = TextType.H1)
                }
            }

            // Grid items as part of LazyColumn
            items(listItems.entries.chunked(columnCount)) { rowItems ->
                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    rowItems.forEach { item ->
                        Button(
                            onClick = { spokenWord += item.key.lowercase().plus(" ") },
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
                                    preset = TextType.H3,
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


}


@Composable
fun GridItem(item: String) {

}