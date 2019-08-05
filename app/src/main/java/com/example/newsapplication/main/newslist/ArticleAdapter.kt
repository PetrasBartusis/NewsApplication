package com.example.newsapplication.main.newslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.R
import com.example.newsapplication.main.entities.Article
import com.example.newsapplication.utils.images.ImageLoader

class ArticleAdapter(
    private val onClick: (article: Article) -> Unit,
    private val imageLoader: ImageLoader
) : RecyclerView.Adapter<ArticleViewHolder>() {
    private var articleList = mutableListOf<Article>()

    fun setArticleList(articles: List<Article>) {
        articleList.clear()
        articleList.addAll(articles)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ArticleViewHolder =
        ArticleViewHolder(
            itemView = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_article, viewGroup, false),
            onClick = onClick,
            imageLoader = imageLoader
        )

    override fun getItemCount(): Int = articleList.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articleList[position])
    }
}