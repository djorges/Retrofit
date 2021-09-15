package com.example.retrofit_example.domain.repositories

import com.example.retrofit_example.data.model.ArticleEntity
import com.example.retrofit_example.data.model.ArticleModel
import com.example.retrofit_example.data.model.ChannelModel

interface RSSRepository {
    suspend fun getChannel(): ChannelModel?
    suspend fun getSavedArticles():List<ArticleModel>
    suspend fun saveArticle(articleModel: ArticleModel)
    suspend fun deleteArticle(articleModel: ArticleModel)
}