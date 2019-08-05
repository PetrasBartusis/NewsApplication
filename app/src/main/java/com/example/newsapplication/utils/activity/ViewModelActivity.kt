package com.example.newsapplication.utils.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.newsapplication.utils.viewmodel.BaseViewModel
import com.example.newsapplication.utils.viewmodel.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class ViewModelActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    inline fun <reified T : BaseViewModel> viewModel() = lazy {
        ViewModelProviders.of(this@ViewModelActivity, viewModelFactory).get(T::class.java)
    }

    protected fun <T> LiveData<T>.observe(action: (T) -> Unit) {
        observe(this@ViewModelActivity, Observer { data -> data?.let(action) })
    }
}