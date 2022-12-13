package com.example.newsapp.domain.repository

import com.example.newsapp.data.api.models.Article
import com.example.newsapp.data.api.models.NewsResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface NewsRepository {
    suspend fun getBreakingNews(): Response<NewsResponse>

    suspend fun searchForNews(searchQuery: String): Response<NewsResponse>

    suspend fun insertArticle(article: Article)

    suspend fun deleteArticle(article: Article)

    fun getAllArticles(): Flow<List<Article>>
}