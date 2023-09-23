//package com.shegs.miragefood.utils
//
//import java.text.SimpleDateFormat
//import java.util.Locale
//
//fun convertTimestampToTime(timestamp: String): String {
//    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ", Locale.US)
//    val inputFormatWithMillis = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ", Locale.US)
//
//    try {
//        val date = inputFormat.parse(timestamp)
//        return SimpleDateFormat("h:mma", Locale.US).format(date!!)
//    } catch (e: java.text.ParseException) {
//        // Parsing failed with the original format, try with optional milliseconds
//        return try {
//            val date = inputFormatWithMillis.parse(timestamp)
//            SimpleDateFormat("h:mma", Locale.US).format(date!!)
//        } catch (e: java.text.ParseException) {
//            // Handle parsing error as needed
//            e.printStackTrace()
//            ""
//        }
//    }
//}
//
//fun formatTimestampToRelativeDate(timestamp: String): String {
//
//
//    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ", Locale.US)
//    val outputFormat = SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault()).format(inputFormat)
//    val date = inputFormat.parse(timestamp)
//    return outputFormat.format(date!!)
//
////    val currentDateFormatted =
////        SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault()).format(currentDateTime)
//
//}
