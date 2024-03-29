package com.example.newsapplication.utils.dateformatter

import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class DateFormatter @Inject constructor() {
    private val dateTimeFormat = SimpleDateFormat("yyyy-MMMM-dd HH:mm", Locale.getDefault())
    private val startingFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())

    fun getDateTimeFromDateString(dateToFormat: String): String? {
        if(dateToFormat.isNotEmpty() && dateToFormat.matchesStartingFormat()){
            val date = startingFormat.parse(dateToFormat)
            return dateTimeFormat.format(date)
        }
        return dateToFormat
    }

    private fun String.matchesStartingFormat(): Boolean {
        return this.matches(Regex("[0-9]{4}-[0-9]{2}-[0-9]{2}[A-z][0-9]{2}:[0-9]{2}:[0-9]{2}[A-z]"))
    }
}