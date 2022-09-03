package com.mukul.youtv.shared.data.movie.local.impl.mapper

import com.mukul.youtv.shared.data.movie.models.Movie
import commukulyoutvsharedcoredatabase.MovieEntity

internal fun MovieEntity.asMovie(): Movie {
    return Movie(
        id = id.toInt(),
        title = title,
        overview =  overview,
        poster = poster
    )
}