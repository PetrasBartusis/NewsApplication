package com.example.newsapplication.utils.storage

import com.example.newsapplication.utils.scheduler.IOScheduler
import com.example.newsapplication.utils.storage.daos.NewsDao
import com.example.newsapplication.utils.storage.entities.DatabaseArticle
import io.reactivex.Scheduler
import javax.inject.Inject

class NewsDataSource @Inject constructor(
    private val newsDao: NewsDao,
    @IOScheduler private val scheduler: Scheduler
) {
    fun setNews(articles: List<DatabaseArticle>) = newsDao.dropTable()
        .flatMap {
            newsDao.insertAll(articles)
        }.subscribeOn(scheduler)

    fun getNews() = newsDao.getArticles().subscribeOn(scheduler)
}