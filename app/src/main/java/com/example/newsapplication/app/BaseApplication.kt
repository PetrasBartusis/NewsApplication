package com.example.newsapplication.app

import android.app.Application
import com.example.newsapplication.app.plugins.AppPlugin
import timber.log.Timber
import javax.inject.Inject

class BaseApplication : Application() {
    @Inject
    fun initialize(
        plugins: Set<@JvmSuppressWildcards AppPlugin>
    ) {
        plugins.sortedBy { it.priority }.forEach { plugin ->
            Timber.d("Initializing: ${plugin::class.java.simpleName}")
            plugin.initialize(this)
        }
    }
}