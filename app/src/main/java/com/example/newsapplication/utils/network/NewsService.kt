package com.example.newsapplication.utils.network

import com.example.newsapplication.main.entities.Article
import com.example.newsapplication.utils.scheduler.IOScheduler
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

class NewsService @Inject constructor(
    private val newsApi: NewsApi,
    @IOScheduler private val sheduler: Scheduler
) {
    fun getNews(): Single<List<Article>> = newsApi.getNews().map { it.articles }.subscribeOn(sheduler)
}
