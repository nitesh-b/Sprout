import androidx.compose.runtime.Composable
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.useContents
import platform.UIKit.UIDevice
import platform.UIKit.UIScreen
import platform.UIKit.UIUserInterfaceIdiomPad

actual fun isIOS(): Boolean {
    return true
}

actual fun isAndroid(): Boolean {
    return false
}

@Composable
actual fun isTablet(): Boolean {
    return (UIDevice.currentDevice.userInterfaceIdiom == UIUserInterfaceIdiomPad)
}

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun isLandscape(): Boolean {
    val screenBounds = UIScreen.mainScreen.bounds.useContents { size }
    return (screenBounds.width > screenBounds.height)
}

