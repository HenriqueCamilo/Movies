package com.henriquemapa.data.remote.mapper

import com.henriquemapa.data.remote.dto.MovieDetailResponse
import com.henriquemapa.data.remote.dto.MovieResponse
import com.henriquemapa.domain.model.Movie
import com.henriquemapa.domain.model.MovieDetail


fun MovieResponse.toDomain(): Movie {
    return Movie(
        id = id,
        title = title,
        overview = overview,
        posterUrl = posterPath?.let { "https://image.tmdb.org/t/p/w500$it" },
        rating = voteAverage.toString()
    )
}

fun MovieDetailResponse.toDomain(): MovieDetail {
    return MovieDetail(
        id = id,
        title = title,
        overview = overview,
        posterUrl = posterPath?.let { "https://image.tmdb.org/t/p/w500$it" },
        rating = voteAverage.toString(),
        releaseDate = releaseDate,
        originalLanguage = "en",
        runtime = runtime
    )
}