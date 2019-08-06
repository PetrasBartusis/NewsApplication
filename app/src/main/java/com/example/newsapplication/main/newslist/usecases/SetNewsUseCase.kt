package com.example.newsapplication.main.newslist.usecases

import com.example.newsapplication.main.entities.News
import com.example.newsapplication.main.newslist.NewsRepository
import javax.inject.Inject

class SetNewsUseCase @Inject constructor(
    private val newListRepository: NewsRepository
) {
    fun setNews(news: News) = newListRepository.setNews(news)
}