package com.henriquemapa.domain.di

import org.koin.dsl.module
import com.henriquemapa.domain.usecase.GetTrendingMoviesUseCase

val domainModule = module {
    factory { GetTrendingMoviesUseCase(get()) }
}