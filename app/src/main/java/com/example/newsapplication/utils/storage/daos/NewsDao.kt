package com.example.newsapplication.utils.storage.daos

import androidx.room.*
import com.example.newsapplication.utils.storage.entities.DatabaseArticle
import io.reactivex.Single

@Dao
interface NewsDao {
    @Insert
    fun insertAll(articles: List<DatabaseArticle>)

    @Update
    fun update(articles: DatabaseArticle)

    @Delete
    fun delete(articles: DatabaseArticle)

    @Query("SELECT * FROM databasearticle")
    fun getArticles(): Single<List<DatabaseArticle>>
}