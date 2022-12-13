package com.example.newsapp.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.newsapp.data.db.ArticlesDao
import com.example.newsapp.data.db.ArticlesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun providesRoom(app: Application): RoomDatabase =
        Room.databaseBuilder(
            app,
            ArticlesDatabase::class.java,
            ArticlesDatabase.DATABASE_NAME
        ).build()

    @Provides
    @Singleton
    fun providesArticlesDao(db: ArticlesDatabase): ArticlesDao = db.dao
}