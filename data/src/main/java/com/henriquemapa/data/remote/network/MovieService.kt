package com.henriquemapa.data.remote.network

import com.henriquemapa.data.remote.dto.MovieDetailResponse
import com.henriquemapa.data.remote.dto.MoviesResponse
import com.henriquemapa.movies.data.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET("trending/movie/day")
    suspend fun getTrendingMovies(
        @Query("api_key") apiKey: String
    ): MoviesResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
    ): MovieDetailResponse
}

