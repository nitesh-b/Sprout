package components.tiles

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import components.Text
import components.TextType
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import models.DiscoverModel
import nativemodules.timeStampToDate
import utils.contentPadding
import utils.radius_s

@Composable
fun DiscoverTile(data: DiscoverModel) {
    Card(
        modifier = Modifier.wrapContentSize().padding(contentPadding),
        shape = RoundedCornerShape(radius_s)
    ) {
        Row(
            modifier = Modifier.width(340.dp).wrapContentHeight()
                .clickable(enabled = true, onClick = {
                    println("Do something")
                }),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            KamelImage(
                resource = asyncPainterResource(data.imageUrl, key = data.id),
                contentDescription = null,
                modifier = Modifier.wrapContentSize().weight(1f),
                contentScale = ContentScale.FillWidth
            )
            Column(modifier = Modifier.fillMaxHeight().weight(1f).padding(contentPadding)) {
                Text(text = data.title, preset = TextType.H6)
                Text(text = timeStampToDate(data.dateTS), preset = TextType.BODY1)
                Text(text = data.address, preset = TextType.CAPTION)
            }

        }


    }
}