package com.aek.artbook.repository.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Art(
    @PrimaryKey(true)
    var id: Int? = null,
    var name: String,
    var artistName: String,
    var imagePath: String
)
