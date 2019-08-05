package com.example.newsapplication.utils.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel : ViewModel() {
    private val disposable = CompositeDisposable()

    open fun onCreated() {
        // Empty
    }

    override fun onCleared() {
        disposable.clear()
    }

    fun Disposable.attachToViewModel(): Disposable = this.also { disposable.add(it) }
}