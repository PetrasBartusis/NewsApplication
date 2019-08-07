package com.example.newsapplication.main.article

import androidx.lifecycle.LiveData
import com.example.newsapplication.utils.viewmodel.BaseViewModel
import com.example.newsapplication.utils.viewmodel.SingleLiveData
import javax.inject.Inject

class ArticleViewModel @Inject constructor() : BaseViewModel() {
    private val openLink = SingleLiveData<String>()

    fun openLink(): LiveData<String> = openLink

    override fun onCreated() {
        super.onCreated()
    }

    fun onLinkClicked(url: String) {
        openLink.postValue(url)
    }
}