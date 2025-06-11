package com.henriquemapa.presentation.ui.composables


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.henriquemapa.domain.model.Movie
import com.henriquemapa.presentation.MoviesUiState
import com.henriquemapa.presentation.viewmodel.MoviesViewModel

@Composable
fun MoviesScreen(viewModel: MoviesViewModel) {
    val state by viewModel.uiState.collectAsState()

    when (val result = state) {
        is MoviesUiState.Loading -> {

        }
        is MoviesUiState.Success -> {
            MoviesScreenSuccess(movies = result.movies)
        }
        is MoviesUiState.Error -> {

        }
    }
}


@Composable
fun MoviesScreenSuccess(movies: List<Movie>){

}

