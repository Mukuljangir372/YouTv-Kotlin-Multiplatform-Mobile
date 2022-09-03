package com.mukul.youtv.shared.data.movie.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkMovies(
    @SerialName("results")
    val movies: List<NetworkMovie>? = null
)
