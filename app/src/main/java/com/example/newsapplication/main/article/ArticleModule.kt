package com.example.newsapplication.main.article

import com.example.newsapplication.utils.viewmodel.BaseViewModel
import com.example.newsapplication.utils.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ArticleModule private constructor() {
    @Binds
    @IntoMap
    @ViewModelKey(ArticleViewModel::class)
    abstract fun bindArticleViewModule(viewModel: ArticleViewModel): BaseViewModel
}