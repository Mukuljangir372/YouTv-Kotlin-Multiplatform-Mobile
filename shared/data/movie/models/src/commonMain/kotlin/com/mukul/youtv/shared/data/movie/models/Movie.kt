package com.mukul.youtv.shared.data.movie.models

data class Movie(
    val id: Int,
    val page: Int,
    val title: String?,
    val overview: String?,
    val poster: String?,
    val category: String
)