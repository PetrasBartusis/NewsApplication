package com.example.newsapplication.main.newslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.R
import com.example.newsapplication.main.entities.Article
import com.example.newsapplication.utils.dateformatter.DateFormatter
import com.example.newsapplication.utils.images.ImageLoader

class ArticleAdapter(
        private val imageLoader: ImageLoader,
        private val dateFormatter: DateFormatter
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
                    imageLoader = imageLoader,
                    dateFormatter = dateFormatter
            )

    override fun getItemCount(): Int = articleList.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articleList[position])
    }
}