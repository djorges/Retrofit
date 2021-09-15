package com.example.retrofit_example.presentation.viewmodel

import androidx.lifecycle.*
import com.example.retrofit_example.data.model.ArticleModel
import com.example.retrofit_example.data.model.ChannelModel
import com.example.retrofit_example.domain.usecases.DeleteArticleUseCase
import com.example.retrofit_example.domain.usecases.GetChannelUseCase
import com.example.retrofit_example.domain.usecases.GetSavedArticlesUseCase
import com.example.retrofit_example.domain.usecases.SaveArticleUseCase
import com.example.retrofit_example.domain.vo.Result
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getChannelUseCase: GetChannelUseCase,
    private val saveArticleUseCase: SaveArticleUseCase,
    private val getSavedArticlesUseCase: GetSavedArticlesUseCase,
    private val deleteArticleUseCase: DeleteArticleUseCase
) : ViewModel(){

    val getChannel = liveData<Result<ChannelModel?>>(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(Result.Success(getChannelUseCase()))
        }catch (e:Exception){
            emit(Result.Failure(e))
        }
    }
    val getSavedArticles = liveData<Result<List<ArticleModel>>>(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(Result.Success(getSavedArticlesUseCase()))
        }catch (e:Exception){
            emit(Result.Failure(e))
        }
    }
    fun saveArticle(articleModel: ArticleModel){
        viewModelScope.launch(Dispatchers.IO) {
           saveArticleUseCase(articleModel)
        }
    }
    fun deleteArticle(articleModel: ArticleModel){
        viewModelScope.launch(Dispatchers.IO){
            deleteArticleUseCase(articleModel)
        }
    }
}