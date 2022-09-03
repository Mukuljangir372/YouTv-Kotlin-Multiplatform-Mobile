package com.mukul.youtv.shared.data.movie.network.api.service

import io.ktor.client.statement.*

interface MovieListWebService {
    suspend fun getMovies(category: String): HttpResponse
}