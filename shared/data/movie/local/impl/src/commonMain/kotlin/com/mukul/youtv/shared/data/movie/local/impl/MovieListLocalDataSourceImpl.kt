package com.mukul.youtv.shared.data.movie.local.impl

import com.mukul.youtv.shared.core.database.YouTvAppDatabase
import com.mukul.youtv.shared.data.movie.local.api.MovieListLocalDataSource
import com.mukul.youtv.shared.data.movie.local.impl.mapper.asMovie
import com.mukul.youtv.shared.data.movie.models.Movie

class MovieListLocalDataSourceImpl(
    private val database: YouTvAppDatabase
): MovieListLocalDataSource {
    private val queries = database.movieEntityQueries

    override fun insert(list: List<Movie>): List<Movie> {
        list.forEach {
            queries.insertMovie(
                id = it.id.toLong(),
                title = it.title ?: "",
                overview = it.overview ?: "",
                poster = it.poster ?: ""
            )
        }
        return list
    }

    override fun getMovies(): List<Movie> {
        return queries.getMovies().executeAsList().map {
            it.asMovie()
        }
    }
}