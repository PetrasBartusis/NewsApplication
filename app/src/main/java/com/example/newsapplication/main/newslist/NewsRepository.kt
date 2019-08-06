package com.example.newsapplication.main.newslist

import com.example.newsapplication.main.entities.News
import io.reactivex.Single

interface NewsRepository {
    fun getNews(): Single<News>
    fun setNews(news: News): Single<List<Long>>
}
