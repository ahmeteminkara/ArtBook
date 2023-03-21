package com.aek.artbook.repository.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aek.artbook.repository.model.Art

@Database(
    entities = [Art::class],
    version = 1,
    exportSchema = false
)
abstract class ArtDatabase : RoomDatabase() {

    abstract fun artDao(): ArtDao

    companion object {
        protected lateinit var db: ArtDatabase

        protected fun invoke(context: Context) {
            db = Room.databaseBuilder(
                context,
                ArtDatabase::class.java,
                "art-db"
            ).build()
        }
    }
}
