package com.henriquemapa.presentation.ui.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.henriquemapa.presentation.UiState
import com.henriquemapa.presentation.viewmodel.MoviesViewModel

@Composable
fun MoviesScreen(
    viewModel: MoviesViewModel,
    onMovieClick: (Int) -> Unit
) {
    val state by viewModel.uiState.collectAsState()

    when (val result = state) {
        is UiState.Loading -> {
            MovieScreenLoading()
        }

        is UiState.Success -> {
            MoviesScreenSuccess(
                movies = result.data,
                onMovieClick = onMovieClick,
            )
        }

        is UiState.Error -> {
            MovieScreenError(result)
        }
    }
}


