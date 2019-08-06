package com.example.newsapplication.main.newslist

import com.example.newsapplication.main.entities.Article
import com.example.newsapplication.main.entities.News
import io.reactivex.Single

interface NewsRepository {
    fun getNews(): Single<News>
    fun getArticlesFromDatabase(): Single<List<Article>>
    fun setArticles(articles: List<Article>): Single<List<Long>>
}
