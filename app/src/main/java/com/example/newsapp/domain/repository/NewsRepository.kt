package com.example.newsapp.domain.repository

import com.example.newsapp.data.api.models.NewsResponse
import retrofit2.Response

interface NewsRepository {
    suspend fun getBreakingNews(): Response<NewsResponse>

    suspend fun searchForNews(searchQuery: String): Response<NewsResponse>
}