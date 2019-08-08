package com.example.newsapplication.main

import com.example.newsapplication.main.article.ArticleFragment
import com.example.newsapplication.main.article.ArticleModule
import com.example.newsapplication.main.newslist.NewsListFragment
import com.example.newsapplication.main.newslist.NewsListModule
import com.example.newsapplication.utils.dagger.DaggerScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule private constructor() {
    @DaggerScope(NewsListFragment::class)
    @ContributesAndroidInjector(modules = [NewsListModule::class])
    abstract fun contributesNewsListFragment(): NewsListFragment

    @DaggerScope(ArticleFragment::class)
    @ContributesAndroidInjector(modules = [ArticleModule::class])
    abstract fun contributesArticleFragment(): ArticleFragment
}