package com.example.newsapp.data.repository

import com.example.newsapp.data.api.NewsApi
import com.example.newsapp.data.api.models.NewsResponse
import com.example.newsapp.data.db.ArticlesDatabase
import com.example.newsapp.domain.repository.NewsRepository
import retrofit2.Response

class NewsRepositoryImpl(
    private val api: NewsApi,
    private val db: ArticlesDatabase
) : NewsRepository {
    override suspend fun getBreakingNews(): Response<NewsResponse> = api.getBreakingNews()

    override suspend fun searchForNews(searchQuery: String): Response<NewsResponse> =
        api.searchForNews(searchQuery)
}