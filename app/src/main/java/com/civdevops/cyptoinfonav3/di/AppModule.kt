package com.civdevops.cyptoinfonav3.di

import com.civdevops.cyptoinfonav3.common.Constants.BASE_URL
import com.civdevops.cyptoinfonav3.data.remote.CoinInfoApi
import com.civdevops.cyptoinfonav3.data.repository.CoinInfoRepositoryImpl
import com.civdevops.cyptoinfonav3.domain.repository.CoinInfoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()

    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient): CoinInfoApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(CoinInfoApi::class.java)
    }

    @Provides
    fun providesCoinRepository(coinInfoApi: CoinInfoApi): CoinInfoRepository {
        return CoinInfoRepositoryImpl(coinInfoApi = coinInfoApi)
    }
}