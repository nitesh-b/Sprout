package components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import models.Mood
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Carousel(modifier: Modifier = Modifier, carouselContents: List<Mood>) {
    val pagerState = rememberPagerState(pageCount = { carouselContents.size }, initialPage = 1)
    val backgroundColor = MaterialTheme.colors.secondaryVariant
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = modifier
    ) {
        HorizontalPager(
            state = pagerState,
            verticalAlignment = Alignment.CenterVertically,
            contentPadding = PaddingValues(horizontal = 12.dp),
            pageSpacing = 8.dp,
            key = { index -> index },
        ) { page ->
            val pageOffset =
                (pagerState.currentPage - page) + pagerState
                    .currentPageOffsetFraction

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .graphicsLayer {
                        val scale = 1f - (0.3f * kotlin.math.abs(pageOffset))
                        scaleX = scale
                        scaleY = scale
                        alpha =
                            if (pageOffset.absoluteValue < 1f) 1f else 0.5f // Reduce opacity for non-focused items
                    },

                shape = RoundedCornerShape(16.dp),
                backgroundColor = backgroundColor,
                elevation = 8.dp,

                ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.CenterEnd,
                ) {
                    EmotionTile(carouselContents[page], backgroundColor)
                }

            }
        }


        Row(
            Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(8.dp)
                )
            }
        }
    }
}

