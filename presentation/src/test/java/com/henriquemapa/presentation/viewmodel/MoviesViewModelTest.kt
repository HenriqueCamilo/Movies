package com.henriquemapa.presentation.viewmodel

import com.henriquemapa.domain.model.Movie
import com.henriquemapa.domain.usecase.GetTrendingMoviesUseCase
import com.henriquemapa.domain.util.MoviesResult
import com.henriquemapa.presentation.UiState
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class MoviesViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var viewModel: MoviesViewModel
    private val getTrendingMoviesUseCase: GetTrendingMoviesUseCase = mockk(relaxed = true)

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        viewModel = MoviesViewModel(getTrendingMoviesUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getMovies should emit Success when return success`() = runTest {
        val mockMovies = listOf(
            Movie(1, "Filme 1", "Desc", "url", "5.0")
        )

        coEvery { getTrendingMoviesUseCase.invoke(Unit) } returns MoviesResult.success(mockMovies)

        viewModel.getMovies()

        advanceUntilIdle()

        assert(viewModel.uiState.value is UiState.Success)
        val state = viewModel.uiState.value as UiState.Success
        assertEquals(mockMovies, state.data)
    }

    @Test
    fun `getMovies should emit Error when return error`() = runTest {
        val throwable = Throwable("Erro")

        coEvery { getTrendingMoviesUseCase.invoke(Unit) } returns MoviesResult.failure(throwable)

        viewModel.getMovies()

        advanceUntilIdle()

        assert(viewModel.uiState.value is UiState.Error)
        val state = viewModel.uiState.value as UiState.Error
        assertEquals("Erro", state.message)
    }
}