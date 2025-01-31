import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.booleanResource
import au.com.redmonk.R

actual fun isIOS(): Boolean {
    return false
}

actual fun isAndroid(): Boolean {
    return true
}

@Composable
actual fun isTablet(): Boolean {
    return booleanResource(R.bool.is_tablet)
}


@Composable
actual fun isLandscape(): Boolean {
    val configuration = LocalConfiguration.current
    return (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)

}



