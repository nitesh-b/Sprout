package components.tiles

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import au.com.redmonk.resources.Res
import au.com.redmonk.resources.wod
import components.CardView
import components.Text
import components.TextType
import models.WordOfDayModel
import utils.gradient_kashmir


@Composable
fun WordOfDayView(modifier: Modifier = Modifier, data: WordOfDayModel?) {
    CardView(
        modifier = modifier.fillMaxWidth(),
        topIconPainter = Res.drawable.wod,
        backgroundGradient = gradient_kashmir
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 12.dp)
        ) {
            Text(text = data?.word ?: "", preset = TextType.H4, color = Color.White)
            Text(text = data?.pronunciation ?: "", preset = TextType.BODY1, color = Color.White)
            Text(text = data?.meaning ?: "", preset = TextType.BODY2, color = Color.White)
        }
    }

}
