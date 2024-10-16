package components.tiles

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import au.com.redmonk.resources.Res
import au.com.redmonk.resources.crown
import components.Text
import components.TextType
import io.github.alexzhirkevich.compottie.Compottie
import io.github.alexzhirkevich.compottie.DotLottie
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import io.github.alexzhirkevich.compottie.rememberLottiePainter
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import utils.CustomLottieAssetManager
import utils.charcoal
import utils.contentPadding
import utils.gradient_green_beach
import utils.green
import utils.radius_s
import utils.shadow_gray

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ScoreCardTile() {

    val lottieComposition by rememberLottieComposition {
        LottieCompositionSpec.DotLottie(
            Res.readBytes("files/leaderboard_lottie.lottie")
        )
    }

    Box(modifier = Modifier.fillMaxWidth().height(400.dp)) {
        Image(
            painter = rememberLottiePainter(
                lottieComposition,
                assetsManager = CustomLottieAssetManager,
                iterations = Compottie.IterateForever
            ),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit,
            alpha = 0.2f
        )
        Row(
            modifier = Modifier.fillMaxWidth().height(300.dp).align(Alignment.BottomCenter),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(0.7f).weight(0.3f).background(
                    shadow_gray, shape = RoundedCornerShape(topStart = 24.dp)
                )
            ) {}
            Column(
                modifier = Modifier.fillMaxHeight(1f).weight(0.4f).background(
                    charcoal, shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                )
            ) {}
            Column(
                modifier = Modifier.fillMaxHeight(0.5f).weight(0.3f).background(
                    shadow_gray, shape = RoundedCornerShape(topEnd = 24.dp)
                )
            ) {}
        }
        Row(
            modifier = Modifier.fillMaxWidth().height(400.dp).align(Alignment.TopCenter),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(0.64f).weight(0.3f)
            ) {
                LeaderboardCard(
                    name = "Jackson",
                    score = 1847,
                    username = "@username",
                    rank = 2,
                    modifier = Modifier.fillMaxSize()
                )

            }
            Column(
                modifier = Modifier.fillMaxHeight(0.94f).weight(0.4f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // First Place
                Image(
                    painter = painterResource(Res.drawable.crown),
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(24.dp),
                    contentDescription = null
                )
                LeaderboardCard(
                    name = "Eiden",
                    score = 2430,
                    username = "@username",
                    rank = 1,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Column(
                modifier = Modifier.fillMaxHeight(0.5f).weight(0.3f)
            ) {

                // Third Place
                LeaderboardCard(
                    name = "Emma Aria",
                    score = 1674,
                    username = "@username",
                    rank = 3,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }


    Card(
        modifier = Modifier.wrapContentSize().padding(contentPadding).background(
            gradient_green_beach, RoundedCornerShape(radius_s)
        ),
        shape = RoundedCornerShape(radius_s),
        backgroundColor = Color.Transparent,
        elevation = 2.dp,
        border = BorderStroke(0.dp, gradient_green_beach),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().height(200.dp).clickable(enabled = true, onClick = {
                println("Do something")
            }),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Leaderboard score")


        }

    }
}


@Composable
fun LeaderboardCard(
    name: String,
    score: Int,
    username: String,
    imageRes: String = "https://randomuser.me/api/portraits/women/51.jpg",
    rank: Int,
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = modifier.fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        KamelImage(
            resource = asyncPainterResource(imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(100.dp)
                .border(BorderStroke(width = 4.dp, gradient_green_beach), shape = CircleShape)
                .clip(CircleShape)
        )
        Text(
            text = rank.toString(), color = Color.White, preset = TextType.CAPTION, maxLines = 1
        )

        Text(
            text = name,
            color = Color.White,
            preset = TextType.H6,
        )

        Text(
            text = score.toString(),
            color = green,
            preset = TextType.BODY1,
        )
        Text(
            text = username,
            color = Color.Gray,
            preset = TextType.BODY1,
        )
    }
}
