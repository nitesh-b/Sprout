package components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource


@Composable
fun RecentCard(image: DrawableResource? = null, title: String) {
    val backgroundColor = MaterialTheme.colors.secondary
    Row(
        modifier = Modifier.background(
            backgroundColor, RoundedCornerShape(10.dp)
        ).wrapContentHeight().fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        image?.let {
            Image(
                painter = painterResource(it),
                contentDescription = title,
                modifier = Modifier.size(50.dp)
            )
        }

        Text(
            text = title,
            preset = TextType.BODY2,
            color = if (backgroundColor.luminance() > 0.5) Color.Black else Color.White
        )
    }

}