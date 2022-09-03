package com.mukul.youtv.di

import com.mukul.youtv.shared.core.database.DatabaseFactory
import com.mukul.youtv.shared.core.database.DriverFactory
import com.mukul.youtv.shared.core.network.di.coreNetworkModule
import com.mukul.youtv.shared.core.utils.di.coreUtilModule
import com.mukul.youtv.shared.data.movie.local.impl.di.movieLocalModule
import com.mukul.youtv.shared.data.movie.network.impl.di.movieNetworkModule
import com.mukul.youtv.shared.domain.movie.impl.di.movieDomainModule
import com.mukul.youtv.shared.tmdb.di.tmdbModule
import org.koin.dsl.module

internal fun koinModules() = arrayListOf(
    coreNetworkModule,
    coreUtilModule,
    movieLocalModule,
    movieNetworkModule,
    movieDomainModule,
    tmdbModule,
)
internal fun getDatabaseModule(
    driverFactory: DriverFactory
) = module {
    single {
        DatabaseFactory(driverFactory).createDatabase()
    }
}