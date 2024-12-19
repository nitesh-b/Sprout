package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import au.com.redmonk.resources.Res
import au.com.redmonk.resources.dislike
import au.com.redmonk.resources.like
import components.PageHeader
import components.Text
import components.TextType
import isLandscape
import org.jetbrains.compose.resources.painterResource

@Composable
fun Home(tabNavController: NavHostController) {
    val TAG = "Home"
    val listItems =
        listOf(
            "A",
            "B",
            "C",
            "D",
            "E",
            "F",
            "G",
            "H",
            "I",
            "J",
            "K",
            "L",
            "M",
            "N",
            "O",
            "P",
            "Q",
            "R",
            "S",
            "T",
            "U",
            "V",
            "W",
            "X",
            "Y",
            "Z"
        )

    val columnCount = if (isLandscape()) 5 else 3

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
                Row(modifier = Modifier.padding(16.dp)) {
                    Text(text = "I want to...", preset = TextType.H1)
                }
            }

            // Grid items as part of LazyColumn
            items(listItems.chunked(columnCount)) { rowItems ->
                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    rowItems.forEach { item ->
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1f)
                                .padding(2.dp),

                            ) {
                            Text(
                                text = item,
                                preset = TextType.H3,
                                color = Color.Black,
                                textAlign = TextAlign.Center
                            )
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