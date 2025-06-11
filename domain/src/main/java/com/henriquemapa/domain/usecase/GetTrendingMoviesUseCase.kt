package com.henriquemapa.domain.usecase

import com.henriquemapa.domain.model.Movie
import com.henriquemapa.domain.repository.MovieRepository
import com.henriquemapa.domain.util.MoviesResult


class GetTrendingMoviesUseCase(
    private val repository: MovieRepository
) : MovieUseCase<List<Movie>, Unit>() {

    override suspend fun run(params: Unit): MoviesResult<List<Movie>> {
        return repository.getTrendingMovies()
    }
}
