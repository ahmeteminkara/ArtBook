package com.aek.artbook.data.repository

import com.aek.artbook.data.base.Resource
import com.aek.artbook.data.model.ImageResponse
import com.aek.artbook.data.source.local.LocalDataSource
import com.aek.artbook.data.source.remote.RemoteDataSource
import com.aek.artbook.data.model.ArtModel
import kotlinx.coroutines.flow.Flow

class ArtRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : ArtRepository {
    override suspend fun insertArt(art: ArtModel) = localDataSource.insertArt(art)

    override suspend fun insertArt(arts: List<ArtModel>) = localDataSource.insertArt(arts)

    override suspend fun deleteArt(art: ArtModel) = localDataSource.deleteArt(art)

    override suspend fun updateArt(art: ArtModel) = localDataSource.updateArt(art)

    override suspend fun getSavedArts(): List<ArtModel> = localDataSource.getSavedArts()

    override suspend fun searchImage(query: String): Flow<Resource<ImageResponse>> =
        remoteDataSource.searchImage(query)
}
