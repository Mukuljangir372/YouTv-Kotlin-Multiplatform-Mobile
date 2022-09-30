package com.mukul.youtv.shared.domain.movie.impl.usecase

import com.mukul.youtv.shared.base.Interactor
import com.mukul.youtv.shared.common.models.core.DataState
import com.mukul.youtv.shared.common.models.movie.MovieCategory
import com.mukul.youtv.shared.core.utils.CommonFlow
import com.mukul.youtv.shared.data.movie.models.Movie
import com.mukul.youtv.shared.domain.movie.api.MovieListRepository

class GetMovieListUseCase(
    private val repo: MovieListRepository
) : Interactor<CommonFlow<DataState<List<Movie>?>>, GetMovieListUseCase.Params>() {
    override fun doWork(params: Params): CommonFlow<DataState<List<Movie>?>> {
        return repo.getMovies(
            category = params.category,
            shouldFetch = params.shouldFetch
        )
    }
    class Params(
        val category: MovieCategory = MovieCategory.Popular,
        val shouldFetch: Boolean = true,
        val limit: Int = 20,
        val page: Int = 1,
    )
}