package com.example.newsapplication.app.plugins

import android.content.Context
import timber.log.Timber
import javax.inject.Inject

class TimberPlugin @Inject constructor() : AppPlugin {
    override val priority = 0

    override fun initialize(context: Context) {
        val handler = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
            Timber.d(throwable)
            handler.uncaughtException(thread, throwable)
        }
        Timber.plant(Timber.DebugTree())
    }
}