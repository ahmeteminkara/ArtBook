package com.aek.artbook.data

data class WrappedResponse<T>(
    val success: Boolean,
    val data: T,
    val error: String
)
