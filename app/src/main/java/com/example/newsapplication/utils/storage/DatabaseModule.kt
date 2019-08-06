package com.example.newsapplication.utils.storage

import androidx.room.Room
import com.example.newsapplication.app.BaseApplication
import com.example.newsapplication.utils.dagger.DaggerScope
import com.example.newsapplication.utils.storage.daos.NewsDao
import dagger.Module
import dagger.Provides

@Module
abstract class DatabaseModule private constructor() {
    @Module
    companion object {
        @Provides
        @JvmStatic
        @DaggerScope(BaseApplication::class)
        internal fun providesRoomDatabase(app: BaseApplication): AppDatabase {
            return Room.databaseBuilder(app, AppDatabase::class.java, "newsAppDb").build()
        }

        @Provides
        @JvmStatic
        @DaggerScope(BaseApplication::class)
        internal fun providesNewsDao(database: AppDatabase): NewsDao {
            return database.newsDao()
        }
    }
}