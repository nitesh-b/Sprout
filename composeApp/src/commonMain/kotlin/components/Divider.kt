package components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import utils.divider


@Composable
fun Divider(height: Dp = 2.dp, horizontal: Dp = 24.dp, vertical: Dp = 12.dp) {
    Column(modifier = Modifier.padding(horizontal = horizontal, vertical = vertical)) {
        Spacer(
            modifier = Modifier.fillMaxWidth().height(height)
                .background(divider, shape = RoundedCornerShape((height)))

        )
    }


}