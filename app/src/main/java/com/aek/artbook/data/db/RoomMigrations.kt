package com.aek.artbook.data.db

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

object RoomMigrations {
    val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE ArtModel ADD COLUMN isFavorite INTEGER NOT NULL DEFAULT(0)")
        }
    }
}