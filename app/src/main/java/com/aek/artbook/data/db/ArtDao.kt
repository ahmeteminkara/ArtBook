package com.aek.artbook.data.db

import androidx.room.Dao
import androidx.room.Query
import com.aek.artbook.data.model.ArtModel

@Dao
interface ArtDao : BaseDao<ArtModel> {

    @Query("select * from artmodel")
    suspend fun getAll(): List<ArtModel>

    @Query("select * from artmodel where id = :id")
    suspend fun getWithId(id: Int): ArtModel?
}
