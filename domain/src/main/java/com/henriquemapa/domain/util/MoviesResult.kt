package com.henriquemapa.domain.util

sealed class MoviesResult<out T> {
    data class Success<out T>(val data: T): MoviesResult<T>()
    data class Error(val throwable: Throwable): MoviesResult<Nothing>()

    companion object {
        fun <T> failure(throwable: Throwable): MoviesResult<T> = Error(throwable)
    }
}

