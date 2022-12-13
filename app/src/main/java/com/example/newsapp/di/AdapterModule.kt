package com.example.newsapp.di

import com.example.newsapp.presentation.adapters.NewsAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

@Module
@InstallIn(FragmentComponent::class)
object AdapterModule {
    @Provides
    @FragmentScoped
    fun providesNewsAdapter(): NewsAdapter = NewsAdapter()
}