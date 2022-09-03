package com.mukul.youtv.shared.domain.movie.api

import com.mukul.youtv.shared.common.models.core.DataState
import com.mukul.youtv.shared.common.models.movie.MovieCategory
import com.mukul.youtv.shared.core.utils.CommonFlow
import com.mukul.youtv.shared.data.movie.models.Movie

interface MovieListRepository {
    fun getMovies(
        category: MovieCategory,
        shouldFetch: Boolean
    ): CommonFlow<DataState<List<Movie>?>>
}