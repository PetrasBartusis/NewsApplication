package com.example.newsapplication.utils.dateformatter

import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class DateFormatter @Inject constructor() {
    private val dateTimeFormat = SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.getDefault())
    private val startingFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())

    fun getDateTimeFromDateString(dateToFormat: String): String? {
        if(dateToFormat.isNotEmpty()){
            val date = startingFormat.parse(dateToFormat)
            return dateTimeFormat.format(date)
        }
        return ""
    }
}