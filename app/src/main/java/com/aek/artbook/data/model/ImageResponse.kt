package com.aek.artbook.data.model

data class ImageResponse(
    val hits: List<Image>,
    val total: Int?,
    val totalHits: Int?
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
