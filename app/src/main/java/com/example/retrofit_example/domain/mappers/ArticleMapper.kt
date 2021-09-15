package com.example.retrofit_example.domain.mappers

import com.example.retrofit_example.data.model.ArticleEntity
import com.example.retrofit_example.data.model.ArticleModel
import com.example.retrofit_example.data.model.MediaModel
import javax.inject.Inject

class ArticleMapper @Inject constructor(){
    fun toArticleModel(articleEntity: ArticleEntity): ArticleModel{
        return ArticleModel().apply {
            title = articleEntity.title
            description = articleEntity.description
            link = articleEntity.link
            pubDate = articleEntity.pubDate
            content = articleEntity.content
            media = MediaModel().apply {
                url = articleEntity.imgUrl
            }
        }
    }
    fun toArticleEntity(model: ArticleModel): ArticleEntity{
        return ArticleEntity(
            model.title!!,
            model.description,
            model.link,
            model.pubDate,
            model.content,
            model.media?.url
        )
    }
}