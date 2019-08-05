package com.example.newsapplication.utils.activity

import com.example.newsapplication.main.MainActivity
import com.example.newsapplication.main.MainModule
import com.example.newsapplication.utils.dagger.DaggerScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule private constructor() {
    @DaggerScope(MainActivity::class)
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun contributeMainActivity(): MainActivity
}