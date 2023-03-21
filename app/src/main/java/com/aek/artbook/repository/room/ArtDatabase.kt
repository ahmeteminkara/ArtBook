package com.aek.artbook.repository.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aek.artbook.repository.model.Art

@Database(
    entities = [Art::class],
    version = 1,
    exportSchema = false
)
abstract class ArtDatabase : RoomDatabase() {

    abstract fun artDao(): ArtDao
}
