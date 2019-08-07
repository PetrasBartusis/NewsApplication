package com.example.newsapplication.main.article

import android.os.Bundle
import android.view.View
import com.example.newsapplication.R
import com.example.newsapplication.main.entities.Article
import com.example.newsapplication.utils.fragment.ViewModelFragment
import kotlinx.android.synthetic.main.article_details.*

class ArticleFragment : ViewModelFragment() {
    override val layoutRes = R.layout.fragment_article

    private val viewModel by viewModel<ArticleViewModel>()

    private fun getArticle() = arguments?.getParcelable<Article>(ARTICLE_KEY)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        getArticle()?.let { article ->
            article_title.text = article.title
            article_description.text = article.description
        }
    }

    companion object {
        private const val ARTICLE_KEY = "article_key"

        fun newInstance() = ArticleFragment()
    }
}