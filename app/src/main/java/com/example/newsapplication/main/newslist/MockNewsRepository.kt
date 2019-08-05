package com.example.newsapplication.main.newslist

import com.example.newsapplication.main.entities.Article
import com.example.newsapplication.main.entities.News
import com.example.newsapplication.main.entities.Source
import io.reactivex.Single
import java.net.URL

class MockNewsRepository : NewsRepository {
    override fun getNews(): Single<News> {
        return Single.just(
                News(
                        status = "Test",
                        articles = listOf(
                                Article(
                                        source = Source(
                                                id = "1",
                                                name = "Interesting Source"
                                        ),
                                        author = "Benjamin Franklin",
                                        description = "Electricity master",
                                        title = "Storm",
                                        publishedAt = "1755",
                                        url = URL(""),
                                        urlToImage = null
                                )
                        ),
                        totalResults = 1
                )
        )
    }

}