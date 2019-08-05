package com.example.newsapplication.app

import android.content.Context
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule private constructor() {
    @Binds
    abstract fun bindContext(baseApplication: BaseApplication): Context
}