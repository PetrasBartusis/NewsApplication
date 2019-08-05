package com.example.newsapplication.main.newslist

import javax.inject.Inject

class GetNewsListUseCase @Inject constructor(
        private val newListRepository: NewsListRepository
) {
    fun getNewsList() = newListRepository.getNewsList()
}
