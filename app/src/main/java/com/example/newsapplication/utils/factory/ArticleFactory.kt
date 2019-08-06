package com.example.newsapplication.utils.factory

import com.example.newsapplication.main.entities.News
import com.example.newsapplication.utils.storage.entities.DatabaseArticle
import javax.inject.Inject

class ArticleFactory @Inject constructor() {
    fun getDatabaseArticles(news: News): List<DatabaseArticle> {
        return news.articles.map {
            DatabaseArticle(
                author = it.author,
                title = it.title,
                description = it.description,
                url = it.url.toString(),
                urlToImage = it.urlToImage.toString(),
                publishedAt = it.publishedAt,
                sourceName = it.source.name
            )
        }
    }
}