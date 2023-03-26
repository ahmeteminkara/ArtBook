package com.aek.artbook.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ArtModel(
    var name: String,
    var artistName: String,
    var year: String,
    var imagePath: String,
    var isFavorite: Boolean,
    @PrimaryKey(true)
    var id: Int? = null
)
