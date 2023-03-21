package com.aek.artbook.data.repository

import com.aek.artbook.data.ErrorModel
import com.aek.artbook.data.Resource
import com.aek.artbook.data.api.ImageService
import com.aek.artbook.data.db.ArtDao
import com.aek.artbook.data.model.ImageResponse
import com.aek.artbook.domain.ArtModel
import com.aek.artbook.utils.const.AppConstants
import com.aek.artbook.utils.extentions.handleResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ArtRepositoryImpl @Inject constructor(
    private val imageService: ImageService,
    private val artDao: ArtDao

) : ArtRepository {
    override suspend fun insertArt(art: ArtModel) {
        artDao.insert(art)
    }

    override suspend fun deleteArt(art: ArtModel) {
        artDao.delete(art)
    }

    override suspend fun searchImage(query: String): Flow<Resource<ImageResponse>> {
        return flow {
            val data = try {
                imageService.searchImage(AppConstants.Service.API_KEY, query).handleResponse()
            } catch (ex: Exception) {
                val errorModel = ErrorModel(AppConstants.ErrorMessage.ERROR_MESSAGE_UNKNOWN, 501)
                Resource.Error(errorModel)
            }
            emit(data)
        }
    }
}