package com.mukul.youtv.android.inject.shared

import com.mukul.youtv.shared.domain.movie.api.MovieListRepository
import com.mukul.youtv.shared.domain.movie.impl.usecase.GetMovieListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedUseCaseInjectModule {

    @Provides
    @Singleton
    fun getMovies(repo: MovieListRepository): GetMovieListUseCase {
        return GetMovieListUseCase(repo)
    }

}