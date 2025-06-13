package com.henriquemapa.presentation.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.henriquemapa.domain.model.Movie
import com.henriquemapa.movies.presentation.R

@Composable
fun MovieItem(
    movie: Movie,
    onClick: (Movie) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(90.dp)
            .clickable { onClick(movie) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = movie.posterUrl,
            contentDescription = movie.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .background(Color(0xFFEEEEEE))
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
        ) {
            Text(
                text = movie.title,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF444444)
                ),
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(R.string.movie_poster_rating, movie.rating),
                style = MaterialTheme.typography.bodySmall,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
            )
        }

    }
}

@Preview
@Composable
private fun MovieItemPreview() {
    MovieItem(
        movie = Movie(
            id = 1,
            title = "Exemplo de Filme",
            overview = "Este é um exemplo de descrição de filme que pode ser muito longa e precisa ser truncada.",
            posterUrl = "https://image.tmdb.org/t/p/w500/euM8fJvfH28xhjGy25LiygxfkWc.jpg",
            rating = "4.5"
        ),
        onClick = { }
    )
}