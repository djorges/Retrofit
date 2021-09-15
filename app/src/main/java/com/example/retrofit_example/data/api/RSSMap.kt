package com.example.retrofit_example.data.api

import com.example.retrofit_example.data.model.CoverModel
import retrofit2.http.*

interface RSSMap {
    @GET("rss/portada")
    suspend fun getCover(): CoverModel
}