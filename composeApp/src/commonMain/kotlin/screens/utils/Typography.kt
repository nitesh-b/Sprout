package screens.utils

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import au.com.redmonk.resources.JosefinSans_Bold
import au.com.redmonk.resources.JosefinSans_Italic
import au.com.redmonk.resources.JosefinSans_Light
import au.com.redmonk.resources.JosefinSans_Regular
import au.com.redmonk.resources.JosefinSans_SemiBold
import au.com.redmonk.resources.Res
import org.jetbrains.compose.resources.Font


@Composable
fun customFontFamily() = FontFamily(
    Font(resource = Res.font.JosefinSans_Bold, weight = FontWeight.Bold, style = FontStyle.Normal),
    Font(
        resource = Res.font.JosefinSans_Regular,
        weight = FontWeight.Normal,
        style = FontStyle.Normal
    ),
    Font(
        resource = Res.font.JosefinSans_SemiBold,
        weight = FontWeight.SemiBold,
        style = FontStyle.Normal
    ),
    Font(
        resource = Res.font.JosefinSans_Light,
        weight = FontWeight.Light,
        style = FontStyle.Normal
    ),
    Font(
        resource = Res.font.JosefinSans_Italic,
        weight = FontWeight.Medium,
        style = FontStyle.Italic
    ),

    )

@Composable
fun customTypoGraphy() = Typography().run {
    val fontFamily = customFontFamily()
    copy(
        h1 = h1.copy(fontFamily = fontFamily, fontSize = 40.sp, fontWeight = FontWeight.Bold),
        h2 = h2.copy(fontFamily = fontFamily, fontSize = 36.sp, fontWeight = FontWeight.Bold),
        h3 = h3.copy(fontFamily = fontFamily, fontSize = 32.sp, fontWeight = FontWeight.Bold),
        h4 = h4.copy(fontFamily = fontFamily, fontSize = 28.sp, fontWeight = FontWeight.Bold),
        h5 = h5.copy(fontFamily = fontFamily, fontSize = 24.sp, fontWeight = FontWeight.Bold),
        h6 = h6.copy(fontFamily = fontFamily, fontSize = 22.sp, fontWeight = FontWeight.Bold),
        subtitle1 = subtitle1.copy(
            fontFamily = fontFamily,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        ),
        subtitle2 = subtitle2.copy(
            fontFamily = fontFamily,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        ),
        body1 = body1.copy(
            fontFamily = fontFamily,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        ),
        body2 = body2.copy(
            fontFamily = fontFamily,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        ),
        button = button.copy(fontFamily = fontFamily),
        caption = subtitle2.copy(
            fontFamily = fontFamily,
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Italic
        ),
        overline = overline.copy(fontFamily = fontFamily)
    )
}
