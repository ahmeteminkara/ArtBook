package com.aek.artbook.repository.room

import androidx.room.Dao
import androidx.room.Query
import com.aek.artbook.repository.model.Art

@Dao
interface ArtDao : BaseDao<Art> {

    @Query("select * from art")
    suspend fun getAll(): List<Art>

    @Query("select * from art where id = :id")
    suspend fun getWithId(id: Int): Art
}
