package com.mukul.youtv.android.features.ui_movie_list

import com.mukul.youtv.android.common.ui.model.UiMessage
import com.mukul.youtv.shared.data.movie.models.Movie

data class MovieListUiState(
    val loading: Boolean = true,
    val uiMsg: UiMessage = UiMessage.EMPTY,
    val movies: List<Movie> = emptyList(),
) {
    companion object {
        val EMPTY = MovieListUiState()
    }
}