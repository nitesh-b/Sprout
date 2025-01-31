package components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.unit.dp
import models.Action
import org.jetbrains.compose.resources.painterResource

@Composable
fun ActionTile(item: Action) {
    Column(
        modifier = Modifier.fillMaxSize().padding(4.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item.localImage?.let {
            Image(
                painterResource(item.localImage),
                contentDescription = item.toString(),
                modifier = Modifier.weight(1f)
            )
        }

        Text(
            text = item.title,
            preset = TextType.H4,
            color = if (MaterialTheme.colors.onPrimary.luminance() > 0.5) Color.Black else Color.White,
            modifier = Modifier.wrapContentSize()
        )
    }

}