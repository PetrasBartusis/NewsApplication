package com.example.newsapplication.main.entities

import java.io.Serializable
import java.net.URL

data class Article(
        val source: Source,
        val author: String?,
        val title: String,
        val description: String,
        val url: URL,
        val urlToImage: URL?,
        val publishedAt: String
) : Serializable