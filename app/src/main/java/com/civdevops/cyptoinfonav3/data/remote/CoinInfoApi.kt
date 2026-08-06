package com.civdevops.cyptoinfonav3.data.remote

import com.civdevops.cyptoinfonav3.data.remote.dto.CoinDetailDto
import com.civdevops.cyptoinfonav3.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinInfoApi {

    @GET("coins")
    suspend fun getCoinList(): List<CoinDto>

    @GET("coins/{coin_id}")
    suspend fun getCoinDetails(@Path("coin_id") coinId: String): CoinDetailDto
}