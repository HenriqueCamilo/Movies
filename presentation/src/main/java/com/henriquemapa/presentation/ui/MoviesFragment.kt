package com.henriquemapa.presentation.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.henriquemapa.presentation.ui.composables.MoviesScreen
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.henriquemapa.presentation.viewmodel.MoviesViewModel

class MoviesFragment : Fragment() {

    private val viewModel: MoviesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MoviesScreen(viewModel)
            }
        }
    }

}