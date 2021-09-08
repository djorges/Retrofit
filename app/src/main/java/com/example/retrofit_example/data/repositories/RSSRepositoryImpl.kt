package com.example.retrofit_example.data.repositories

import com.example.retrofit_example.data.model.Portada
import com.example.retrofit_example.domain.repositories.RSSDataSource
import com.example.retrofit_example.domain.repositories.RSSRepository
import javax.inject.Inject

class RSSRepositoryImpl @Inject constructor(
    private val dataSource: RSSDataSource
): RSSRepository{
    override suspend fun getPortada(): Portada {
        return dataSource.getPortada()
    }
}