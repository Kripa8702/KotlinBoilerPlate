package com.boilerplate.kotlin.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class DateFormatter {
    companion object {
        fun formatDateFromString(
            date: String,
            format: String = "EEEE, dd MMM yyyy",
        ): String {
            try {
                val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

                val outputFormat = SimpleDateFormat(format, Locale.getDefault())
                val formattedDate = inputFormat.parse(date) ?: return "Invalid date"

                return outputFormat.format(formattedDate)
            } catch (e: Exception) {
                return date
            }
        }

        fun formatTime(time: String): String {
            val inputFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
            val outputFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())
            val formattedTime = inputFormat.parse(time) ?: return "Invalid time"

            return outputFormat.format(formattedTime)
        }

        fun formatDateFromMilliseconds(
            milliseconds: Long,
            format: String = "EEEE, dd MMM yyyy",
        ): String {
            val outputFormat = SimpleDateFormat(format, Locale.getDefault())

            val calendar = Calendar.getInstance()
            calendar.timeInMillis = milliseconds

            return outputFormat.format(calendar.time)
        }

        //  Format time to mm:ss

        @SuppressLint("DefaultLocale")
        fun Int.formatTime(): String {
            val minutes = this / 60
            val remainingSeconds = this % 60

            return String.format("%02d:%02d", minutes, remainingSeconds)
        }

    }
}