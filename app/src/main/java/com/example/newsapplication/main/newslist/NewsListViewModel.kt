package com.example.newsapplication.main.newslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsapplication.main.entities.Article
import com.example.newsapplication.main.newslist.usecases.GetNewsUseCase
import com.example.newsapplication.main.newslist.usecases.SetNewsUseCase
import com.example.newsapplication.utils.viewmodel.BaseViewModel
import com.example.newsapplication.utils.viewmodel.SingleLiveData
import javax.inject.Inject

class NewsListViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase,
    private val setNewsUseCase: SetNewsUseCase
) : BaseViewModel() {
    private val articleList = MutableLiveData<List<Article>>()
    private val errorMessage = SingleLiveData<String>()
    private val connectionErrorMessage = SingleLiveData<Unit>()
    private val startRefreshing = MutableLiveData<Unit>()
    private val stopRefreshing = MutableLiveData<Unit>()
    private val emptyArticleList = SingleLiveData<Unit>()

    fun getArticleList(): MutableLiveData<List<Article>> = articleList

    fun showErrorMessage(): SingleLiveData<String> = errorMessage

    fun showConnectionErrorMessage(): SingleLiveData<Unit> = connectionErrorMessage

    fun startRefreshing(): LiveData<Unit> = startRefreshing

    fun stopRefreshing(): LiveData<Unit> = stopRefreshing

    fun emptyArticleList(): SingleLiveData<Unit> = emptyArticleList

    override fun onCreated() {
        super.onCreated()
        startRefreshing.postValue(Unit)
        loadNewsList()
    }

    fun onRefreshCalled() {
        // clear disposables that have been attached before loading news list
        onCleared()
        loadNewsList()
    }

    private fun loadNewsList() {
        getNewsUseCase.getNewsList()
            .subscribe({ articles ->
                setArticles(articles)
                articleList.postValue(articles)
                setArticles(articles)
            }, { error ->
                getArticlesFromDatabase()
                errorMessage.postValue(error.message)
            }).attachToViewModel()
    }

    private fun getArticlesFromDatabase() {
        getNewsUseCase.getArticles()
            .subscribe({ articles ->
                stopRefreshing.postValue(Unit)
                if (articles.isNotEmpty()) {
                    articleList.postValue(articles)
                } else {
                    emptyArticleList.postValue(Unit)
                }
                connectionErrorMessage.postValue(Unit)
            }, { error ->
                errorMessage.postValue(error.message)
                stopRefreshing.postValue(Unit)
            }).attachToViewModel()
    }

    private fun setArticles(articles: List<Article>) {
        setNewsUseCase.setArticles(articles)
            .subscribe({
                stopRefreshing.postValue(Unit)
            }, { error ->
                stopRefreshing.postValue(Unit)
                errorMessage.postValue(error.message)
            }).attachToViewModel()
    }
}