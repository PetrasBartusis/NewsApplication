package com.example.newsapplication.main.newslist

import com.example.newsapplication.main.entities.News
import io.reactivex.Single

interface NewsListRepository {
    fun getNewsList(): Single<List<News>>
}
