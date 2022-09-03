package com.mukul.youtv.shared.data.movie.network.impl

import com.mukul.youtv.shared.common.models.core.ApiResult
import com.mukul.youtv.shared.common.models.movie.MovieCategory
import com.mukul.youtv.shared.core.utils.AppCoroutineDispatchers
import com.mukul.youtv.shared.core.utils.safeApiCall
import com.mukul.youtv.shared.data.movie.models.NetworkMovies
import com.mukul.youtv.shared.data.movie.network.api.MovieListNetworkDataSource
import com.mukul.youtv.shared.data.movie.network.api.service.MovieListWebService

class MovieListNetworkDataSourceImpl(
    private val dispatchers: AppCoroutineDispatchers,
    private val webService: MovieListWebService
): MovieListNetworkDataSource {
    override suspend fun getMovies(category: MovieCategory): ApiResult<NetworkMovies> {
        return safeApiCall(dispatcher = dispatchers.default) {
            webService.getMovies(category.categoryName)
        }
    }
}