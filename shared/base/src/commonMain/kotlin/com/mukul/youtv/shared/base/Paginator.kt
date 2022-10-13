package com.mukul.youtv.shared.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PaginationConfig(
    val limit: Int,
    val page: Int
)
class PaginatorConfig(
    val limit: Int
)
interface PaginationApi {
    fun onScrollPositionChange(position: Int)
}

/**
 * onApiCall: (...) -> Int
 * Make sure while using onApiCall, you must return the currentPage + 1
 * if api call success, else currentPage
 */
class Paginator private constructor(
    private val scope: CoroutineScope,
    private val config: PaginatorConfig,
    private val onApiCall: suspend (config: PaginationConfig) -> Int
): PaginationApi {
    companion object {
        fun build(
            scope: CoroutineScope,
            config: PaginatorConfig,
            onApiCall: suspend (config: PaginationConfig) -> Int
        ): Paginator {
            return Paginator(
                scope = scope,
                config = config,
                onApiCall = onApiCall
            ).also {
                it.tryPaging(
                    force = true
                )
            }
        }
    }

    private var job: Job? = null
    private var currentScrollPosition = 0
    private var currentPage: Int = 0

    private fun tryPaging(force: Boolean) {
        println("Paginator: JobActive ${job?.isActive}")
        println("Paginator: currentScrollPosition $currentScrollPosition")
        println("Paginator: currentPage $currentPage")
        println("Paginator: currentPage * limit ${currentPage * config.limit}")

        if(job?.isActive == true) return
        if(force || ((currentScrollPosition + 1) >= (currentPage * config.limit))) {
            val paging = PaginationConfig(
                limit = config.limit,
                page = currentPage
            )
            job = scope.launch {
                currentPage = onApiCall(paging)
            }
        }
    }

    override fun onScrollPositionChange(position: Int) {
        currentScrollPosition = position
        tryPaging(force = false)
    }
}












