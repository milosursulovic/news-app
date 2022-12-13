package com.example.newsapp.data.db

import androidx.room.*
import com.example.newsapp.data.api.models.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticlesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(article: Article)

    @Delete
    suspend fun deleteArticle(article: Article)

    @Query("select * from articles")
    fun getAllArticles(): Flow<List<Article>>
}