package com.mukul.youtv.shared.data.movie.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkMovie(
    @SerialName("id")
    val id: Int,
    @SerialName("original_title")
    val title: String? = null,
    @SerialName("overview")
    val overview: String? = null,
    @SerialName("poster_path")
    val poster: String? = null
)

fun NetworkMovie.asMovie(
    page: Int,
    category: String,
    customPoster: String,
) : Movie {
    return Movie(
        id = id,
        title = title,
        page = page,
        overview = overview,
        poster = customPoster,
        category = category
    )
}