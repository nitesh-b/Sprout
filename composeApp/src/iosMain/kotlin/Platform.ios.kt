import androidx.compose.runtime.Composable
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.useContents
import platform.UIKit.UIScreen

actual fun isIOS(): Boolean {
    return true
}

actual fun isAndroid(): Boolean {
    return false
}

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun isLandscape(): Boolean {
    val screenBounds = UIScreen.mainScreen.bounds.useContents { size }
    return (screenBounds.width > screenBounds.height)
}

