package com.henriquemapa.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MovieDetailResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("vote_average") val voteAverage: Float,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("original_language") val originalLanguage: String,
    @SerializedName("runtime") val runtime: Int?
)
