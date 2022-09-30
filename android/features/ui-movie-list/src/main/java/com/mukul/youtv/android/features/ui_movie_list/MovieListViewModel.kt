package com.mukul.youtv.android.features.ui_movie_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mukul.youtv.shared.domain.movie.impl.usecase.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getMoviesUseCase: GetMovieListUseCase
): ViewModel() {

    init {
        getMovies()
    }

    private val pageLimit = 20

    val state: StateFlow<MovieListUiState> = combine(
        getMovies()
    ) { moviesState ->
        MovieListUiState(
            movies = moviesState[0].data ?: emptyList()
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = MovieListUiState.EMPTY
    )

    private fun getMovies(
        page: Int = 1,
    ) = getMoviesUseCase.execute(
        params = GetMovieListUseCase.Params(
            page = page,
            limit = pageLimit
        )
    )
}