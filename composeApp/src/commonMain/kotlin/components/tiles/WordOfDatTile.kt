package components.tiles

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import au.com.redmonk.resources.Res
import au.com.redmonk.resources.wod
import components.Text
import components.TextType
import models.WordOfDayModel
import org.jetbrains.compose.resources.painterResource
import utils.gradient_kashmir

@Composable
fun WordOfDay(data: WordOfDayModel) {
    Box(modifier = Modifier.fillMaxWidth(0.8f).background(Color.Transparent).padding(top = 16.dp)) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterStart)
                .background(gradient_kashmir, shape = RoundedCornerShape(16.dp))
                .border(color = Color.Transparent, shape = RoundedCornerShape(16.dp), width = 2.dp)
                .padding(12.dp)
        ) {
            Text(text = data.word, preset = TextType.H4, color = Color.White)
            Text(text = data.phonetics, preset = TextType.BODY1, color = Color.White)
            Text(text = data.meaning, preset = TextType.BODY2, color = Color.White)
        }

        Image(
            painter = painterResource(Res.drawable.wod),
            contentDescription = "Overlapping Image",
            modifier = Modifier
                .size(50.dp)
                .align(Alignment.TopEnd)
                .offset(x = (-25).dp, y = (-25).dp)
        )


    }

}