package com.aek.artbook.utils.extentions

import com.aek.artbook.data.base.ErrorModel
import com.aek.artbook.data.base.Resource
import com.aek.artbook.utils.const.AppConstants.ErrorMessage.ERROR_MESSAGE_UNKNOWN
import retrofit2.Response

fun <T> Response<T>.handleResponse(): Resource<T> {
    val response = this@handleResponse

    val errorModel = ErrorModel(ERROR_MESSAGE_UNKNOWN, response.code())

    if (!response.isSuccessful) return Resource.error(errorModel)

    response.body()?.let {
        try {
            return Resource.success(it)
        } catch (ex: Exception) {
            return Resource.error(
                ErrorModel(ERROR_MESSAGE_UNKNOWN, 500)
            )
        }
    }

    return Resource.error(errorModel)
}
