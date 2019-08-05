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
    private val startRefreshing = MutableLiveData<Unit>()
    private val stopRefreshing = MutableLiveData<Unit>()

    fun getArticleList(): LiveData<List<Article>> = articleList

    fun showErrorMessage(): LiveData<String> = message

    fun startRefreshing(): LiveData<Unit> = startRefreshing

    fun stopRefreshing(): LiveData<Unit> = stopRefreshing

    override fun onCreated() {
        startRefreshing.postValue(Unit)
        loadNewsList()
    }

    fun onRefreshCalled() {
        loadNewsList()
    }

    private fun loadNewsList() {
        getNewsUseCase.getNewsList().subscribe({ news ->
            articleList.postValue(news.articles)
            stopRefreshing.postValue(Unit)
        }, { error ->
            message.postValue(error.message)
            stopRefreshing.postValue(Unit)
        }).attachToViewModel()
    }
}