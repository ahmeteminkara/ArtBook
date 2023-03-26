package com.aek.artbook.extentions

fun String?.ignoreNull(default: String = "") = this ?: default
fun Boolean?.ignoreNull(default: Boolean = false) = this ?: default
