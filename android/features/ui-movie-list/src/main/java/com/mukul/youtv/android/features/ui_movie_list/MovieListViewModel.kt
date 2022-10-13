package com.mukul.youtv.android.features.ui_movie_list

import androidx.lifecycle.ViewModel
import com.mukul.jan.youtv.android.base.AndroidAppCoroutineDispatchers
import com.mukul.youtv.shared.base.Paginator
import com.mukul.youtv.shared.base.PaginatorConfig
import com.mukul.youtv.shared.data.movie.models.Movie
import com.mukul.youtv.shared.domain.movie.impl.usecase.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val dispatchers: AndroidAppCoroutineDispatchers,
    private val getMoviesUseCase: GetMovieListUseCase
) : ViewModel() {

    private val mainScope = CoroutineScope(dispatchers.io)

    private var paginator: Paginator? = null
    private val pagingConfig = PaginatorConfig(
        limit = 20
    )

    private val _state = MutableStateFlow(MovieListUiState.EMPTY)
    val state: StateFlow<MovieListUiState> get() = _state

    private fun initPaginator() {
        paginator = Paginator.build(
            scope = mainScope,
            config = pagingConfig,
            onApiCall = { page ->
                val result = getMovies(page.page + 1)
                if (result.isNullOrEmpty()) {
                    page.page
                } else {
                    appendMovies(result)
                    page.page + 1
                }
            }
        )
    }

    fun onScrollPositionChange(position: Int) {
        paginator?.onScrollPositionChange(position)
    }

    private suspend fun getMovies(page: Int): List<Movie>? {
        return getMoviesUseCase.execute(
            params = GetMovieListUseCase.Params(
                page = page,
                limit = pagingConfig.limit
            )
        )
    }

    private fun appendMovies(movies: List<Movie>?) {
        if (!movies.isNullOrEmpty()) {
            val current = state.value.movies.toMutableList()
            current.addAll(movies)
            _state.value = state.value.copy(movies = current)
        }
    }

    init {
        initPaginator()
    }

    override fun onCleared() {
        mainScope.cancel()
        super.onCleared()
    }

}