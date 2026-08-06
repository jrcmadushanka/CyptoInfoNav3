package com.civdevops.cyptoinfonav3.domain.repository

import com.civdevops.cyptoinfonav3.data.remote.dto.CoinDto

interface CoinInfoRepository {

    suspend fun getCoinList(): List<CoinDto>
}