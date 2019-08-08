package com.example.newsapplication.utils.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    private val creators: Map<Class<out BaseViewModel>, @JvmSuppressWildcards Provider<BaseViewModel>>
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        modelClass as Class<BaseViewModel>
        val creator = creators[modelClass] ?: throw IllegalArgumentException("unknown model class $modelClass")
        return creator.get().apply(BaseViewModel::onCreated) as T
    }
}