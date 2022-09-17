package com.mukul.youtv.android.inject.shared

import com.mukul.youtv.graph.RepositoryGraph
import com.mukul.youtv.shared.domain.movie.api.MovieListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedInjectModule {

    @Provides
    @Singleton
    fun repositoryGraph(): RepositoryGraph {
        return RepositoryGraph()
    }

    @Provides
    @Singleton
    fun movieListRepository(graph: RepositoryGraph) : MovieListRepository {
        return graph.getMovieListRepo()
    }
}