package com.example.newsapplication.newslist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.newsapplication.main.entities.Article
import com.example.newsapplication.main.entities.Source
import com.example.newsapplication.main.newslist.NewsListViewModel
import com.example.newsapplication.main.newslist.usecases.GetNewsUseCase
import com.example.newsapplication.main.newslist.usecases.SetNewsUseCase
import com.jraska.livedata.test
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Observable
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class NewsListViewModelTest {
    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    private lateinit var newsListViewModel: NewsListViewModel
    private val getNewsUseCase: GetNewsUseCase = mock()
    private val setNewsUseCase: SetNewsUseCase = mock()

    @Before
    fun setUp() {
        newsListViewModel = NewsListViewModel(
            getNewsUseCase = getNewsUseCase,
            setNewsUseCase = setNewsUseCase
        )
    }

    @Test
    fun onCreated_loadInitialListInformation() {
        given(getNewsUseCase.getNewsList()).willReturn(
            Observable.just(ArticlesMock.articles)
        )
        given(setNewsUseCase.setArticles(ArticlesMock.articles)).willReturn(
            Single.just(listOf(0L))
        )

        newsListViewModel.onCreated()

        newsListViewModel.startRefreshing().test()
        newsListViewModel.getArticleList().test()
        newsListViewModel.stopRefreshing().test()
    }

    @Test
    fun onCreated_loadInitialListInformation_setArticlesError() {
        given(getNewsUseCase.getNewsList()).willReturn(
            Observable.just(ArticlesMock.articles)
        )
        given(setNewsUseCase.setArticles(ArticlesMock.articles)).willReturn(
            Single.error(Exception("database error"))
        )

        newsListViewModel.onCreated()

        newsListViewModel.startRefreshing().test()
        newsListViewModel.getArticleList().test()
        newsListViewModel.stopRefreshing().test()
        newsListViewModel.showErrorMessage().test()
    }

    @Test
    fun onCreated_loadNewsError_loadItemsFromDatabase() {
        given(getNewsUseCase.getNewsList()).willReturn(
            Observable.error(Exception("test error"))
        )
        given(getNewsUseCase.getArticles()).willReturn(
            Observable.just(ArticlesMock.articles)
        )

        newsListViewModel.onCreated()

        newsListViewModel.startRefreshing().test()
        newsListViewModel.getArticleList().test()
        newsListViewModel.stopRefreshing().test()
        newsListViewModel.showConnectionErrorMessage().test()
    }

    @Test
    fun onCreated_loadNewsError_loadItemsFromDatabase_loadItemsError() {
        given(getNewsUseCase.getNewsList()).willReturn(
            Observable.error(Exception("test error"))
        )
        given(getNewsUseCase.getArticles()).willReturn(
            Observable.error(Exception("database error"))
        )

        newsListViewModel.onCreated()

        newsListViewModel.startRefreshing().test()
        newsListViewModel.showErrorMessage().test()
        newsListViewModel.stopRefreshing().test()
    }
}