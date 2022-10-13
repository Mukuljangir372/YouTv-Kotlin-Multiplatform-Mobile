package com.mukul.youtv.shared.domain.movie.impl.repo

import com.mukul.youtv.shared.common.models.movie.MovieCategory
import com.mukul.youtv.shared.core.utils.AppCoroutineDispatchers
import com.mukul.youtv.shared.core.utils.networkBoundResource
import com.mukul.youtv.shared.data.movie.local.api.MovieListLocalDataSource
import com.mukul.youtv.shared.data.movie.models.Movie
import com.mukul.youtv.shared.data.movie.models.asMovie
import com.mukul.youtv.shared.data.movie.network.api.MovieListNetworkDataSource
import com.mukul.youtv.shared.domain.movie.api.MovieListRepository
import com.mukul.youtv.shared.tmdb.TmdbEndpoints

class MovieListRepositoryImpl(
    private val tmdbEndpoints: TmdbEndpoints,
    private val dispatchers: AppCoroutineDispatchers,
    private val localDataSource: MovieListLocalDataSource,
    private val networkDataSource: MovieListNetworkDataSource
) : MovieListRepository {

    override suspend fun getMovies(
        category: MovieCategory,
        shouldFetch: Boolean,
        limit: Int,
        page: Int,
    ): List<Movie>? {
        return networkBoundResource(
            dispatcher = dispatchers.default,
            initialStart = {},
            query = {
                localDataSource.getMovies(
                    category = category.categoryName,
                    limit = limit,
                    page = page
                )
            },
            fetch = {
                networkDataSource.getMovies(
                    category = category,
                    limit = limit,
                    page = page
                )
            },
            shouldFetch = {
                shouldFetch
            },
            saveFetchResult = {
                val movies = it.movies?.map { movie ->
                    movie.asMovie(
                        page = page,
                        category = category.categoryName,
                        customPoster = tmdbEndpoints.posterBaseUrl + movie.poster
                    )
                }?.also { list ->
                    localDataSource.insert(
                        list = list,
                    )
                }
                movies
            },
            onFetchFailed = {}
        )
    }
}