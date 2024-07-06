package components.tiles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import components.Text
import components.TextType
import models.Fact
import utils.customFontFamily
import utils.customTypoGraphy
import utils.gradient_bnw

@Composable
fun FactView(fact: Fact) {
    Column(modifier = Modifier.fillMaxWidth().background(gradient_bnw).padding(12.dp)) {
        Text(text = "Did you know?", preset = TextType.H1, color = Color.White)
        // Text(text = fact.title, preset = TextType.H3, color = Color.White)
        Text(
            text = fact.description,
            style = TextStyle.Default.copy(
                fontFamily = customFontFamily(),
                fontWeight = FontWeight.Medium,
                fontSize = 28.sp,
                lineHeight = 42.sp,
                letterSpacing = (-1.5).sp
            ),
            maxLines = 3,
            color = Color.White
        )
    }
}