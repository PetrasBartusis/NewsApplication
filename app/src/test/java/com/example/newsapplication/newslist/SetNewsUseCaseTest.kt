package com.example.newsapplication.newslist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.newsapplication.main.newslist.NewsRepository
import com.example.newsapplication.main.newslist.usecases.SetNewsUseCase
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class SetNewsUseCaseTest {
    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    private lateinit var setNewsUseCase: SetNewsUseCase
    private val newsRepository: NewsRepository = mock()

    @Before
    fun setUp() {
        setNewsUseCase = SetNewsUseCase(
            newsRepository
        )
    }

    @Test
    fun setArticles_setArticlesSuccess() {
        given(newsRepository.setArticles(ArticlesMock.articles)).willReturn(
            Single.just(ArticlesMock.articles.map { it.hashCode().toLong() })
        )

        setNewsUseCase.setArticles(ArticlesMock.articles)
            .test()
            .assertResult(ArticlesMock.articles.map { it.hashCode().toLong() })
            .assertComplete()
    }

    @Test
    fun setArticles_setArticlesError() {
        val error = Exception("test error")
        given(newsRepository.setArticles(ArticlesMock.articles)).willReturn(
            Single.error(error)
        )

        setNewsUseCase.setArticles(ArticlesMock.articles)
            .test()
            .assertError(error)
    }
}