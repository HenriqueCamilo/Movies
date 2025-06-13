package com.henriquemapa.presentation.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.henriquemapa.domain.model.Movie
import com.henriquemapa.movies.presentation.R


@Composable
fun MoviesScreenSuccess(
    movies: List<Movie>,
    onMovieClick: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(
            text = stringResource(id = R.string.trending_movies_title),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .padding(16.dp)
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentPadding = PaddingValues(vertical = 16.dp)

        ) {
            items(movies){ movie ->
                MovieItem(
                    movie = movie,
                    onClick = {
                        onMovieClick(it.id)
                    }

                )
                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
                    thickness = 1.dp,
                    color = Color(0xFFE0E0E0)
                )
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
private fun MoviesScreenSuccessPreview() {
    MoviesScreenSuccess(
        movies = listOf(
            Movie(id = 1, title = "Movie 1", overview = "", posterUrl = "https://image.tmdb.org/t/p/w500/euM8fJvfH28xhjGy25LiygxfkWc.jpg", rating = "4.5"),
            Movie(id = 2, title = "Movie 2", overview = "", posterUrl = "https://image.tmdb.org/t/p/w500/euM8fJvfH28xhjGy25LiygxfkWc.jpg", rating = "4.5"),
            Movie(id = 3, title = "Movie 3", overview = "", posterUrl = "https://image.tmdb.org/t/p/w500/euM8fJvfH28xhjGy25LiygxfkWc.jpg", rating = "4.5"),
            Movie(id = 4, title = "Movie 4", overview = "", posterUrl = "https://image.tmdb.org/t/p/w500/euM8fJvfH28xhjGy25LiygxfkWc.jpg", rating = "4.5")
        ),
        onMovieClick = {}
    )
}