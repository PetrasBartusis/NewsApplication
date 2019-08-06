package com.example.newsapplication.utils.factory

import com.example.newsapplication.main.entities.Article
import com.example.newsapplication.main.entities.News
import com.example.newsapplication.main.entities.Source
import com.example.newsapplication.utils.storage.entities.DatabaseArticle
import javax.inject.Inject

class ArticleFactory @Inject constructor() {
    fun getDatabaseArticles(articles: List<Article>): List<DatabaseArticle> {
        return articles.map {
            DatabaseArticle(
                author = it.author,
                title = it.title,
                description = it.description,
                url = it.url,
                urlToImage = it.urlToImage,
                publishedAt = it.publishedAt,
                sourceName = it.source.name
            )
        }
    }

    fun getArticles(articles: List<DatabaseArticle>): List<Article> {
        return articles.map {
            Article(
                author = it.author,
                title = it.title,
                description = it.description ?: "",
                url = it.url,
                urlToImage = it.urlToImage,
                publishedAt = it.publishedAt,
                source = Source(
                    id = "",
                    name = it.sourceName
                )
            )
        }
    }
}