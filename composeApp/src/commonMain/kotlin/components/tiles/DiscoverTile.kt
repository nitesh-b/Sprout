package components.tiles

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import components.Text
import components.TextType
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import models.DiscoverModel
import utils.contentPadding
import utils.radius_s

@Composable
fun DiscoverTile(data: DiscoverModel) {
    Card(
        modifier = Modifier.wrapContentSize().padding(contentPadding),
        shape = RoundedCornerShape(radius_s)
    ) {
        Column(
            modifier = Modifier.wrapContentSize().padding(contentPadding)
                .clickable(enabled = true, onClick = {
                    println("Do something")
                }),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            KamelImage(
                resource = asyncPainterResource(data.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .background(Color.Black, RoundedCornerShape(50.dp))
                    .clip(RoundedCornerShape(50.dp))
            )
            Text(text = data.title, preset = TextType.H4)
            Text(text = data.dateTS.toString(), preset = TextType.H6)
            Text(text = data.address, preset = TextType.BODY1)
        }


    }
}