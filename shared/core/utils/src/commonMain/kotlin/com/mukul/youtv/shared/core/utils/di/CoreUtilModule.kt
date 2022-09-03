package com.mukul.youtv.shared.core.utils.di

import com.mukul.youtv.shared.core.utils.AppCoroutineDispatchers
import com.mukul.youtv.shared.core.utils.Platform
import org.koin.dsl.module

val coreUtilModule = module {
    single {
        provideAppCoroutineDispatcher()
    }
}
private fun provideAppCoroutineDispatcher(): AppCoroutineDispatchers {
    return AppCoroutineDispatchers(
        default = Platform().defaultDispatcher
    )
}