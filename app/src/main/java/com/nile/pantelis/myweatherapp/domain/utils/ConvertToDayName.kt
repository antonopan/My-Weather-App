package com.nile.pantelis.myweatherapp.domain.utils

import androidx.compose.ui.text.TextStyle
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.DayOfWeek
import java.time.LocalDate
import java.util.Locale

fun convertToDayName(dateTime: String): String {
    // Define the formatter for the input date-time string
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")

    // Parse the input string to LocalDateTime
    val dateTimeParsed = LocalDateTime.parse(dateTime, formatter)

    // Get the day of the week (e.g., "Monday", "Tuesday", etc.)
    val dayOfWeek = dateTimeParsed.dayOfWeek

    // Return the day name in full (e.g., "Monday")
    return dayOfWeek.getDisplayName(java.time.format.TextStyle.FULL, Locale.getDefault())
}


fun convertDateToDayName(dateTime: String): String {
    // Define the date-only pattern
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    // Parse the input string to LocalDate
    val dateParsed = LocalDate.parse(dateTime, formatter)

    // Get the day of the week
    val dayOfWeek = dateParsed.dayOfWeek

    // Return the full name of the day
    return dayOfWeek.getDisplayName(java.time.format.TextStyle.FULL, Locale.getDefault())
}