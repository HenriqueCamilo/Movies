package com.henriquemapa.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.henriquemapa.domain.model.MovieDetail
import com.henriquemapa.domain.usecase.GetMovieDetailUseCase
import com.henriquemapa.domain.util.onFailure
import com.henriquemapa.domain.util.onSuccess
import com.henriquemapa.presentation.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    private val getMovieDetailUseCase: GetMovieDetailUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<MovieDetail>>(UiState.Loading)
    val uiState: StateFlow<UiState<MovieDetail>> = _uiState

    fun getMovieDetail(movieId: Int) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            getMovieDetailUseCase.invoke(movieId)
                .onSuccess { movieDetail ->
                    _uiState.value = UiState.Success(movieDetail)
                }
                .onFailure { error ->
                    _uiState.value = UiState.Error(error.message)
                }
        }
    }
}
