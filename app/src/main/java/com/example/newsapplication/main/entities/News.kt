package com.example.newsapplication.main.entities

data class News(
        val status: String,
        val totalResults: Int,
        val articles: List<Article>
)