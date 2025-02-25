import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import components.DebugColorPaletteView
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import utils.baseColors
import utils.customTypoGraphy


@Composable
fun App() {

    var currentPage by remember { mutableStateOf(0) }
    Napier.base(DebugAntilog())

    MaterialTheme(typography = customTypoGraphy(), colors = baseColors) {
        MainNavigation()
        DebugColorPaletteView()
//        OnboardingScreen {
//            currentPage = 1
//        }
//        when (currentPage) {
//            1 -> {
//                MainNavigation()
//            }
//
//        }
    }
}
