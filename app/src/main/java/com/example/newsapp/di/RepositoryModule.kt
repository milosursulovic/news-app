package com.example.newsapp.di

import com.example.newsapp.data.api.NewsApi
import com.example.newsapp.data.db.ArticlesDatabase
import com.example.newsapp.data.repository.NewsRepositoryImpl
import com.example.newsapp.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun providesNewsRepository(api: NewsApi, db: ArticlesDatabase): NewsRepository =
        NewsRepositoryImpl(api, db)
}