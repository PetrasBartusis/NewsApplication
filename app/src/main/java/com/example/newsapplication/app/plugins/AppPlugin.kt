package com.example.newsapplication.app.plugins

import android.content.Context

interface AppPlugin {
    val priority get() = Int.MAX_VALUE
    fun initialize(context: Context)
}