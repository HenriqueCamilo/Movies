package com.henriquemapa.presentation.ui.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun InfoMovieRow(label: String, value: String) {
    Row(modifier = Modifier.padding(vertical = 4.dp)) {
        Text(
            text = "$label: ",
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}