package com.henriquemapa.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.henriquemapa.domain.model.Movie
import com.henriquemapa.domain.usecase.GetTrendingMoviesUseCase
import com.henriquemapa.domain.usecase.invoke
import com.henriquemapa.domain.util.onFailure
import com.henriquemapa.domain.util.onSuccess
import com.henriquemapa.presentation.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MoviesViewModel(
    private val getTrendingMoviesUseCase: GetTrendingMoviesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<Movie>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<Movie>>> = _uiState


    init {
        getMovies()
    }

    fun getMovies() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            getTrendingMoviesUseCase.invoke()
                .onSuccess { movies ->
                    _uiState.value = UiState.Success(movies)
                }
                .onFailure { error ->
                    _uiState.value = UiState.Error(error.message)
                }
        }
    }
}
