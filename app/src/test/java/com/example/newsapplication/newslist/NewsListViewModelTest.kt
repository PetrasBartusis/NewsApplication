package com.example.newsapplication.newslist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.newsapplication.main.newslist.NewsListViewModel
import com.example.newsapplication.main.newslist.usecases.GetNewsUseCase
import com.example.newsapplication.main.newslist.usecases.SetNewsUseCase
import com.nhaarman.mockitokotlin2.*
import org.junit.Before
import org.junit.Rule
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
}