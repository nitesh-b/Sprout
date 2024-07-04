package components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import utils.gradient_green_beach

@Composable
fun Divider(height: Dp = 2.dp, horizontal: Dp = 32.dp, vertical: Dp = 12.dp) {
    Spacer(
        modifier = Modifier.fillMaxWidth().height(height)
            .background(gradient_green_beach, shape = RoundedCornerShape((height)))
            .padding(horizontal = horizontal, vertical = vertical)
    )

}