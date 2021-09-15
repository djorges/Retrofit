package com.example.retrofit_example.domain.repositories

import com.example.retrofit_example.data.model.ArticleEntity
import com.example.retrofit_example.data.model.CoverModel

interface RSSDataSource {
    suspend fun getCover(): CoverModel
    suspend fun getSavedArticles():List<ArticleEntity>
    suspend fun saveArticle(articleEntity: ArticleEntity)
    suspend fun deleteArticle(articleEntity: ArticleEntity)
}