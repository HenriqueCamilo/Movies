package com.henriquemapa.presentation.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.henriquemapa.presentation.ui.composables.MovieDetailScreen
import com.henriquemapa.presentation.viewmodel.MovieDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailFragment : Fragment() {

    private val args: MovieDetailFragmentArgs by navArgs()
    private val viewModel: MovieDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getMovieDetail(args.movieId)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        return ComposeView(requireContext()).apply {
            setContent {
                MovieDetailScreen(
                    viewModel
                )
            }
        }
    }
}
