package com.example.newsapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.newsapp.data.api.models.Article

@Database(entities = [Article::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ArticlesDatabase : RoomDatabase() {
    abstract val dao: ArticlesDao

    companion object {
        const val DATABASE_NAME = "articles_db"
    }
}