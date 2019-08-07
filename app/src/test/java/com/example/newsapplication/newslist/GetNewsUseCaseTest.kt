package com.example.newsapplication.newslist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.newsapplication.main.newslist.NewsRepository
import com.example.newsapplication.main.newslist.usecases.GetNewsUseCase
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Observable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class GetNewsUseCaseTest {
    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    private lateinit var getNewsUseCase: GetNewsUseCase
    private val newsRepository: NewsRepository = mock()

    @Before
    fun setUp() {
        getNewsUseCase = GetNewsUseCase(
            newsRepository
        )
    }

    @Test
    fun getNewsList_getArticlesSuccess() {
        given(newsRepository.getArticlesList()).willReturn(
            Observable.just(ArticlesMock.articles)
        )

        getNewsUseCase.getNewsList()
            .test()
            .assertComplete()
    }

    @Test
    fun getNewsList_getArticlesError() {
        val error = Exception("test error")
        given(newsRepository.getArticlesList()).willReturn(
            Observable.error(error)
        )

        getNewsUseCase.getNewsList()
            .test()
            .assertError(error)
    }

    @Test
    fun getArticlesDatabaseList_getArticlesSuccess() {
        given(newsRepository.getArticlesFromDatabase()).willReturn(
            Observable.just(ArticlesMock.articles)
        )

        getNewsUseCase.getArticles()
            .test()
            .assertComplete()
    }

    @Test
    fun getArticlesDatabaseList_getArticlesError() {
        val error = Exception("test error")
        given(newsRepository.getArticlesFromDatabase()).willReturn(
            Observable.error(error)
        )

        getNewsUseCase.getArticles()
            .test()
            .assertError(error)
    }
}