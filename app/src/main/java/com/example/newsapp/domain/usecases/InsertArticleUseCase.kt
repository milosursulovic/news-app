package com.example.newsapp.domain.usecases

import com.example.newsapp.data.api.models.Article
import com.example.newsapp.domain.repository.NewsRepository

class InsertArticleUseCase(
    private val repository: NewsRepository
) {
    suspend operator fun invoke(article: Article) {
        repository.insertArticle(article)
    }
}