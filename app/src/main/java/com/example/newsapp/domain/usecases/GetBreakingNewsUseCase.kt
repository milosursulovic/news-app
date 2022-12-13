package com.example.newsapp.domain.usecases

import com.example.newsapp.data.api.Resource
import com.example.newsapp.data.api.models.NewsResponse
import com.example.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetBreakingNewsUseCase(
    private val repository: NewsRepository
) {
    operator fun invoke(): Flow<Resource<NewsResponse>> = flow {
        emit(Resource.Loading())
        try {
            val response = repository.getBreakingNews()
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(Resource.Success(it))
                }
            } else {
                emit(Resource.Error("Unknown error happened"))
            }
        } catch (e: Exception) {
            emit(Resource.Error("Unknown error happened: ${e.localizedMessage}"))
        }
    }
}