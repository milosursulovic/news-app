package com.example.newsapp.domain.usecases

import com.example.newsapp.data.api.models.Article
import com.example.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetAllArticlesUseCase(
    private val repository: NewsRepository
) {
    operator fun invoke(): Flow<List<Article>> = repository.getAllArticles()
}