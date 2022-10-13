package com.mukul.youtv.shared.domain.movie.api

import com.mukul.youtv.shared.common.models.movie.MovieCategory
import com.mukul.youtv.shared.data.movie.models.Movie

interface MovieListRepository {
    suspend fun getMovies(category: MovieCategory, shouldFetch: Boolean, limit: Int, page: Int, ): List<Movie>?
}