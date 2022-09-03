package com.mukul.youtv.shared.core.database

import com.squareup.sqldelight.Query
import com.squareup.sqldelight.Transacter
import kotlin.Any
import kotlin.Long
import kotlin.String
import kotlin.Unit

public interface MovieEntityQueries : Transacter {
  public fun <T : Any> getMovies(mapper: (
    id: Long,
    title: String,
    overview: String,
    poster: String
  ) -> T): Query<T>

  public fun getMovies(): Query<MovieEntity>

  public fun insertMovie(
    id: Long?,
    title: String,
    overview: String,
    poster: String
  ): Unit
}
