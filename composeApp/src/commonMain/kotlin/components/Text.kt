package components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import utils.customTypoGraphy


enum class TextType {
    H1, H2, H3, H4, H5, H6, BODY1, BODY2, SUBTITLE1, SUBTITLE2, CAPTION
}


@Composable
fun Text(
    modifier: Modifier = Modifier,
    text: String,
    preset: TextType = TextType.BODY1,
    maxLines: Int = Int.MAX_VALUE,
    color: Color = Color.Black,
    textAlign: TextAlign = TextAlign.Start,
    style: TextStyle? = null,
) {

    return androidx.compose.material.Text(
        maxLines = maxLines,
        modifier = modifier,
        text = text,
        color = color,
        style = style ?: getTextStyle(preset).copy(
            fontWeight = style?.fontWeight,
            color = style?.color ?: color,
            fontFamily = style?.fontFamily,
        ),
        overflow = TextOverflow.Ellipsis,
        textAlign = textAlign
    )
}

@Composable
fun getTextStyle(textType: TextType): TextStyle {
    val typography = customTypoGraphy()
    val style: TextStyle
    when (textType) {
        TextType.H1 -> {
            style = typography.h1
        }

        TextType.H2 -> {
            style = typography.h2
        }

        TextType.H3 -> {
            style = typography.h3
        }

        TextType.H4 -> {
            style = typography.h4
        }

        TextType.H5 -> {
            style = typography.h5
        }

        TextType.H6 -> {
            style = typography.h6
        }

        TextType.BODY1 -> {
            style = typography.body1
        }

        TextType.BODY2 -> {
            style = typography.body2
        }

        TextType.SUBTITLE1 -> {
            style = typography.subtitle1
        }

        TextType.SUBTITLE2 -> {
            style = typography.subtitle2
        }

        TextType.CAPTION -> {
            style = typography.caption
        }
    }
    return style
}