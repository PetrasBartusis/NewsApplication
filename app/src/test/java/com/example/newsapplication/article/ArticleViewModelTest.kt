package com.example.newsapplication.article

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.newsapplication.main.article.ArticleViewModel
import com.jraska.livedata.test
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class ArticleViewModelTest {
    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    private lateinit var articleViewModel: ArticleViewModel

    @Before
    fun setUp() {
        articleViewModel = ArticleViewModel()
    }

    @Test
    fun onLinkClicked_passUrlToViewSuccessful() {
        articleViewModel.onLinkClicked("")

        articleViewModel.openLink().test()
    }
}