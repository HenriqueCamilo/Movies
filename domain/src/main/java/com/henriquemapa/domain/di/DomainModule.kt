package com.henriquemapa.domain.di

import com.henriquemapa.domain.usecase.GetMovieDetailUseCase
import org.koin.dsl.module
import com.henriquemapa.domain.usecase.GetTrendingMoviesUseCase

val domainModule = module {
    factory { GetTrendingMoviesUseCase(get()) }
    factory { GetMovieDetailUseCase(get()) }
}