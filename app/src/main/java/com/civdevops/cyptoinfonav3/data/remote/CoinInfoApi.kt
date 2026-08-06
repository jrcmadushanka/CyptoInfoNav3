package com.civdevops.cyptoinfonav3.data.remote

import com.civdevops.cyptoinfonav3.data.remote.dto.CoinDto
import retrofit2.http.GET

interface CoinInfoApi {

    @GET("coins")
    suspend fun getCoinList(): List<CoinDto>
}