package com.aek.artbook.extentions

import com.aek.artbook.data.base.ErrorModel
import com.aek.artbook.data.base.Resource
import com.aek.artbook.data.base.Status

fun <T> Resource<T>.handleResource(
    onSuccess: ((data: T?) -> Unit)? = null,
    onError: ((errorModel: ErrorModel?) -> Unit)? = null,
    onLoading: ((isLoading: Boolean) -> Unit)? = null
) {
    when (this.status) {
        Status.LOADING -> onLoading?.invoke(true)
        Status.ERROR -> {
            onLoading?.invoke(false)
            onError?.invoke(this.errorModel)
        }
        Status.SUCCESS -> {
            onLoading?.invoke(false)
            onSuccess?.invoke(this.data)
        }
    }
}

fun <T> Resource<T>.handleResourceNotNullData(
    onSuccess: ((data: T) -> Unit),
    onError: ((errorModel: ErrorModel?) -> Unit)? = null,
    onLoading: ((isLoading: Boolean) -> Unit)? = null
) {
    when (this.status) {
        Status.LOADING -> onLoading?.invoke(true)
        Status.ERROR -> {
            onLoading?.invoke(false)
            onError?.invoke(this.errorModel)
        }
        Status.SUCCESS -> {
            onLoading?.invoke(false)
            this.data?.let(onSuccess)
        }
    }
}
