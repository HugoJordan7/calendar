package com.example.calendar.util.extension

import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

fun String.toDateInMillis(pattern: String = "dd/MM/yyyy"): Long {
    val formatter = SimpleDateFormat(pattern, Locale("pt-br")).apply {
        timeZone = TimeZone.getTimeZone("GMT")
    }
    val date = formatter.parse(this)
    return date?.time ?: 0L
}