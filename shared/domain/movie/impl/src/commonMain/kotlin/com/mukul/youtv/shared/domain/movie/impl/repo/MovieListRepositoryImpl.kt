package com.mukul.youtv.shared.domain.movie.impl.repo

import com.mukul.youtv.shared.common.models.core.DataState
import com.mukul.youtv.shared.common.models.movie.MovieCategory
import com.mukul.youtv.shared.core.utils.AppCoroutineDispatchers
import com.mukul.youtv.shared.core.utils.CommonFlow
import com.mukul.youtv.shared.core.utils.asCommonFlow
import com.mukul.youtv.shared.core.utils.networkBoundResourceAsFlow
import com.mukul.youtv.shared.data.movie.local.api.MovieListLocalDataSource
import com.mukul.youtv.shared.data.movie.models.Movie
import com.mukul.youtv.shared.data.movie.models.asMovie
import com.mukul.youtv.shared.data.movie.network.api.MovieListNetworkDataSource
import com.mukul.youtv.shared.domain.movie.api.MovieListRepository

class MovieListRepositoryImpl(
    private val dispatchers: AppCoroutineDispatchers,
    private val localDataSource: MovieListLocalDataSource,
    private val networkDataSource: MovieListNetworkDataSource
): MovieListRepository {

    override fun getMovies(
        category: MovieCategory,
        shouldFetch: Boolean
    ): CommonFlow<DataState<List<Movie>?>> {
        return networkBoundResourceAsFlow(
            dispatcher = dispatchers.default,
            query = { localDataSource.getMovies() },
            fetch = { networkDataSource.getMovies(category) },
            shouldFetch = { shouldFetch },
            saveFetchResult = {
                val movies = it.movies?.map { movie ->
                    movie.asMovie()
                }?.also { list ->
                    localDataSource.insert(
                        list = list
                    )
                }
                movies
            }
        ).asCommonFlow(
            dispatcher = dispatchers.default
        )
    }
}