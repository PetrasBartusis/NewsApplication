package com.example.newsapplication.main.newslist

import android.os.Bundle
import android.view.View
import com.example.newsapplication.R
import com.example.newsapplication.utils.fragment.ViewModelFragment
import kotlinx.android.synthetic.main.fragment_news_list.*

class NewsListFragment : ViewModelFragment() {
    private val viewModel by viewModel<NewsListViewModel>()

    override val layoutRes = R.layout.fragment_news_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpToolbar()
    }

    private fun setUpToolbar() {
        toolbar.apply {
            setNavigationIcon(R.drawable.ic_menu)
        }
    }

    companion object {
        fun newInstance() = NewsListFragment()
    }
}