package com.aek.artbook.data.source.local

import com.aek.artbook.data.db.ArtDao
import com.aek.artbook.data.model.ArtModel

class LocalDataSourceImpl(private val dao: ArtDao) : LocalDataSource {
    override suspend fun insertArt(art: ArtModel) = dao.insert(art)

    override suspend fun insertArt(arts: List<ArtModel>) = dao.insert(arts)

    override suspend fun deleteArt(art: ArtModel) = dao.delete(art)

    override suspend fun updateArt(art: ArtModel) = dao.update(art)

    override suspend fun getSavedArts(): List<ArtModel> = dao.getAll()
}
