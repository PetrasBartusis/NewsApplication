package com.example.newsapplication.utils.network

import com.example.newsapplication.BuildConfig
import com.example.newsapplication.main.entities.News
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("top-headlines")
    fun getNews(
            @Query("country") country: String = "us",
            @Query("apiKey") key : String = BuildConfig.NEWS_API_KEY
    ): Single<News>
}