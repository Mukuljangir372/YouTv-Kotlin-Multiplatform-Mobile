package com.mukul.youtv.shared.data.movie.network.impl.service

import com.mukul.youtv.shared.data.movie.network.api.service.MovieListWebService
import com.mukul.youtv.shared.tmdb.TmdbEndpoints
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class MovieListWebServiceImpl(
    private val tmdb: TmdbEndpoints,
    private val client: HttpClient
): MovieListWebService {
    override suspend fun getMovies(
        category: String,
        limit: Int,
        page: Int,
    ): HttpResponse {
        return client.get("${tmdb.baseUrl}/${tmdb.movie}/${category}") {
            parameter(tmdb.apiKey, tmdb.tmdbApiKey)
            parameter("page",page)
        }
    }
}