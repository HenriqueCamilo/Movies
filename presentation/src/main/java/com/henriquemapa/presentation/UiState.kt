package com.henriquemapa.presentation


sealed class UiState<out T> {
    object Loading : UiState<Nothing>()
    data class Success<out T>(val data: T) : UiState<T>()
    data class Error(val message: String? = "Erro desconhecido") : UiState<Nothing>()
}


