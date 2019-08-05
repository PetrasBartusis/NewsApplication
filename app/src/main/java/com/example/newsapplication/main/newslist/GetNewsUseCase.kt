package com.example.newsapplication.main.newslist

import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
        private val newListRepository: NewsRepository
) {
    fun getNewsList() = newListRepository.getNews()
}
