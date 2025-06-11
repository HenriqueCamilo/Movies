package com.henriquemapa.data.remote.network

import com.henriquemapa.data.remote.dto.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("trending/movie/day")
    suspend fun getTrendingMovies(
        @Query("api_key") apiKey: String
    ): MoviesResponse
}

