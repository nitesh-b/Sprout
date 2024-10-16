package nativemodules

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


actual fun timeStampToDate(ts: Long, regex: String): String {
    val millisecondsEnsured = if (ts.toString().length == 10) ts * 1000 else ts
    val actualDateTime = Date(millisecondsEnsured)
    return SimpleDateFormat(regex, Locale.US).format(actualDateTime)
}