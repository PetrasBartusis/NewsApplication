package com.example.newsapplication.main.article

import android.os.Bundle
import android.view.View
import com.example.newsapplication.main.entities.Article
import com.example.newsapplication.utils.dateformatter.DateFormatter
import com.example.newsapplication.utils.fragment.ViewModelFragment
import com.example.newsapplication.utils.images.ImageLoader
import kotlinx.android.synthetic.main.article_details.*
import kotlinx.android.synthetic.main.fragment_article.*
import javax.inject.Inject
import android.content.Intent
import android.net.Uri
import com.example.newsapplication.R

class ArticleFragment : ViewModelFragment() {
    override val layoutRes = R.layout.fragment_article

    private val viewModel by viewModel<ArticleViewModel>()

    @Inject
    lateinit var imageLoader: ImageLoader

    @Inject
    lateinit var dateFormatter: DateFormatter

    private fun getArticle() = arguments?.getParcelable<Article>(ARTICLE_KEY)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.openLink().observe(::openBrowser)
        getArticle()?.let { article ->
            setUpToolbar()
            setUpViews(article)
        }
    }

    private fun setUpViews(article: Article) {
        titleTextView.text = article.title
        descriptionTextView.text = article.description
        authorTextView.text = article.author
        dateTextView.text = dateFormatter.getDateTimeFromDateString(article.publishedAt)
        imageLoader.loadImage(headerImageView, article.urlToImage ?: "")
        linkButton.setOnClickListener {
            viewModel.onLinkClicked(article.url)
        }
    }

    private fun setUpToolbar() {
        toolbar.apply {
            setNavigationIcon(R.drawable.ic_arrow_back)
            setNavigationOnClickListener {
                requireActivity().onBackPressed()
            }
        }
    }

    private fun openBrowser(url: String) {
        startActivity(Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(url)
        })
    }

    companion object {
        private const val ARTICLE_KEY = "article_key"

        fun newInstance() = ArticleFragment()
    }
}