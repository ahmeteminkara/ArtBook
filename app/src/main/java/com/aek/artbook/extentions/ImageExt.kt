package com.aek.artbook.extentions

import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String) {
    Glide.with(this.context)
        .load(url)
        .into(this)
}

fun ImageView.loadImageWithLoading(url: String) {
    val progress = CircularProgressDrawable(this.context).apply {
        strokeWidth = 5f
        centerRadius = 30f
        start()
    }
    Glide.with(this.context)
        .load(url)
        .placeholder(progress)
        .into(this)
}
