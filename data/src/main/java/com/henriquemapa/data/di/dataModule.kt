package com.henriquemapa.data.di

import com.henriquemapa.data.remote.network.MovieService
import com.henriquemapa.data.repository.MovieRepositoryImpl
import com.henriquemapa.domain.repository.MovieRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<MovieService> {
        get<Retrofit>().create(MovieService::class.java)
    }

    single<MovieRepository> {
        MovieRepositoryImpl(get())
    }
}
