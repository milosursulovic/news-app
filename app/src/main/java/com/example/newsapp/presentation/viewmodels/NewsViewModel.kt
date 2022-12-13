package com.example.newsapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.newsapp.domain.usecases.GetBreakingNewsUseCase
import com.example.newsapp.domain.usecases.SearchNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getBreakingNewsUseCase: GetBreakingNewsUseCase,
    private val searchNewsUseCase: SearchNewsUseCase
) : ViewModel() {
    fun getBreakingNews() = getBreakingNewsUseCase()

    fun searchNews(searchQuery: String) = searchNewsUseCase(searchQuery)
}