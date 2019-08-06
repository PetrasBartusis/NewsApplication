package com.example.newsapplication.main.newslist

import com.example.newsapplication.main.entities.Article
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
    override fun getArticlesList(): Single<List<Article>> {
        return newsService.getNews()
    }

    override fun getArticlesFromDatabase(): Single<List<Article>> {
        return newsDataSource.getNews().map { databaseArticles ->
            articleFactory.getArticles(databaseArticles)
        }
    }

    override fun setArticles(articles: List<Article>) = newsDataSource.setNews(
        articleFactory.getDatabaseArticles(articles)
    )
}