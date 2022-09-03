package com.mukul.youtv.shared.domain.movie.impl.di

import com.mukul.youtv.shared.core.utils.AppCoroutineDispatchers
import com.mukul.youtv.shared.data.movie.local.api.MovieListLocalDataSource
import com.mukul.youtv.shared.data.movie.network.api.MovieListNetworkDataSource
import com.mukul.youtv.shared.domain.movie.api.MovieListRepository
import com.mukul.youtv.shared.domain.movie.impl.MovieListRepositoryImpl
import org.koin.dsl.module

val movieDomainModule by lazy {
    module {
        single { movieListRepository(get(), get(), get()) }
    }
}
private fun movieListRepository(
    dispatchers: AppCoroutineDispatchers,
    networkSource: MovieListNetworkDataSource,
    localSource: MovieListLocalDataSource,
): MovieListRepository {
    return MovieListRepositoryImpl(
        dispatchers = dispatchers,
        networkDataSource = networkSource,
        localDataSource = localSource
    )
}