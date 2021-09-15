package com.example.retrofit_example.domain.usecases

import com.example.retrofit_example.data.model.ArticleModel
import com.example.retrofit_example.domain.repositories.RSSRepository
import javax.inject.Inject

class GetSavedArticlesUseCase  @Inject constructor(
    private val repository: RSSRepository
){
    suspend operator fun invoke():List<ArticleModel>{
        return repository.getSavedArticles()
    }
}