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
    private val articleList = SingleLiveData<List<Article>>()
    private val errorMessage = SingleLiveData<String>()
    private val connectionErrorMessage = SingleLiveData<Unit>()
    private val startRefreshing = MutableLiveData<Unit>()
    private val stopRefreshing = MutableLiveData<Unit>()

    fun getArticleList(): SingleLiveData<List<Article>> = articleList

    fun showErrorMessage(): SingleLiveData<String> = errorMessage

    fun showConnectionErrorMessage(): SingleLiveData<Unit> = connectionErrorMessage

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
            setNewsUseCase.setNews(news).subscribe({
                stopRefreshing.postValue(Unit)
            }, { error ->
                stopRefreshing.postValue(Unit)
                errorMessage.postValue(error.message)
            })
        }, { error ->
            getNewsUseCase.getArticles().subscribe({ articles ->
                stopRefreshing.postValue(Unit)
                articleList.postValue(articles)
                connectionErrorMessage.postValue(Unit)
            }, {
                errorMessage.postValue(error.message)
                stopRefreshing.postValue(Unit)
            })
        }).attachToViewModel()
    }
}