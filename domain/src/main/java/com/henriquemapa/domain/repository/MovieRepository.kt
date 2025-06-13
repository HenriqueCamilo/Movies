package com.henriquemapa.domain.repository

import com.henriquemapa.domain.model.Movie
import com.henriquemapa.domain.model.MovieDetail
import com.henriquemapa.domain.util.MoviesResult

interface MovieRepository {
    suspend fun getTrendingMovies(): MoviesResult<List<Movie>>
    suspend fun getMovieDetail(movieId: Int): MoviesResult<MovieDetail>
}
