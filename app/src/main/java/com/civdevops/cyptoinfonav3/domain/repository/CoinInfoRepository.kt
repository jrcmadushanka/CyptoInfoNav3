package com.civdevops.cyptoinfonav3.domain.repository

import com.civdevops.cyptoinfonav3.data.remote.dto.CoinDetailDto
import com.civdevops.cyptoinfonav3.data.remote.dto.CoinDto

interface CoinInfoRepository {

    suspend fun getCoinList(): List<CoinDto>

    suspend fun getCoinDetails(coinId: String): CoinDetailDto
}