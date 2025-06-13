package com.henriquemapa.domain.model

data class MovieDetail(
    val id: Int,
    val title: String,
    val overview: String,
    val posterUrl: String?,
    val rating: String,
    val releaseDate: String,
    val originalLanguage: String,
    val runtime: Int? = 0
)
