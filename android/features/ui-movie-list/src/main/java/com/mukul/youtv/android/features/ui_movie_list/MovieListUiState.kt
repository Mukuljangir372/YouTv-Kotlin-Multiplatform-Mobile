package com.mukul.youtv.android.features.ui_movie_list

import com.mukul.youtv.shared.data.movie.models.Movie

data class MovieListUiState(
    var movies: List<Movie> = emptyList(),
    var loading: Boolean = true
)