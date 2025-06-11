package com.henriquemapa.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    @SerializedName("results")
    val results: List<MovieResponse>
)