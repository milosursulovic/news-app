package com.example.newsapp.data.repository

import com.example.newsapp.data.api.NewsApi
import com.example.newsapp.data.api.models.Article
import com.example.newsapp.data.api.models.NewsResponse
import com.example.newsapp.data.db.ArticlesDao
import com.example.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
    private val api: NewsApi,
    private val dao: ArticlesDao
) : NewsRepository {
    override suspend fun getBreakingNews(): Response<NewsResponse> = api.getBreakingNews()

    override suspend fun searchForNews(searchQuery: String): Response<NewsResponse> =
        api.searchForNews(searchQuery)

    override suspend fun insertArticle(article: Article) = dao.insertArticle(article)

    override suspend fun deleteArticle(article: Article) {
        dao.deleteArticle(article)
    }

    override fun getAllArticles(): Flow<List<Article>> = dao.getAllArticles()
}