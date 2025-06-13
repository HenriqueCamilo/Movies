package com.henriquemapa.presentation.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.henriquemapa.domain.model.MovieDetail
import com.henriquemapa.movies.presentation.R


@Composable
fun MovieDetailScreenSuccess(
    movie: MovieDetail,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        AsyncImage(
            model = movie.posterUrl,
            contentDescription = movie.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = movie.title,
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = movie.overview,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            InfoMovieRow(
                label = stringResource(R.string.original_language_label),
                value = movie.originalLanguage.uppercase()
            )
            InfoMovieRow(
                label = stringResource(R.string.runtime_label),
                value = "${movie.runtime} min"
            )
            InfoMovieRow(label = stringResource(R.string.rating_label), value = movie.rating)
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun MovieDetailScreenSuccessPreview() {
    MovieDetailScreenSuccess(
        movie = MovieDetail(
            id = 1,
            title = "Inception",
            overview = "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a CEO.",
            posterUrl = "https://image.tmdb.org/t/p/w500/9gk7adHYeDvHkCSEqAvQNLV5Uge.jpg",
            rating = "8.3",
            releaseDate = "2010-07-16",
            originalLanguage = "en",
            runtime = 148,
        )
    )
}