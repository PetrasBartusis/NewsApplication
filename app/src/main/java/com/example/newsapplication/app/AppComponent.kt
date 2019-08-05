package com.example.newsapplication.app

import com.example.newsapplication.app.plugins.BuildTypePluginsModule
import com.example.newsapplication.utils.activity.ActivitiesModule
import com.example.newsapplication.utils.dagger.DaggerScope
import com.example.newsapplication.utils.scheduler.SchedulerModule
import com.example.newsapplication.utils.viewmodel.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@DaggerScope(BaseApplication::class)
@Component(
    modules = [
        AppModule::class,
        BuildTypePluginsModule::class,
        ViewModelModule::class,
        SchedulerModule::class,
        ActivitiesModule::class,
        AndroidSupportInjectionModule::class
    ]
)
interface AppComponent : AndroidInjector<BaseApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<BaseApplication>()
}