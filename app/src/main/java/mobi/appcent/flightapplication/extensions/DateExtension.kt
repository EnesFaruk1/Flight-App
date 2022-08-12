package mobi.appcent.flightapplication.extensions

import java.text.SimpleDateFormat
import java.util.*

fun formatDate(date: String,format: String): String {
    val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZ", Locale.ENGLISH).parse(date)
    val formattedDate = SimpleDateFormat(format, Locale.ENGLISH)
    return (formattedDate.format(date.time))
}