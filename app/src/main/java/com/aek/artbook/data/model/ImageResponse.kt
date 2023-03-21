package com.aek.artbook.data.model

data class ImageResponse(
    val hints: List<Image>,
    val total: Int?,
    val totalHints: Int?
)

data class Image(
    val id: Int?,
    val previewURL: String?,
    val previewWidth: Int?,
    val previewHeight: Int?,
    val largeImageURL: String?,
    val imageWidth: Int?,
    val imageHeight: Int?
)
