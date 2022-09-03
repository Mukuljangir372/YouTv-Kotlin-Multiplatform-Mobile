package com.mukul.youtv.shared.data.movie.local.impl.di

import com.mukul.youtv.shared.core.database.YouTvAppDatabase
import com.mukul.youtv.shared.data.movie.local.api.MovieListLocalDataSource
import com.mukul.youtv.shared.data.movie.local.impl.MovieListLocalDataSourceImpl
import org.koin.dsl.module

val movieLocalModule = module {
    single { movieListLocalDataSource(get()) }
}
private fun movieListLocalDataSource(
    database: YouTvAppDatabase
): MovieListLocalDataSource {
    return MovieListLocalDataSourceImpl(
        database = database
    )
}