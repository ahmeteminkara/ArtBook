package com.aek.artbook.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ArtModel(
    var name: String,
    var artistName: String,
    var year: String,
    var imagePath: String,
    @PrimaryKey(true)
    var id: Int? = null
)
