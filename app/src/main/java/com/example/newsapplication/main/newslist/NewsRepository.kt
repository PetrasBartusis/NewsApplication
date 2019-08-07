package com.example.newsapplication.main.newslist

import com.example.newsapplication.main.entities.Article
import io.reactivex.Observable
import io.reactivex.Single

interface NewsRepository {
    fun getArticlesList(): Observable<List<Article>>
    fun getArticlesFromDatabase(): Observable<List<Article>>
    fun setArticles(articles: List<Article>): Single<List<Long>>
}
