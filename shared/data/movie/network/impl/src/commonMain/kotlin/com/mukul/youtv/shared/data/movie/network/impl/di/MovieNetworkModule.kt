package com.mukul.youtv.shared.data.movie.network.impl.di

import com.mukul.youtv.shared.core.utils.AppCoroutineDispatchers
import com.mukul.youtv.shared.data.movie.network.api.MovieListNetworkDataSource
import com.mukul.youtv.shared.data.movie.network.api.service.MovieListWebService
import com.mukul.youtv.shared.data.movie.network.impl.MovieListNetworkDataSourceImpl
import com.mukul.youtv.shared.data.movie.network.impl.service.MovieListWebServiceImpl
import com.mukul.youtv.shared.tmdb.TmdbEndpoints
import io.ktor.client.*
import org.koin.dsl.module

val movieNetworkModule = module {
    single { movieListWebService(get(), get()) }
    single { movieListNetworkDataSource(get(), get()) }
}
private fun movieListWebService(
    tmdb: TmdbEndpoints,
    client: HttpClient
): MovieListWebService {
    return MovieListWebServiceImpl(
        tmdb = tmdb,
        client = client
    )
}
private fun movieListNetworkDataSource(
    dispatchers: AppCoroutineDispatchers,
    webService: MovieListWebService
): MovieListNetworkDataSource {
    return MovieListNetworkDataSourceImpl(
        dispatchers = dispatchers,
        webService = webService
    )
}