package screens

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import au.com.redmonk.resources.Res
import components.Text
import components.TextType
import io.github.alexzhirkevich.compottie.Compottie
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import io.github.alexzhirkevich.compottie.rememberLottiePainter
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import models.Fact
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn( ExperimentalResourceApi::class)
@Composable
@Preview
fun FunFactDetail(navigationController: NavHostController, jsonString: String?) {
    val fact = jsonString?.let { Json.decodeFromString<Fact>(it) }
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val composition by rememberLottieComposition {
        LottieCompositionSpec.JsonString(
            Res.readBytes("files/loading.json").decodeToString()
        )
    }

    MaterialTheme {

        Column(
            modifier = Modifier

                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Yellow,
                            Color.LightGray
                        )
                    )
                )
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            KamelImage(
                resource = asyncPainterResource(fact?.imageUrl ?: ""),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.aspectRatio(16f / 9f),
                onLoading = { progress ->
                    Image(painter = rememberLottiePainter(
                        composition = composition,
                        iterations = Compottie.IterateForever,

                    ),
                        contentDescription = null)
                },
                onFailure = { exception ->
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(
                            message = exception.message.toString(),
                            actionLabel = "Hide",
                            duration = SnackbarDuration.Short
                        )
                    }
                },
                animationSpec = tween()
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White, shape = RoundedCornerShape(12.dp))
                    .padding(8.dp)
            ) {
                fact?.title?.let { Text(text = it, preset = TextType.H4) }
                fact?.description?.let { Text(text = it) }
                Button(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    onClick = { navigationController.popBackStack() }) {
                    Text(text = "Done")
                }
            }
        }
    }

}