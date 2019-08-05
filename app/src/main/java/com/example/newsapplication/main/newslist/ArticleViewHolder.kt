package com.example.newsapplication.main.newslist

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.main.entities.Article
import com.example.newsapplication.utils.images.ImageLoader
import kotlinx.android.synthetic.main.item_article.view.*

class ArticleViewHolder(
    itemView: View,
    private val onClick: (article: Article) -> Unit,
    private val imageLoader: ImageLoader
): RecyclerView.ViewHolder(itemView) {
    fun bind(article: Article) {
        itemView.articleTitleTextView.text = article.title
        itemView.articlePublishDateTextView.text = article.publishedAt
        imageLoader.loadImage(itemView.articleImageView, article.urlToImage.toString())
        itemView.setOnClickListener {
            onClick(article)
        }
    }
}