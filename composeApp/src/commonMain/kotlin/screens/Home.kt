package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import au.com.redmonk.resources.Res
import au.com.redmonk.resources.fun_fact
import au.com.redmonk.resources.image_fun_fact
import components.Text
import components.TextType
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import screens.utils.customTypoGraphy

@Composable
@Preview
fun Home() {

    MaterialTheme(typography = customTypoGraphy()) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(modifier = Modifier.fillMaxWidth().weight(0.33f).background(color = Color.Red)) {

            }

            Column(
                modifier = Modifier.fillMaxWidth().weight(0.67f).padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(text = stringResource(Res.string.fun_fact), preset = TextType.SUBTITLE1)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(modifier = Modifier.size(72.dp)) {
                        Image(
                            painter = painterResource(Res.drawable.image_fun_fact),
                            contentDescription = "",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.fillMaxSize()
                                .clip(shape = RoundedCornerShape(12.dp))
                        )
                    }
                    Column {
                        Text(text = "When was the first website launched?", preset = TextType.H6)
                        Text(
                            text = "The link is a snapshot of the CERN site, the first website, as of November 1992. The Web was publicly announced (via a posting to the Usenet newsgroup alt.hypertext) on August 6, 1991. Originally Tim Berners-Lee's web catalog at CERN.",
                            maxLines = 2
                        )
                    }
                }

                Column {
                    Text(text = "Word of the day", preset = TextType.SUBTITLE1)
                    Text(text = "expatriate \\ ɛksˈpeɪtrieɪt \\ noun ", preset = TextType.CAPTION)
                    Text(text = ": a person who is voluntarily absent from home or country")
                }
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .background(color = Color.LightGray,
                            shape = RoundedCornerShape(12.dp))
                        .padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "National day", preset = TextType.H6)
                    Text(text = "International Fairy Day!", preset = TextType.H4)
                }
                Column {
                    Text(text = "Daily Quiz", preset = TextType.H6)
                    Row {
                        Box(modifier = Modifier.size(40.dp))
                        Column {
                            Text(text = "Fun Facts title")
                            Text(text = "Fun Facts description")
                        }
                    }
                }

            }

        }

    }
}
