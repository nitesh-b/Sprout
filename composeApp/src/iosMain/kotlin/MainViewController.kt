import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.window.ComposeUIViewController
import kotlinx.cinterop.ExperimentalForeignApi
import nl.marc_apps.tts.AudioSession

@OptIn(ExperimentalForeignApi::class)
fun MainViewController() = ComposeUIViewController {
    LaunchedEffect(Unit) {
        AudioSession.initialiseForTextToSpeech()
    }
    App()
}