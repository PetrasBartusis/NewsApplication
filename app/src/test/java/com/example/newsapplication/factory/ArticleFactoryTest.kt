package com.example.newsapplication.factory

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.newsapplication.newslist.ArticlesMock
import com.example.newsapplication.utils.factory.ArticleFactory
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class ArticleFactoryTest {
    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    private val articleFactory = ArticleFactory()

    @Test
    fun transformTo_TransformBack_Success() {
        val articles = ArticlesMock.articles

        val databaseArticles = articleFactory.getDatabaseArticles(articles)
        val result = articleFactory.getArticles(databaseArticles)

        assert(articles == result)
    }
}