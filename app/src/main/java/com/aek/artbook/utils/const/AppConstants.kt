package com.aek.artbook.utils.const

object AppConstants {

    object Service {
        const val API_KEY = "34589209-935e87364f8153166d40db8bd"
        const val BASE_URL = "https://pixabay.com"
        const val ENDPOINT_SEARCH = "/api/"
    }

    object ErrorMessage {
        const val ERROR_MESSAGE_UNKNOWN = "Bilinmeyen bir hata oluştu"
    }

    object NavigationResult {
        const val SELECT_IMAGE = "SELECT_IMAGE"
    }

    object Timeout {
        const val SEARCH_CHANGE_LISTENER_TIMEOUT_MS = 1000L
    }
}
