package com.mukul.youtv.graph

import com.mukul.youtv.shared.domain.movie.api.MovieListRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RepositoryGraph: KoinComponent {
    private val movieListRepository: MovieListRepository by inject()
    fun getMovieListRepo() = movieListRepository
}