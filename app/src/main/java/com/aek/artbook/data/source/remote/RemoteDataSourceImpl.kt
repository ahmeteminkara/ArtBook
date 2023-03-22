package com.aek.artbook.data.source.remote

import com.aek.artbook.data.base.Resource
import com.aek.artbook.data.model.ImageResponse
import com.aek.artbook.data.service.ImageService
import com.aek.artbook.utils.const.AppConstants
import com.aek.artbook.utils.extentions.handleResponse
import kotlinx.coroutines.flow.Flow

class RemoteDataSourceImpl(
    private val imageService: ImageService
) : RemoteDataSource {

    override suspend fun searchImage(query: String): Flow<Resource<ImageResponse>> =
        imageService.searchImage(AppConstants.Service.API_KEY, query).handleResponse()
}
