package com.henriquemapa.presentation.ui.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.henriquemapa.presentation.UiState
import com.henriquemapa.presentation.viewmodel.MovieDetailViewModel

@Composable
fun MovieDetailScreen(
    viewModel: MovieDetailViewModel,
) {
    val state by viewModel.uiState.collectAsState()

    when (val result = state) {
        is UiState.Loading -> {
            MovieScreenLoading()
        }

        is UiState.Success -> {
            MovieDetailScreenSuccess(
                movie = result.data,
            )
        }

        is UiState.Error -> {
            MovieScreenError(result)
        }
    }
}


