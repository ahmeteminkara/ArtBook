package com.aek.artbook.repository.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

@Dao
interface BaseDao<T> {

    @Insert
    suspend fun insert(item: List<T>)

    @Insert
    suspend fun insert(item: T)

    @Delete
    suspend fun delete(item: T)

    @Update
    suspend fun update(item: T)
}
