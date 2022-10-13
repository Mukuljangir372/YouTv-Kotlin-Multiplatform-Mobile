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
                page = it.page.toLong(),
                title = it.title ?: "",
                overview = it.overview ?: "",
                poster = it.poster ?: "",
                category = it.category
            )
        }
        return list
    }

    override fun getMovies(category: String, limit: Int, page: Int): List<Movie> {
        return queries.getMovies(
            category = category,
            page = page.toLong(),
        ).executeAsList().map {
            it.asMovie()
        }
    }
}