package com.aek.artbook.repository.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aek.artbook.repository.entity.Art

@Database(
    entities = [Art::class],
    version = 1
)
abstract class ArtDatabase(context: Context) : RoomDatabase() {

    abstract fun artDao(): ArtDao

    protected lateinit var db: ArtDatabase

    init {
        db = Room.databaseBuilder(
            context,
            this.javaClass,
            this.javaClass.simpleName
        ).build()
    }
}
