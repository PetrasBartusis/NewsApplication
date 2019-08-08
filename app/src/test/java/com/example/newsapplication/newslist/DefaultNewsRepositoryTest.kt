package com.example.newsapplication.newslist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.newsapplication.main.newslist.DefaultNewsRepository
import com.example.newsapplication.utils.factory.ArticleFactory
import com.example.newsapplication.utils.network.NewsService
import com.example.newsapplication.utils.storage.NewsDataSource
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Observable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.BDDMockito.given
import java.lang.Exception

class DefaultNewsRepositoryTest {
    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    private lateinit var defaultNewsRepository: DefaultNewsRepository
    private val newsService: NewsService = mock()
    private val newsDataSource: NewsDataSource = mock()
    private val articleFactory: ArticleFactory = mock()
    private val realArticleFactory: ArticleFactory = ArticleFactory()

    @Before
    fun setUp() {
        defaultNewsRepository = DefaultNewsRepository(
            newsService = newsService,
            newsDataSource = newsDataSource,
            articleFactory = articleFactory
        )
    }

    @Test
    fun getArticlesList_getArticlesListSuccess() {
        given(newsService.getNews()).willReturn(
            Observable.just(ArticlesMock.articles)
        )

        defaultNewsRepository.getArticlesList()
            .test()
            .assertResult(ArticlesMock.articles)
            .assertComplete()
    }

    @Test
    fun getArticlesList_getArticlesListError() {
        val error = Exception("test error")
        given(newsService.getNews()).willReturn(
            Observable.error(error)
        )

        defaultNewsRepository.getArticlesList()
            .test()
            .assertError(error)
    }

    @Test
    fun getArticlesFromDatabase_getArticlesFromDatabaseSuccess() {
        given(newsDataSource.getNews()).willReturn(
            Observable.just(realArticleFactory.getDatabaseArticles(ArticlesMock.articles))
        )
        given(
            articleFactory.getArticles(
                realArticleFactory.getDatabaseArticles(
                    ArticlesMock.articles
                )
            )
        ).willReturn(
            ArticlesMock.articles
        )

        defaultNewsRepository.getArticlesFromDatabase()
            .test()
            .assertResult(ArticlesMock.articles)
            .assertComplete()
    }

    @Test
    fun getArticlesFromDatabase_getArticlesFromDatabaseError() {
        val error = Exception("test error")
        given(newsDataSource.getNews()).willReturn(
            Observable.error(error)
        )

        defaultNewsRepository.getArticlesFromDatabase()
            .test()
            .assertError(error)
    }
}