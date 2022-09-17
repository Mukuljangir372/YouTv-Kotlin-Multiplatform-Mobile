package com.mukul.youtv.android.features.ui_movie_list

import androidx.lifecycle.ViewModel
import com.mukul.youtv.shared.domain.movie.impl.usecase.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class MovieListViewModel(
    private val getMovies: GetMovieListUseCase
): ViewModel() {

}