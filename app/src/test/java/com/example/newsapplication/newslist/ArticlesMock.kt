package com.example.newsapplication.newslist

import com.example.newsapplication.main.entities.Article
import com.example.newsapplication.main.entities.Source

class ArticlesMock {
    companion object {
        private val article1 = Article(
            source = Source(
                id = "",
                name = "source name 1"
            ),
            title = "title 1",
            description = "description 1",
            author = "author 1",
            urlToImage = "/url/1",
            publishedAt = "2019-08-06 10:34",
            url = "/url/1"
        )
        private val article2 = Article(
            source = Source(
                id = "",
                name = "source name 2"
            ),
            title = "title 2",
            description = "description 2",
            author = "author 2",
            urlToImage = "/url/2",
            publishedAt = "2019-08-06 10:34",
            url = "/url/2"
        )
        private val article3 = Article(
            source = Source(
                id = "",
                name = "source name 3"
            ),
            title = "title 3",
            description = "description 3",
            author = "author 3",
            urlToImage = "/url/3",
            publishedAt = "2019-08-06 10:34",
            url = "/url/3"
        )

        val articles = listOf(article1, article2, article3)
    }
}