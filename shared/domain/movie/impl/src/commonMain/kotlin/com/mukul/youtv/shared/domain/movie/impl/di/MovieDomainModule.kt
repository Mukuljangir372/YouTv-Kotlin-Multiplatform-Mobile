package com.mukul.youtv.shared.domain.movie.impl.di

import com.mukul.youtv.shared.core.utils.AppCoroutineDispatchers
import com.mukul.youtv.shared.data.movie.local.api.MovieListLocalDataSource
import com.mukul.youtv.shared.data.movie.network.api.MovieListNetworkDataSource
import com.mukul.youtv.shared.domain.movie.api.MovieListRepository
import com.mukul.youtv.shared.domain.movie.impl.repo.MovieListRepositoryImpl
import com.mukul.youtv.shared.tmdb.TmdbEndpoints
import org.koin.dsl.module

val movieDomainModule by lazy {
    module {
        single { movieListRepository(get(), get(), get(), get()) }
    }
}
private fun movieListRepository(
    tmdbEndpoints: TmdbEndpoints,
    dispatchers: AppCoroutineDispatchers,
    networkSource: MovieListNetworkDataSource,
    localSource: MovieListLocalDataSource,
): MovieListRepository {
    return MovieListRepositoryImpl(
        tmdbEndpoints = tmdbEndpoints,
        dispatchers = dispatchers,
        networkDataSource = networkSource,
        localDataSource = localSource
    )
}