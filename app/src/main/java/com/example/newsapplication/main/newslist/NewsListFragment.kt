package com.example.newsapplication.main.newslist

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapplication.R
import com.example.newsapplication.utils.activity.showMessage
import com.example.newsapplication.utils.fragment.ViewModelFragment
import com.example.newsapplication.utils.images.ImageLoader
import kotlinx.android.synthetic.main.fragment_news_list.*
import javax.inject.Inject

class NewsListFragment : ViewModelFragment() {
    @Inject
    lateinit var imageLoader: ImageLoader

    private val viewModel by viewModel<NewsListViewModel>()

    override val layoutRes = R.layout.fragment_news_list

    private val articleAdapter by lazy {
        ArticleAdapter(onClick = {}, imageLoader = imageLoader)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getArticleList().observe(articleAdapter::setArticleList)
        viewModel.showErrorMessage().observe(requireActivity()::showMessage)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = articleAdapter
        }
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