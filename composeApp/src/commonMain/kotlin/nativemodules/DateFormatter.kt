package nativemodules

expect fun timeStampToDate(ts: Long, regex: String = "dd MMM, yyyy h:mma"): String