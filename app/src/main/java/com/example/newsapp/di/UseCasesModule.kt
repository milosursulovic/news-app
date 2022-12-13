package com.example.newsapp.di

import com.example.newsapp.domain.repository.NewsRepository
import com.example.newsapp.domain.usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {
    @Provides
    @Singleton
    fun providesGetBreakingNewsUseCase(repository: NewsRepository): GetBreakingNewsUseCase =
        GetBreakingNewsUseCase(repository)

    @Provides
    @Singleton
    fun providesSearchNewsUseCase(repository: NewsRepository): SearchNewsUseCase =
        SearchNewsUseCase(repository)

    @Provides
    @Singleton
    fun providesInsertArticleUseCase(repository: NewsRepository): InsertArticleUseCase =
        InsertArticleUseCase(repository)

    @Provides
    @Singleton
    fun providesDeleteArticleUseCase(repository: NewsRepository): DeleteArticleUseCase =
        DeleteArticleUseCase(repository)

    @Provides
    @Singleton
    fun providesGetAllArticlesUseCase(repository: NewsRepository): GetAllArticlesUseCase =
        GetAllArticlesUseCase(repository)
}