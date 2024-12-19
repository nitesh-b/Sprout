package components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import utils.warm_yellow

@Composable
fun PageHeader(title: String, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxWidth().height(200.dp)
            .background(color = warm_yellow, RoundedCornerShape(0, 0, 100, 0))
            .padding(50.dp),
    ) {
        Text(
            text = title,
            preset = TextType.H2,
            modifier = modifier.align(Alignment.CenterStart)
        )
    }
}