package components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import io.github.aakira.napier.Napier
import utils.baseColors

@Composable
fun DebugColorPaletteView() {
    // Define your color palette with roles and HEX values
    val colorPalette = listOf(
        "Primary" to baseColors.primary,           // Soft Sage
        "Secondary" to baseColors.secondary,         // Misty Green
        "PVariant" to baseColors.primaryVariant,   // Classic Sage
        "SVariant" to baseColors.secondaryVariant, // Moss Green
        "Background" to baseColors.background,        // Ivory
        "Error" to baseColors.error,             // Mauve (Error)
        "OPrimary" to baseColors.onPrimary, // Evergreen (Text)
        "OSec" to baseColors.onSecondary, // Evergreen (Text)
        "White" to Color(0xFFFFFFFF)              // White (Optional)
    )

    // Create a grid-like layout for the color boxes


    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        colorPalette.forEach { rowColors ->
            ColorBox(
                modifier = Modifier.weight(1f),
                role = rowColors.first,
                color = rowColors.second
            ) {
                Napier.d(rowColors.first)
            }
        }
    }

}

@Composable
fun ColorBox(modifier: Modifier, role: String, color: Color, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .height(40.dp)
            .background(color, shape = RoundedCornerShape(8.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = role,
            preset = TextType.SUBTITLE1,
            color = if (color.luminance() > 0.5) Color.Black else Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp)
        )
    }
}

// Extension function to convert a `Color` to a HEX string.
fun Color.toHexString(): String {
    return "Red: ${(red * 255).toInt()},\nGreen: ${(green * 255).toInt()},\nBlue: ${(blue * 255).toInt()}"
}