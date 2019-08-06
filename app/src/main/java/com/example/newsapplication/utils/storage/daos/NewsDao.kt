package com.example.newsapplication.utils.storage.daos

import androidx.room.*
import com.example.newsapplication.utils.storage.entities.DatabaseArticle
import io.reactivex.Single

@Dao
interface NewsDao {
    @Insert
    fun insertAll(articles: List<DatabaseArticle>): Single<List<Long>>

    @Update
    fun update(articles: DatabaseArticle)

    @Delete
    fun delete(articles: DatabaseArticle)

    @Query("DELETE FROM databasearticle")
    fun dropTable(): Single<Int>

    @Query("SELECT * FROM databasearticle")
    fun getArticles(): Single<List<DatabaseArticle>>
}