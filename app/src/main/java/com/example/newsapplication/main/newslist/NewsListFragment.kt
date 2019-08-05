package com.example.newsapplication.main.newslist

import android.os.Bundle
import android.view.View
import com.example.newsapplication.R
import com.example.newsapplication.utils.fragment.ViewModelFragment

class NewsListFragment : ViewModelFragment() {
    private val viewModel by viewModel<NewsListViewModel>()

    override val layoutRes = R.layout.fragment_news_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    companion object {
        fun newInstance() = NewsListFragment()
    }
}