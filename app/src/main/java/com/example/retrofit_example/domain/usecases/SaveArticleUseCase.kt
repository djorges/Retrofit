package com.example.retrofit_example.domain.usecases

import com.example.retrofit_example.data.model.ArticleEntity
import com.example.retrofit_example.data.model.ArticleModel
import com.example.retrofit_example.domain.repositories.RSSRepository
import javax.inject.Inject

class SaveArticleUseCase @Inject constructor(
    private val repository: RSSRepository
){
    suspend operator fun invoke(articleModel: ArticleModel){
        repository.saveArticle(articleModel)
    }
}