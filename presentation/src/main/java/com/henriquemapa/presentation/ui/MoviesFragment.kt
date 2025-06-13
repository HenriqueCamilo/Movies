package com.henriquemapa.presentation.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.henriquemapa.presentation.ui.composables.MoviesScreen
import com.henriquemapa.presentation.viewmodel.MoviesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesFragment : Fragment() {

    private val viewModel: MoviesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MoviesScreen(
                    viewModel,
                    onMovieClick = { movieId ->
                        onMovieClick(movieId)
                    }
                )
            }
        }
    }

    private fun onMovieClick(movieId: Int) {
        val action = MoviesFragmentDirections.actionMoviesFragmentToMovieDetailFragment(movieId)
        findNavController().navigate(action)
    }

}