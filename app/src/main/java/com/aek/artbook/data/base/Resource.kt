package com.aek.artbook.data.base

data class Resource<out T>(val status: Status, val data: T?, val errorModel: ErrorModel?) {

    companion object {

        fun <T> loading(): Resource<T> {
            return Resource(Status.LOADING, null, null)
        }

        fun <T> error(errorModel: ErrorModel?): Resource<T> {
            return Resource(Status.ERROR, null, errorModel)
        }

        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }
    }
}
