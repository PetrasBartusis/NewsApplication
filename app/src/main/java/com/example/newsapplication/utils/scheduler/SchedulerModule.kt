package com.example.newsapplication.utils.scheduler

import com.example.newsapplication.app.BaseApplication
import com.example.newsapplication.utils.dagger.DaggerScope
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@Module
abstract class SchedulerModule private constructor() {
    @Module
    companion object {
        @DaggerScope(BaseApplication::class)
        @MainScheduler
        @JvmStatic
        @Provides
        fun provideMainScheduler(): Scheduler = AndroidSchedulers.mainThread()

        @DaggerScope(BaseApplication::class)
        @ComputationScheduler
        @JvmStatic
        @Provides
        fun provideComputationScheduler(): Scheduler = Schedulers.computation()

        @DaggerScope(BaseApplication::class)
        @IOScheduler
        @JvmStatic
        @Provides
        fun provideIoScheduler(): Scheduler = Schedulers.io()
    }
}