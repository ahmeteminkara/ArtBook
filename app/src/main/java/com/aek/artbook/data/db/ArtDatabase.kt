package com.aek.artbook.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aek.artbook.domain.ArtModel

@Database(
    entities = [ArtModel::class],
    version = 1,
    exportSchema = false
)
abstract class ArtDatabase : RoomDatabase() {

    abstract fun artDao(): ArtDao
}
