package com.example.newsapplication.main.newslist.usecases

import com.example.newsapplication.main.entities.Article
import com.example.newsapplication.main.newslist.NewsRepository
import javax.inject.Inject

class SetNewsUseCase @Inject constructor(
    private val newListRepository: NewsRepository
) {
    fun setArticles(articles: List<Article>) = newListRepository.setArticles(articles)
}