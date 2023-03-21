package com.aek.artbook.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ArtModel(
    @PrimaryKey(true)
    var id: Int? = null,
    var name: String,
    var artistName: String,
    var imagePath: String
)
