package com.mukul.youtv.shared.tmdb.di

import com.mukul.youtv.shared.tmdb.TmdbEndpoints
import org.koin.dsl.module

val tmdbModule by lazy {
    module {
        single { TmdbEndpoints() }
    }
}