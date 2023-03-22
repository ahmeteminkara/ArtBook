package com.aek.artbook.utils.extentions

fun String?.ignoreNull(default: String = "") = this ?: default
fun Boolean?.ignoreNull(default: Boolean = false) = this ?: default
