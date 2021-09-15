package com.example.retrofit_example.data.repositories

import com.example.retrofit_example.data.model.ArticleModel
import com.example.retrofit_example.data.model.ChannelModel
import com.example.retrofit_example.domain.mappers.ArticleMapper
import com.example.retrofit_example.domain.repositories.RSSDataSource
import com.example.retrofit_example.domain.repositories.RSSRepository
import javax.inject.Inject

class RSSRepositoryImpl @Inject constructor(
    private val dataSource: RSSDataSource,
    private val mapper: ArticleMapper
): RSSRepository{
    override suspend fun getChannel(): ChannelModel?{
        return dataSource.getCover().channel
    }

    override suspend fun getSavedArticles(): List<ArticleModel> {
        return dataSource.getSavedArticles().map {
            mapper.toArticleModel(it)
        }
    }

    override suspend fun saveArticle(articleModel: ArticleModel) {
        dataSource.saveArticle(
            mapper.toArticleEntity(articleModel)
        )
    }

    override suspend fun deleteArticle(articleModel: ArticleModel) {
        dataSource.deleteArticle(
            mapper.toArticleEntity(articleModel)
        )
    }
}