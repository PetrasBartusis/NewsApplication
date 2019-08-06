package com.example.newsapplication.main.newslist

import com.example.newsapplication.main.entities.News
import com.example.newsapplication.utils.factory.ArticleFactory
import com.example.newsapplication.utils.network.NewsService
import com.example.newsapplication.utils.storage.NewsDataSource
import io.reactivex.Single
import javax.inject.Inject

class DefaultNewsRepository @Inject constructor(
    private val newsService: NewsService,
    private val newsDataSource: NewsDataSource,
    private val articleFactory: ArticleFactory
) : NewsRepository {
    override fun getNews(): Single<News> {
        return newsService.getNews()
    }

    override fun setNews(news: News) = newsDataSource.setNews(
        articleFactory.getDatabaseArticles(news)
    )
}