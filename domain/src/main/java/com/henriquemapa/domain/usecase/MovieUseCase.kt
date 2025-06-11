package com.henriquemapa.domain.usecase

import com.henriquemapa.domain.util.MoviesResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class MovieUseCase<out T, in P> {
    protected abstract suspend fun run(params: P): MoviesResult<T>

    suspend operator fun invoke(params: P): MoviesResult<T> = withContext(Dispatchers.IO) {
        runCatching {
            run(params)
        }.getOrElse { MoviesResult.failure(it) }
    }
}

suspend operator fun <T> MovieUseCase<T, Unit>.invoke(): MoviesResult<T> {
    return invoke(Unit)
}

