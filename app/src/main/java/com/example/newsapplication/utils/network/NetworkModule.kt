package com.example.newsapplication.utils.network

import com.example.newsapplication.BuildConfig
import com.example.newsapplication.app.BaseApplication
import com.example.newsapplication.utils.dagger.DaggerScope
import com.example.newsapplication.utils.scheduler.IOScheduler
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
abstract class NetworkModule private constructor() {
    @Module
    companion object {
        @Provides
        @JvmStatic
        @DaggerScope(BaseApplication::class)
        fun provideApi(client: OkHttpClient, @IOScheduler scheduler: Scheduler): NewsApi = Retrofit.Builder()
            .baseUrl(BuildConfig.NEWS_API)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(NewsApi::class.java)

        @Provides
        @JvmStatic
        @DaggerScope(BaseApplication::class)
        fun provideOkHttp(): OkHttpClient {
            return OkHttpClient.Builder()
                    .build()
        }

        @Provides
        @JvmStatic
        @DaggerScope(BaseApplication::class)
        fun provideGson(): Gson = Gson()
    }
}