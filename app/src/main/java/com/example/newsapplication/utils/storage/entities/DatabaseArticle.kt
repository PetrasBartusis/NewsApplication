package com.example.newsapplication.utils.storage.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class DatabaseArticle(
        @PrimaryKey(autoGenerate = true)  val id: Int = 0,
        @ColumnInfo(name = "author") val author: String?,
        @ColumnInfo(name = "title") val title: String,
        @ColumnInfo(name = "description") val description: String,
        @ColumnInfo(name = "url") val url: String,
        @ColumnInfo(name = "urlToImage") val urlToImage: String?,
        @ColumnInfo(name = "publishedAt") val publishedAt: String,
        @ColumnInfo(name = "sourceName") val sourceName: String
) : Serializable