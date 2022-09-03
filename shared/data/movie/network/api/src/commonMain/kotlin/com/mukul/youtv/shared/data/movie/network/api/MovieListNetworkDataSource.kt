package com.mukul.youtv.shared.data.movie.network.api

import com.mukul.youtv.shared.common.models.core.ApiResult
import com.mukul.youtv.shared.common.models.movie.MovieCategory
import com.mukul.youtv.shared.data.movie.models.NetworkMovies

interface MovieListNetworkDataSource {
    suspend fun getMovies(category: MovieCategory): ApiResult<NetworkMovies>
}