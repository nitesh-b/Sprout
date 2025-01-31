package utils

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color


//Colors
val shadow_gray = Color(0xFF3E403E)
val charcoal = Color(0xFF2F302F)
val green = Color(0xFF00FF00)

val tertiary = Color(0xFFF4B7A1) // muted coral
val textColor = Color(0xFF2E3D49) // dark slate gray
val background_complimentary = Color(0xFFF2E0E9) // light pink

val primary = Color(0xFFA1A69F) // Soft Sage
val secondary = Color(0xFFBFCFBB) // Misty Green
val primaryVariant = Color(0xFF8EA58C) // Classic Sage
val secondaryVariant = Color(0xFF738A6E) // Moss Green
val background = Color(0xFFF2F3F1) // Ivory (Neutral backdrop)
val surface = Color(0xFFF2F3F1) // Same as background for consistency
val error = Color(0xFFD8959B) // Mauve (Soft pink for subtle error indication)
val onPrimary = Color(0xFF344C3D) // Evergreen (Dark contrast for text)
val onSecondary = Color(0xFF344C3D) // Evergreen
val onBackground = Color(0xFF344C3D) // Evergreen
val onSurface = Color(0xFF344C3D) // Evergreen
val onError = Color(0xFF344C3D) // Evergreen


val navBarColor = primary //warm yellow
val primaryButtonBackground = secondaryVariant
val secondaryButtonBackground = secondary
val primaryButtonTextColor = onPrimary
val secondaryButtonTextColor = onSecondary
val divider = secondary
//val


//gradents
val gradient_kashmir = Brush.verticalGradient(listOf(Color(0xFF614385), Color(0xFF516395)))
val gradient_background = Brush.verticalGradient(listOf(primary, secondary))
val gradient_green_beach = Brush.verticalGradient(listOf(Color(0xFF02AABD), Color(0xFF00CDAC)))
val gradient_bnw = Brush.verticalGradient(listOf(Color(0x80000000), Color.Transparent))
val gradient_transparent = Brush.verticalGradient(listOf(Color.Transparent, Color.Transparent))


val baseColors = Colors(
    primary = primary,
    secondary = secondary,
    primaryVariant = primaryVariant,
    secondaryVariant = secondaryVariant,
    background = background,
    surface = surface,
    error = error,
    onPrimary = onPrimary,
    onSecondary = onSecondary,
    onBackground = onBackground,
    onSurface = onSurface,
    onError = onError,
    isLight = true
)