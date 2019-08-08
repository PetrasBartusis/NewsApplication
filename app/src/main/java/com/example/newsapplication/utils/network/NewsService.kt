package com.example.newsapplication.utils.network

import com.example.newsapplication.main.entities.Article
import com.example.newsapplication.utils.scheduler.IOScheduler
import io.reactivex.Observable
import io.reactivex.Scheduler
import javax.inject.Inject

class NewsService @Inject constructor(
    private val newsApi: NewsApi,
    @IOScheduler private val sheduler: Scheduler
) {
    fun getNews(): Observable<List<Article>> = newsApi.getNews().map { it.articles }.subscribeOn(sheduler)
}
