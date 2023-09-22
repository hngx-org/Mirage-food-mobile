package com.shegs.miragefood.utils

import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

fun convertTimestampToTime(timestamp: Long): String {
    // Convert the timestamp to LocalDateTime
    val dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault())

    // Create a DateTimeFormatter for the desired format
    val formatter = DateTimeFormatter.ofPattern("h:mma")

    // Format the LocalDateTime to the desired format
    return formatter.format(dateTime)
}

fun formatTimestampToRelativeDate(timestamp: Long): String {
    val currentTime = System.currentTimeMillis()
    val currentDateTime = Date(currentTime)
    val targetDateTime = Date(timestamp)

    val currentDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(currentDateTime)
    val targetDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(targetDateTime)

    val currentDateFormatted = SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault()).format(currentDateTime)

    return when {
        currentDate == targetDate -> "today"
        else -> currentDateFormatted
    }
}