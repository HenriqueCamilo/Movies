package com.henriquemapa.data.repository

import com.henriquemapa.data.remote.mapper.toDomain
import com.henriquemapa.data.remote.network.MovieService
import com.henriquemapa.domain.model.Movie
import com.henriquemapa.domain.model.MovieDetail
import com.henriquemapa.domain.repository.MovieRepository
import com.henriquemapa.domain.util.MoviesResult
import com.henriquemapa.movies.data.BuildConfig

class MovieRepositoryImpl(
    private val movieService: MovieService
) : MovieRepository {

    override suspend fun getTrendingMovies(): MoviesResult<List<Movie>> {
        return try {
            val response = movieService.getTrendingMovies(BuildConfig.TMDB_API_KEY)
            val movies = response.results.map { it.toDomain() }
            MoviesResult.success(movies)
        } catch (e: Exception) {
            MoviesResult.failure(e)
        }
    }

    override suspend fun getMovieDetail(movieId: Int): MoviesResult<MovieDetail> {
        return try {
            val response = movieService.getMovieDetail(movieId, BuildConfig.TMDB_API_KEY)
            MoviesResult.success(response.toDomain())
        } catch (e: Exception) {
            MoviesResult.failure(e)
        }
    }
}
