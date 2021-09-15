package com.example.retrofit_example.domain.usecases

import com.example.retrofit_example.data.model.ChannelModel
import com.example.retrofit_example.domain.repositories.RSSRepository
import javax.inject.Inject

class GetChannelUseCase @Inject constructor(
    private val repository:RSSRepository
){
    suspend operator fun invoke(): ChannelModel?{
        return repository.getChannel()
    }
}