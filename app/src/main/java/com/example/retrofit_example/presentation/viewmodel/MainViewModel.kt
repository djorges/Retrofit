package com.example.retrofit_example.presentation.viewmodel

import androidx.lifecycle.*
import com.example.retrofit_example.data.model.Portada
import com.example.retrofit_example.domain.usecases.GetPortadaUseCase
import com.example.retrofit_example.domain.vo.Result
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPortadaUseCase: GetPortadaUseCase
) : ViewModel(){

    val getXML = liveData<Result<Portada>>(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(Result.Success(getPortadaUseCase()))
        }catch (e:Exception){
            emit(Result.Failure(e))
        }
    }
}