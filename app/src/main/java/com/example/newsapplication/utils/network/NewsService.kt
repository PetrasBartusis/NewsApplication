package com.example.newsapplication.utils.network

import com.example.newsapplication.main.entities.News
import com.example.newsapplication.utils.scheduler.IOScheduler
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

class NewsService @Inject constructor(
    private val newsApi: NewsApi,
    @IOScheduler private val sheduler: Scheduler
) {
    fun getNews(): Single<News> = newsApi.getNews().subscribeOn(sheduler)
}
