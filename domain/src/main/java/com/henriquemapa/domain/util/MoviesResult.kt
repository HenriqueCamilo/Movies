package com.henriquemapa.domain.util

sealed class MoviesResult<out T> {
    data class Success<out T>(val data: T) : MoviesResult<T>()
    data class Error(val message: String, val throwable: Throwable? = null) : MoviesResult<Nothing>()
    data object Loading : MoviesResult<Nothing>()
}
