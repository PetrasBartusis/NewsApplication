package com.example.newsapplication.main.newslist

import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.R
import com.example.newsapplication.main.entities.Article
import com.example.newsapplication.utils.dateformatter.DateFormatter
import com.example.newsapplication.utils.images.ImageLoader
import kotlinx.android.synthetic.main.item_article.view.*

class ArticleViewHolder(
    itemView: View,
    private val imageLoader: ImageLoader,
    private val dateFormatter: DateFormatter
): RecyclerView.ViewHolder(itemView) {
    fun bind(article: Article) {
        itemView.articleTitleTextView.text = article.title
        itemView.articlePublishDateTextView.text = dateFormatter
                .getDateTimeFromDateString(article.publishedAt)
        imageLoader.loadImage(itemView.articleImageView, article.urlToImage.toString())
        itemView.setOnClickListener {
            it.findNavController().navigate(
                R.id.action_newsListFragment_to_articleFragment,
                bundleOf(ARTICLE_KEY to article)
            )
        }
    }

    companion object {
        private const val ARTICLE_KEY = "article_key"
    }
}