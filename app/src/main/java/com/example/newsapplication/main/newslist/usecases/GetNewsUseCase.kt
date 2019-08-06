package com.example.newsapplication.main.newslist.usecases

import com.example.newsapplication.main.newslist.NewsRepository
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
        private val newListRepository: NewsRepository
) {
    fun getNewsList() = newListRepository.getNews()

    fun getArticles() = newListRepository.getArticlesFromDatabase()
}
