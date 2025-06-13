package com.henriquemapa.domain.usecase

import com.henriquemapa.domain.model.MovieDetail
import com.henriquemapa.domain.repository.MovieRepository
import com.henriquemapa.domain.util.MoviesResult

class GetMovieDetailUseCase(
    private val repository: MovieRepository
) : MovieUseCase<MovieDetail, Int>() {

    override suspend fun run(params: Int): MoviesResult<MovieDetail> {
        return repository.getMovieDetail(params)
    }
}