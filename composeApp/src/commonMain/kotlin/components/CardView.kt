package components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import utils.gradient_kashmir
import utils.gradient_transparent

@Composable
fun CardView(modifier : Modifier = Modifier,
             topIconPainter: DrawableResource? = null,
             image: DrawableResource? = null,
             backgroundGradient: Brush = gradient_transparent,
             content: (@Composable ColumnScope.() -> Unit)? = null) {
    val cornerRadius: Dp = 16.dp
    val shadowElevation: Dp = 1.dp
    val gray200 = Color(0x20FFFFFF)
    Box(
        modifier = modifier
            .padding(4.dp)
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .align(Alignment.CenterStart)
                .background(Color.Transparent)
                .shadow(
                    elevation = shadowElevation,
                    shape = RoundedCornerShape(cornerRadius),
                    clip = false,
                )
                .clip(shape = RoundedCornerShape(cornerRadius))
                .offset((-3).dp, (-3).dp),
            backgroundColor = Color.Transparent,
            elevation = 0.dp


        ) {
            Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(backgroundGradient, shape = RoundedCornerShape(cornerRadius))
                        .border(
                            width = 1.dp,
                            gradient_kashmir,
                            shape = RoundedCornerShape(cornerRadius)
                        )
                        .clip(shape = RoundedCornerShape(cornerRadius))
                    ){
                if(image != null){
                    Image(
                        painter = painterResource(image),
                        contentDescription = "Overlapping Image",
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentScale = ContentScale.FillWidth
                    )
                }
                    if (content != null) {
                        content()
                    }
            }
        }
        if (topIconPainter != null) {
            Image(
                painter = painterResource(topIconPainter),
                contentDescription = "Overlapping Image",
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.TopEnd)
                    .offset(x = (-25).dp, y = (-25).dp)
            )
        }


    }
}