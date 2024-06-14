package com.example.calendar.util.extension

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone


fun Long.toBrazilianDateFormat(pattern: String = "dd/MM/yyyy", language: String = "pt-br", timeZoneId: String = "GMT"): String {
    val date = Date(this)
    val formatter = SimpleDateFormat(
        pattern, Locale(language)
    ).apply {
        timeZone = TimeZone.getTimeZone(timeZoneId)
    }
    return formatter.format(date)
}