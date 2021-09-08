package com.example.retrofit_example.data.datasources

import com.example.retrofit_example.data.api.RSSMap
import com.example.retrofit_example.data.model.Portada
import com.example.retrofit_example.domain.repositories.RSSDataSource
import javax.inject.Inject

class RSSDataSourceImpl @Inject constructor(
    private val service: RSSMap
): RSSDataSource {
    override suspend fun getPortada(): Portada {
        return service.getPortada()
    }
}