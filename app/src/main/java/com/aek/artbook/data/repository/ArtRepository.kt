package com.aek.artbook.data.repository

import com.aek.artbook.data.Resource
import com.aek.artbook.data.model.ImageResponse
import com.aek.artbook.domain.ArtModel
import kotlinx.coroutines.flow.Flow

interface ArtRepository {

    suspend fun insertArt(art: ArtModel)

    suspend fun insertArt(arts: List<ArtModel>)

    suspend fun deleteArt(art: ArtModel)

    suspend fun updateArt(art: ArtModel)

    suspend fun getSavedArts(): List<ArtModel>

    suspend fun getSavedArtWithId(id: Int): ArtModel?

    suspend fun searchImage(query: String): Flow<Resource<ImageResponse>>
}
