package com.example.retrofit_example.domain.usecases

import com.example.retrofit_example.data.model.ArticleModel
import com.example.retrofit_example.domain.repositories.RSSRepository
import javax.inject.Inject

class DeleteArticleUseCase @Inject constructor(
    private val repository: RSSRepository
) {
    suspend operator fun invoke(articleModel: ArticleModel){
        repository.deleteArticle(articleModel)
    }
}