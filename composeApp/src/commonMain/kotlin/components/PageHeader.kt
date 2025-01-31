package components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import utils.navBarColor

@Composable
fun PageHeader(title: String, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxWidth().height(100.dp)
            .background(color = navBarColor)
            .padding(16.dp),
    ) {
        Text(
            text = title,
            preset = TextType.H2,
            modifier = modifier.wrapContentSize().align(Alignment.BottomStart)
        )
    }
}