package com.aek.artbook.data.db

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.aek.artbook.data.model.ArtModel

@Database(
    entities = [ArtModel::class],
    version = 2,
    exportSchema = false
)
abstract class ArtDatabase : RoomDatabase() {

    abstract fun artDao(): ArtDao
}
