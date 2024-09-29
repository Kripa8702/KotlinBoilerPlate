package com.boilerplate.kotlin.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class DateFormatter {
    companion object {
        fun formatDate(date: String): String {
            val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val outputFormat = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault())
            val formattedDate = inputFormat.parse(date) ?: return "Invalid date"

            return outputFormat.format(formattedDate)
        }

        fun formatTime(time: String): String {
            val inputFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
            val outputFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())
            val formattedTime = inputFormat.parse(time) ?: return "Invalid time"

            return outputFormat.format(formattedTime)
        }

        fun formatDateFromMilliseconds(milliseconds: Long): String {
            val outputFormat = SimpleDateFormat("EEEE, dd MMMM", Locale.getDefault())

            val calendar = Calendar.getInstance()
            calendar.timeInMillis = milliseconds

            return outputFormat.format(calendar.time)
        }

        // format date to MM-dd-yyyy
        fun formatDateToMMddyyyy(milliseconds: Long): String {
            val outputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

            val calendar = Calendar.getInstance()
            calendar.timeInMillis = milliseconds

            return outputFormat.format(calendar.time)
        }

        /// format date to dd MMMM yyyy
        fun formatDateToddMMMyyyy(milliseconds: Long): String {
            val outputFormat = SimpleDateFormat("dd MMM, yyyy", Locale.getDefault())

            val calendar = Calendar.getInstance()
            calendar.timeInMillis = milliseconds

            return outputFormat.format(calendar.time)
        }

        @SuppressLint("DefaultLocale")
        fun Int.formatTime(): String {
            val minutes = this / 60
            val remainingSeconds = this % 60

            return String.format("%02d:%02d", minutes, remainingSeconds)
        }

    }
}