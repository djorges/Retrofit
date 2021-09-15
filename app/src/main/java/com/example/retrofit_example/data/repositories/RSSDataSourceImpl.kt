package com.example.retrofit_example.data.repositories

import com.example.retrofit_example.data.api.RSSMap
import com.example.retrofit_example.data.db.ArticleDatabase
import com.example.retrofit_example.data.model.ArticleEntity
import com.example.retrofit_example.data.model.CoverModel
import com.example.retrofit_example.domain.repositories.RSSDataSource
import javax.inject.Inject

class RSSDataSourceImpl @Inject constructor(
    private val service: RSSMap,
    private val database: ArticleDatabase
): RSSDataSource {
    override suspend fun getCover(): CoverModel {
        return service.getCover()
    }

    override suspend fun getSavedArticles(): List<ArticleEntity> {
        return database.getDao().getArticles()
    }

    override suspend fun saveArticle(articleEntity: ArticleEntity) {
        database.getDao().insertArticle(articleEntity)
    }

    override suspend fun deleteArticle(articleEntity: ArticleEntity) {
        database.getDao().deleteArticle(articleEntity)
    }
}