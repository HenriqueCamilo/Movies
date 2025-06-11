package com.henriquemapa.presentation

import com.henriquemapa.domain.model.Movie

sealed class MoviesUiState {
    object Loading : MoviesUiState()
    data class Success(val movies: List<Movie>) : MoviesUiState()
    data class Error(val message: String? = "Erro desconhecido") : MoviesUiState()
}


