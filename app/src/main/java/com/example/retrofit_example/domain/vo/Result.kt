package com.example.retrofit_example.domain.vo

sealed class Result<out T> {
    class Loading<out T> : Result<T>()
    data class Success<out T>(val data: T) : Result<T>()
    data class Failure<out T>(val exception: Throwable) : Result<T>()
}
