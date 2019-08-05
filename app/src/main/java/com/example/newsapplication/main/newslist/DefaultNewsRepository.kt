package com.example.newsapplication.main.newslist

import com.example.newsapplication.main.entities.News
import io.reactivex.Single
import javax.inject.Inject

class DefaultNewsRepository @Inject constructor(
    private val newsDao: NewsDao
) : NewsRepository {
    override fun getNews(): Single<News> = newsDao.getNews()
}