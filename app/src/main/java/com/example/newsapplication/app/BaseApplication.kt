package com.example.newsapplication.app

import com.example.newsapplication.app.plugins.AppPlugin
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber
import javax.inject.Inject

class BaseApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder().create(this)

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