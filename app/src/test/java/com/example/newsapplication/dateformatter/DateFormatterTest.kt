package com.example.newsapplication.dateformatter

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.newsapplication.utils.dateformatter.DateFormatter
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class DateFormatterTest {
    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    private val dateFormatter = DateFormatter()

    @Test
    fun formatDate_CorrectFormat() {
        val input = "2019-08-07T11:41:00Z"
        val expectedResult = "2019-August-07 11:41"

        val result = dateFormatter.getDateTimeFromDateString(input)

        assert(result == expectedResult)
    }

    @Test
    fun formatDate_IncorrectFormat() {
        val input = "2019/08/07T11:41:00Z"
        val expectedResult = "2019-August-07 11:41"

        val result = dateFormatter.getDateTimeFromDateString(input)

        assert(result != expectedResult)
    }

    @Test
    fun formatDate_isEmpty() {
        val input = ""

        val result = dateFormatter.getDateTimeFromDateString(input)

        assert(result == input)
    }
}