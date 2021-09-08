package com.example.retrofit_example.domain.repositories

import com.example.retrofit_example.data.model.Portada

interface RSSDataSource {
    suspend fun getPortada(): Portada
}