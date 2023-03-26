package com.aek.artbook.extentions

fun Int?.ignoreNull(defaultValue: Int = 0): Int = this ?: defaultValue
fun Int.isOdd() = this % 2 != 0
fun Int.isEven() = this % 2 == 0
