package com.mukul.youtv.android.inject

import com.mukul.jan.youtv.android.base.AndroidAppCoroutineDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppInjectModule {

    @Provides
    @Singleton
    fun androidAppCoroutineDispatchers(): AndroidAppCoroutineDispatchers {
        return AndroidAppCoroutineDispatchers(
            main = Dispatchers.Main,
            io = Dispatchers.IO,
            default = Dispatchers.Default
        )
    }

}