package com.example.newsapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.api.models.Article
import com.example.newsapp.domain.usecases.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getBreakingNewsUseCase: GetBreakingNewsUseCase,
    private val searchNewsUseCase: SearchNewsUseCase,
    private val insertArticleUseCase: InsertArticleUseCase,
    private val getAllArticlesUseCase: GetAllArticlesUseCase,
    private val deleteArticleUseCase: DeleteArticleUseCase
) : ViewModel() {
    fun getBreakingNews() = getBreakingNewsUseCase()

    fun searchNews(searchQuery: String) = searchNewsUseCase(searchQuery)

    fun insertArticle(article: Article) = viewModelScope.launch {
        insertArticleUseCase(article)
    }

    fun deleteArticle(article: Article) = viewModelScope.launch {
        deleteArticleUseCase(article)
    }

    fun getAllArticles() = getAllArticlesUseCase()
}