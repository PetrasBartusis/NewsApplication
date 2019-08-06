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
            Single.just(articles)
        )
        given(setNewsUseCase.setArticles(articles)).willReturn(
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
            Single.just(articles)
        )
        given(setNewsUseCase.setArticles(articles)).willReturn(
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
            Single.error(Exception("test error"))
        )
        given(getNewsUseCase.getArticles()).willReturn(
            Single.just(articles)
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
            Single.error(Exception("test error"))
        )
        given(getNewsUseCase.getArticles()).willReturn(
            Single.error(Exception("database error"))
        )

        newsListViewModel.onCreated()

        newsListViewModel.startRefreshing().test()
        newsListViewModel.showErrorMessage().test()
        newsListViewModel.stopRefreshing().test()
    }

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

        private val articles = listOf(article1, article2, article3)
    }
}