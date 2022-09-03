package com.mukul.youtv.shared.data.movie.local.api

import com.mukul.youtv.shared.data.movie.models.Movie

interface MovieListLocalDataSource {
    fun insert(list: List<Movie>): List<Movie>
    fun getMovies(): List<Movie>
}