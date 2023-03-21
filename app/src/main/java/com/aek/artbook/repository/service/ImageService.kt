package com.aek.artbook.repository.service

import com.aek.artbook.repository.model.ImageResponse
import com.aek.artbook.utils.const.AppConstants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageService {

    @GET(AppConstants.Service.ENDPOINT_SEARCH)
    suspend fun searchImage(
        @Query("key") apiKey: String,
        @Query("q") query: String
    ): Response<ImageResponse>
}
