package com.example.retrofit_example.data.api

import com.example.retrofit_example.data.model.Portada
import retrofit2.Call
import retrofit2.http.*

interface RSSMap {
    @GET("rss/portada")
    suspend fun getPortada(): Portada
}