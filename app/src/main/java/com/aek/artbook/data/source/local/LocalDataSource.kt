package com.aek.artbook.data.source.local

import com.aek.artbook.domain.ArtModel

interface LocalDataSource {
    suspend fun insertArt(art: ArtModel)

    suspend fun insertArt(arts: List<ArtModel>)

    suspend fun deleteArt(art: ArtModel)

    suspend fun updateArt(art: ArtModel)

    suspend fun getSavedArts(): List<ArtModel>
}
