package com.henriquemapa.presentation.di

import com.henriquemapa.presentation.viewmodel.MoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        MoviesViewModel(get())
    }
}

