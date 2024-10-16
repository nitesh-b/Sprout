package nativemodules

import platform.Foundation.NSDate
import platform.Foundation.NSDateFormatter
import platform.Foundation.dateWithTimeIntervalSince1970

actual fun timeStampToDate(ts: Long, regex: String): String {
    val millisecondsEnsured = if (ts.toString().length == 10) ts * 1000 else ts
    val dateFormatter = NSDateFormatter()
    dateFormatter.dateFormat = regex
    val date = NSDate.dateWithTimeIntervalSince1970(millisecondsEnsured / 1000.0)
    return dateFormatter.stringFromDate(date)
}