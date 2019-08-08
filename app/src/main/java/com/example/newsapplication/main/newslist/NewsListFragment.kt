package com.example.newsapplication.main.newslist

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.newsapplication.R
import com.example.newsapplication.main.entities.Article
import com.example.newsapplication.utils.activity.showMessage
import com.example.newsapplication.utils.dateformatter.DateFormatter
import com.example.newsapplication.utils.fragment.ViewModelFragment
import com.example.newsapplication.utils.images.ImageLoader
import kotlinx.android.synthetic.main.fragment_news_list.*
import javax.inject.Inject

class NewsListFragment : ViewModelFragment(), SwipeRefreshLayout.OnRefreshListener {
    @Inject
    lateinit var imageLoader: ImageLoader

    @Inject
    lateinit var dateFormatter: DateFormatter

    private val viewModel by viewModel<NewsListViewModel>()

    override val layoutRes = R.layout.fragment_news_list

    private val articleAdapter by lazy {
        ArticleAdapter(
                imageLoader = imageLoader,
                dateFormatter = dateFormatter
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getArticleList().observe(::setListItems)
        viewModel.showErrorMessage().observe(requireActivity()::showMessage)
        viewModel.startRefreshing().observe(::startRefreshing)
        viewModel.stopRefreshing().observe(::stopRefreshing)
        viewModel.showConnectionErrorMessage().observe(::showConnectionError)
        viewModel.emptyArticleList().observe(::showEmptyListView)
        swipeRefreshLayout.setOnRefreshListener(this)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = articleAdapter
        }
        setUpToolbar()
    }

    private fun setListItems(articles: List<Article>) {
        articleAdapter.setArticleList(articles)
        recyclerView.visibility = View.VISIBLE
        emptyListTextView.visibility = View.GONE
    }

    private fun setUpToolbar() {
        toolbar.apply {
            setNavigationIcon(R.drawable.ic_menu)
        }
    }

    @Suppress("UNUSED_PARAMETER")
    private fun startRefreshing(unit: Unit) {
        swipeRefreshLayout.isRefreshing = true
    }

    @Suppress("UNUSED_PARAMETER")
    private fun stopRefreshing(unit: Unit) {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun onRefresh() {
        viewModel.onRefreshCalled()
    }

    @Suppress("UNUSED_PARAMETER")
    private fun showEmptyListView(unit: Unit) {
        recyclerView.visibility = View.GONE
        emptyListTextView.visibility = View.VISIBLE
    }

    @Suppress("UNUSED_PARAMETER")
    private fun showConnectionError(unit: Unit) {
        requireActivity().showMessage(R.string.error_connection)
    }

    companion object {
        fun newInstance() = NewsListFragment()
    }
}