package com.example.retrofit_example.di

import com.example.retrofit_example.data.datasources.RSSDataSourceImpl
import com.example.retrofit_example.data.repositories.RSSRepositoryImpl
import com.example.retrofit_example.domain.repositories.RSSDataSource
import com.example.retrofit_example.domain.repositories.RSSRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class BindModule {
    @Binds
    abstract fun bindRSSRepo(
        repoImpl:RSSRepositoryImpl
    ): RSSRepository

    @Binds
    abstract fun bindRSSDataSource(
        repoImpl: RSSDataSourceImpl
    ): RSSDataSource
}