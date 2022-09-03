package com.mukul.youtv.shared.core.database

import kotlin.Long
import kotlin.String

public data class MovieEntity(
  public val id: Long,
  public val title: String,
  public val overview: String,
  public val poster: String
) {
  public override fun toString(): String = """
  |MovieEntity [
  |  id: $id
  |  title: $title
  |  overview: $overview
  |  poster: $poster
  |]
  """.trimMargin()
}
