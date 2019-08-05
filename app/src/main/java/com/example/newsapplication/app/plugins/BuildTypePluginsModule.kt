package com.example.newsapplication.app.plugins

import dagger.Binds
import dagger.multibindings.IntoSet

@dagger.Module
abstract class BuildTypePluginsModule private constructor() {
    @Binds
    @IntoSet
    abstract fun bindTimberPlugin(plugin: TimberPlugin): AppPlugin
}