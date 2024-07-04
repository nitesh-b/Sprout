package utils

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import au.com.redmonk.resources.OpenSans_Bold
import au.com.redmonk.resources.OpenSans_ExtraBold
import au.com.redmonk.resources.OpenSans_Italic
import au.com.redmonk.resources.OpenSans_Light
import au.com.redmonk.resources.OpenSans_Regular
import au.com.redmonk.resources.OpenSans_Semibold
import au.com.redmonk.resources.Res
import org.jetbrains.compose.resources.Font


@Composable
fun customFontFamily() = FontFamily(
    Font(
        resource = Res.font.OpenSans_ExtraBold,
        weight = FontWeight.ExtraBold,
        style = FontStyle.Normal
    ),
    Font(
        resource = Res.font.OpenSans_Bold,
        weight = FontWeight.Bold,
        style = FontStyle.Normal
    ),
    Font(
        resource = Res.font.OpenSans_Regular,
        weight = FontWeight.Normal,
        style = FontStyle.Normal
    ),
    Font(
        resource = Res.font.OpenSans_Semibold,
        weight = FontWeight.SemiBold,
        style = FontStyle.Normal
    ),
    Font(
        resource = Res.font.OpenSans_Light,
        weight = FontWeight.Light,
        style = FontStyle.Normal
    ),
    Font(
        resource = Res.font.OpenSans_Italic,
        weight = FontWeight.Medium,
        style = FontStyle.Italic
    ),

    )

@Composable
fun customTypoGraphy() = Typography().run {
    val fontFamily = customFontFamily()
    copy(
        h1 = h1.copy(fontFamily = fontFamily, fontSize = 36.sp, lineHeight = 80.sp, fontWeight = FontWeight.Bold),
        h2 = h2.copy(fontFamily = fontFamily, fontSize = 28.sp,lineHeight = 48.sp, fontWeight = FontWeight.Bold),
        h3 = h3.copy(fontFamily = fontFamily, fontSize = 24.sp,lineHeight = 32.sp, fontWeight = FontWeight.Bold),
        h4 = h4.copy(fontFamily = fontFamily, fontSize = 20.sp, fontWeight = FontWeight.Bold),
        h5 = h5.copy(fontFamily = fontFamily, fontSize = 18.sp, fontWeight = FontWeight.Bold),
        h6 = h6.copy(fontFamily = fontFamily, fontSize = 16.sp, fontWeight = FontWeight.Bold),
        subtitle1 = subtitle1.copy(
            fontFamily = fontFamily,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        ),
        subtitle2 = subtitle2.copy(
            fontFamily = fontFamily,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        ),
        body1 = body1.copy(
            fontFamily = fontFamily,
            fontSize = 16.sp,
            lineHeight = 16.sp,
            fontWeight = FontWeight.Medium
        ),
        body2 = body2.copy(
            fontFamily = fontFamily,
            fontSize = 18.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight.Medium
        ),
        button = button.copy(fontFamily = fontFamily),
        caption = subtitle2.copy(
            fontFamily = fontFamily,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Italic
        ),
        overline = overline.copy(fontFamily = fontFamily)
    )
}
