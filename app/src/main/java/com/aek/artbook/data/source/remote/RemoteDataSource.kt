package com.aek.artbook.data.source.remote

import com.aek.artbook.data.base.Resource
import com.aek.artbook.data.model.ImageResponse
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    suspend fun searchImage(query: String): Flow<Resource<ImageResponse>>
}
