package com.aek.artbook.data

sealed class Resource<out T> {
    object Loading : Resource<Any>()
    data class Success<T>(val result: T?) : Resource<T>()
    data class Error<T>(val errorModel: ErrorModel?) : Resource<T>()
}
