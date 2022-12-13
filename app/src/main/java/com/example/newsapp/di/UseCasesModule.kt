package com.example.newsapp.di

import com.example.newsapp.domain.repository.NewsRepository
import com.example.newsapp.domain.usecases.GetBreakingNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCasesModule {
    @Provides
    @ViewModelScoped
    fun providesGetBreakingNewsUseCase(repository: NewsRepository): GetBreakingNewsUseCase =
        GetBreakingNewsUseCase(repository)
}