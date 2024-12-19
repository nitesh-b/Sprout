import androidx.compose.runtime.Composable

expect fun isIOS(): Boolean
expect fun isAndroid(): Boolean

@Composable
expect fun isLandscape(): Boolean
