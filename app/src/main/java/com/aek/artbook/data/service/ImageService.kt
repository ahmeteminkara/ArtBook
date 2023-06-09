package com.aek.artbook.data.service

import com.aek.artbook.constants.AppConstants
import com.aek.artbook.data.model.ImageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageService {

    @GET(AppConstants.Service.ENDPOINT_SEARCH)
    suspend fun searchImage(
        @Query("key") apiKey: String,
        @Query("q") query: String,
        @Query("order") order: String = "popular"
    ): Response<ImageResponse>
}
