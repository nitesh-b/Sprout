package utils

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.UtcOffset
import kotlinx.datetime.format.DateTimeComponents
import kotlinx.datetime.format.FormatStringsInDatetimeFormats
import kotlinx.datetime.format.byUnicodePattern
import kotlinx.datetime.format.format
import kotlinx.datetime.toLocalDateTime

class DateFormatter {
    companion object {
        fun timeStampToDate(timeStamp: Long): String {
            val formatPattern = "d MMM, yyyy h:mma"
            val instant: Instant = Instant.fromEpochSeconds(epochSeconds = timeStamp)
            val actualDate =
                instant.toLocalDateTime(TimeZone.currentSystemDefault())
            val formattedDate = DateTimeComponents.Formats.RFC_1123.format {
                // the receiver of this lambda is DateTimeComponents
                setDate(LocalDate(actualDate.year, actualDate.monthNumber, actualDate.dayOfMonth))
                hour = actualDate.time.hour
                minute = actualDate.time.minute
                second = actualDate.time.second
                setOffset(UtcOffset(hours = 0))
            } // Sat, 7 Jan 2023 23:59:60 +0200

            @OptIn(FormatStringsInDatetimeFormats::class)
            val dateTimeFormat = LocalDateTime.Format {
                byUnicodePattern(formatPattern)
            }
            val d = dateTimeFormat.parse(actualDate.toString())

            return d.toString()
        }

    }
}