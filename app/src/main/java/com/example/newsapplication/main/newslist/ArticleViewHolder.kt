package com.example.newsapplication.main.newslist

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.main.entities.Article
import kotlinx.android.synthetic.main.item_article.view.*

class ArticleViewHolder(
    itemView: View,
    private val onClick: (article: Article) -> Unit
): RecyclerView.ViewHolder(itemView) {
    fun bind(article: Article) {
        itemView.articleTitleTextView.text = article.title
        itemView.setOnClickListener {
            onClick(article)
        }
    }
}