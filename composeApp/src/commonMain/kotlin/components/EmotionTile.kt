package components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.unit.dp
import au.com.redmonk.resources.Res
import io.github.alexzhirkevich.compottie.DotLottie
import io.github.alexzhirkevich.compottie.LottieCompositionResult
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import io.github.alexzhirkevich.compottie.rememberLottiePainter
import models.Mood
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun EmotionTile(mood: Mood, background: Color) {
    var composition: LottieCompositionResult? = null
    val lottieFile = mood.imageUrl ?: return
    if (lottieFile.endsWith(".json")) {
        composition = rememberLottieComposition {
            LottieCompositionSpec.JsonString(
                Res.readBytes("files/$lottieFile").decodeToString()
            )
        }
    } else if (lottieFile.endsWith(".lottie")) {
        composition = rememberLottieComposition {
            LottieCompositionSpec.DotLottie(
                Res.readBytes("files/$lottieFile")
            )
        }
    }

    Column(
        modifier = Modifier.wrapContentSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberLottiePainter(composition?.value, iterations = 4),
            contentDescription = null,
            modifier = Modifier.padding(10.dp).size(160.dp)
        )
        Text(
            text = mood.title,
            preset = TextType.H1,
            modifier = Modifier.padding(10.dp),
            color = if (background.luminance() > 0.5) Color.Black else Color.White
        )

    }

}