package com.aek.artbook.repository.room

import androidx.room.Dao
import androidx.room.Query
import com.aek.artbook.repository.entity.Art

@Dao
interface ArtDao : BaseDao<Art> {

    @Query("select * from art")
    override suspend fun getAll(): List<Art>

    @Query("select * from art where id = :id")
    override suspend fun getWithId(id: Int): Art
}
