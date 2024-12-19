package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import au.com.redmonk.resources.Res
import au.com.redmonk.resources.book_reading
import au.com.redmonk.resources.community
import au.com.redmonk.resources.graph
import au.com.redmonk.resources.learning
import au.com.redmonk.resources.left_arrow
import au.com.redmonk.resources.loom
import au.com.redmonk.resources.right_arrow
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import utils.background
import utils.background_complimentary
import utils.gradient_background
import utils.primary
import utils.secondary
import utils.tertiary

@Composable
fun OnboardingScreen(onStartClick: () -> Unit) {

    var currentPage by remember { mutableIntStateOf(0) }
    val totalPages = 5

    Surface(color = MaterialTheme.colors.primary) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(background),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (currentPage) {
                0 -> OnboardingPage(
                    title = "Welcome to Loom",
                    description = "Weaving Independence,\n\tOne Skill at a Time.",
                    imageRes = Res.drawable.loom,
                    onNextClick = { currentPage++ }
                )

                1 -> OnboardingPage(
                    title = "Personalized Learning",
                    description = "Tailor activities to suit your child's unique needs.",
                    imageRes = Res.drawable.learning,
                    onNextClick = { currentPage++ }
                )

                2 -> OnboardingPage(
                    title = "Track Progress",
                    description = "Monitor your child's development over time.",
                    imageRes = Res.drawable.graph,
                    onNextClick = { currentPage++ }
                )

                3 -> OnboardingPage(
                    title = "Interactive Activities",
                    description = "Engage with fun and educational tasks.",
                    imageRes = Res.drawable.book_reading,
                    onNextClick = { currentPage++ }
                )

                4 -> OnboardingPage(
                    title = "Join Our Community",
                    description = "Connect with other parents and share experiences.",
                    imageRes = Res.drawable.community,
                    onNextClick = { /* Navigate to the main app screen */ }
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Page Indicator
            PageIndicator(currentPage, totalPages)

            Spacer(modifier = Modifier.height(16.dp))

            // Navigation Controls
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (currentPage > 0) {
                    Button(
                        onClick = { currentPage-- },
                        colors = ButtonDefaults.buttonColors(backgroundColor = background_complimentary),
                        shape = CircleShape,
                        modifier = Modifier.size(60.dp)
                    ) {
                        Image(
                            painterResource(Res.drawable.left_arrow),
                            contentDescription = "Left arrow",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }

                if (currentPage < totalPages - 1) {
                    Button(
                        onClick = { currentPage++ },
                        colors = ButtonDefaults.buttonColors(backgroundColor = secondary),
                        shape = CircleShape,
                        modifier = Modifier.size(60.dp)
                    ) {
                        Image(
                            painterResource(Res.drawable.right_arrow),
                            contentDescription = "Right arrow",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                } else {
                    Button(
                        onClick = { onStartClick() },
                        colors = ButtonDefaults.buttonColors(backgroundColor = secondary),
                        shape = CircleShape,
                        modifier = Modifier.wrapContentWidth().height(60.dp)
                    ) {
                        BasicText(text = "Get Started")
                    }
                }
            }
        }
    }
}

@Composable
fun OnboardingPage(
    title: String,
    description: String,
    imageRes: DrawableResource,
    onNextClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxHeight(0.6f)
            .fillMaxWidth()
            .padding(16.dp)
            .background(primary, shape = RoundedCornerShape(16.dp)),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(imageRes),
            contentDescription = title,
            modifier = Modifier
                .fillMaxWidth()
                .background(brush = gradient_background, shape = RoundedCornerShape(16.dp)),
            contentScale = ContentScale.FillWidth,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = title, fontSize = 24.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = description, fontSize = 16.sp, color = Color.Black)
    }

}

@Composable
fun PageIndicator(currentPage: Int, totalPages: Int) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {

        for (i in 0 until totalPages) {
            val color =
                if (i == currentPage) tertiary else secondary
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .padding(4.dp)
                    .background(color, shape = RoundedCornerShape(10.dp))
            )
        }
    }
}
