package com.henriquemapa.domain.util

open class MoviesResult<out R> internal constructor(
    val value: Any? = null
) {
    val isSuccess: Boolean get() = value !is Throwable
    val isFailure: Boolean get() = value is Throwable
    
    companion object {
        fun <T> success(value: T): MoviesResult<T> = MoviesResult(value)
        fun <T> failure(throwable: Throwable): MoviesResult<T> = MoviesResult(throwable)
    }
}

@Suppress("UNCHECKED_CAST")
inline fun <T> MoviesResult<T>.onSuccess(action: (T) -> Unit): MoviesResult<T> {
    if (isSuccess) action(value as T)
    return this
}

inline fun <T> MoviesResult<T>.onFailure(action: (Throwable) -> Unit): MoviesResult<T> {
    if (isFailure) action(value as Throwable)
    return this
}
