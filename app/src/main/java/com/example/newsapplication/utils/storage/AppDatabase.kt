package com.example.newsapplication.utils.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newsapplication.utils.storage.daos.NewsDao
import com.example.newsapplication.utils.storage.entities.DatabaseArticle

@Database(entities = [DatabaseArticle::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}