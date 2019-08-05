package com.example.newsapplication.utils.storage

import com.example.newsapplication.main.newslist.DefaultNewsRepository
import com.example.newsapplication.main.newslist.NewsRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoriesModule private constructor() {
    @Binds
    abstract fun bindsNewsRepository(newsRepository: DefaultNewsRepository): NewsRepository
}