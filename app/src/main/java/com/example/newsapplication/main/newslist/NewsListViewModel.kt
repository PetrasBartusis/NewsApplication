package com.example.newsapplication.main.newslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsapplication.main.entities.Article
import com.example.newsapplication.utils.viewmodel.BaseViewModel
import com.example.newsapplication.utils.viewmodel.SingleLiveData
import javax.inject.Inject

class NewsListViewModel @Inject constructor(
        private val getNewsUseCase: GetNewsUseCase
) : BaseViewModel() {
    private val articleList = MutableLiveData<List<Article>>()
    private val message = SingleLiveData<String>()

    fun getArticleList(): LiveData<List<Article>> = articleList

    fun showErrorMessage(): LiveData<String> = message

    override fun onCreated() {
        getNewsUseCase.getNewsList().subscribe({ news ->
            articleList.postValue(news.articles)
        }, { error ->
            message.postValue(error.message)
        }).attachToViewModel()
    }
}