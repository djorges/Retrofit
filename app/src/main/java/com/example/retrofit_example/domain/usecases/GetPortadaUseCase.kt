package com.example.retrofit_example.domain.usecases

import com.example.retrofit_example.data.model.Portada
import com.example.retrofit_example.domain.repositories.RSSRepository
import javax.inject.Inject

class GetPortadaUseCase @Inject constructor(
    private val repository:RSSRepository
){
    suspend operator fun invoke(): Portada{
        return repository.getPortada()
    }
}