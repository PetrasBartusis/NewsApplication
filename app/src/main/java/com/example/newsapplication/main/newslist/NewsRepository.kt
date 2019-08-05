package com.example.newsapplication.main.newslist

import com.example.newsapplication.main.entities.News
import io.reactivex.Single

interface NewsRepository {
    fun getNews(): Single<News>
}
