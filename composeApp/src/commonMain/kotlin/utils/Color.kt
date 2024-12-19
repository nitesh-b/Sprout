package utils

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color


//Colors
val shadow_gray = Color(0xFF3E403E)
val charcoal = Color(0xFF2F302F)
val green = Color(0xFF00FF00)

val primary = Color(0xFFA8D5BA) // soft green
val secondary = Color(0xFFB2E4D5) // light teal
val tertiary = Color(0xFFF4B7A1) // muted coral
val warm_yellow = Color(0xFFfbde9d) //warm yellow
val textColor = Color(0xFF2E3D49) // dark slate gray
val background = Color(0xFFE0F2E9) // light gray
val background_complimentary = Color(0xFFF2E0E9) // light pink


//gradents
val gradient_kashmir = Brush.verticalGradient(listOf(Color(0xFF614385), Color(0xFF516395)))
val gradient_background = Brush.verticalGradient(listOf(primary, secondary))
val gradient_green_beach = Brush.verticalGradient(listOf(Color(0xFF02AABD), Color(0xFF00CDAC)))
val gradient_bnw = Brush.verticalGradient(listOf(Color(0x80000000), Color.Transparent))
val gradient_transparent = Brush.verticalGradient(listOf(Color.Transparent, Color.Transparent))


val baseColors = Colors(
    primary = primary,
    secondary = secondary,
    primaryVariant = primary,
    secondaryVariant = secondary,
    background = background,
    surface = background,
    error = tertiary,
    onPrimary = textColor,
    onSecondary = textColor,
    onBackground = textColor,
    onSurface = textColor,
    onError = textColor,
    isLight = true
)