package com.aek.artbook.utils.extentions

import com.aek.artbook.data.base.ErrorModel
import com.aek.artbook.data.base.Resource
import com.aek.artbook.utils.const.AppConstants.ErrorMessage.ERROR_MESSAGE_UNKNOWN
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

fun <T> Response<T>.handleResponse(): Flow<Resource<T>> = flow {
    val response = this@handleResponse

    val errorModel = ErrorModel(ERROR_MESSAGE_UNKNOWN, response.code())

    if (!response.isSuccessful) {
        emit(Resource.error(errorModel))
        return@flow
    }

    response.body()?.let {
        try {
            emit(Resource.success(it))
            return@flow
        } catch (ex: Exception) {
            emit(Resource.error(ErrorModel(ERROR_MESSAGE_UNKNOWN, 500)))
            return@flow
        }
    }

    emit(Resource.error(errorModel))
}
