package com.aek.artbook.extentions

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

fun <T> Fragment.getNavigationResult(key: String) =
    findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<T>(key)

fun <T> Fragment.setNavigationResultToBack(key: String, result: T) {
    findNavController().previousBackStackEntry?.savedStateHandle?.set(key, result)
    findNavController().popBackStack()
}
