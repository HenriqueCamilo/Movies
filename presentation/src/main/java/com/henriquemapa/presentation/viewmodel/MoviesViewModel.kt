package com.henriquemapa.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.henriquemapa.domain.usecase.GetTrendingMoviesUseCase
import com.henriquemapa.domain.usecase.invoke
import com.henriquemapa.domain.util.onFailure
import com.henriquemapa.domain.util.onSuccess
import com.henriquemapa.presentation.MoviesUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MoviesViewModel(
    private val getTrendingMoviesUseCase: GetTrendingMoviesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<MoviesUiState>(MoviesUiState.Loading)
    val uiState: StateFlow<MoviesUiState> = _uiState

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            _uiState.value = MoviesUiState.Loading
            getTrendingMoviesUseCase.invoke()
                .onSuccess { comics ->
                    _uiState.value = MoviesUiState.Success(comics)
                }
                .onFailure { error ->
                    _uiState.value = MoviesUiState.Error(error.message)
                }
        }
    }
}
