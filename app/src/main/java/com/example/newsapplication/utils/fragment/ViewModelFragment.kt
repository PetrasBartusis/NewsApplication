package com.example.newsapplication.utils.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.newsapplication.utils.viewmodel.BaseViewModel
import com.example.newsapplication.utils.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class ViewModelFragment : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    abstract val layoutRes: Int

    inline fun <reified T : BaseViewModel> viewModel() = lazy {
        ViewModelProviders.of(this@ViewModelFragment, viewModelFactory).get(T::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(layoutRes, container, false)

    abstract override fun onViewCreated(view: View, savedInstanceState: Bundle?)

    protected fun <T> LiveData<T>.observe(action: (T) -> Unit) {
        observe(this@ViewModelFragment, Observer { data -> data?.let(action) })
    }
}