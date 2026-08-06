package com.civdevops.cyptoinfonav3.data.repository

import com.civdevops.cyptoinfonav3.data.remote.CoinInfoApi
import com.civdevops.cyptoinfonav3.data.remote.dto.CoinDetailDto
import com.civdevops.cyptoinfonav3.data.remote.dto.CoinDto
import com.civdevops.cyptoinfonav3.domain.repository.CoinInfoRepository
import javax.inject.Inject

class CoinInfoRepositoryImpl @Inject constructor(
    private val coinInfoApi: CoinInfoApi
) : CoinInfoRepository {

    override suspend fun getCoinList(): List<CoinDto> = coinInfoApi.getCoinList()

    override suspend fun getCoinDetails(coinId: String): CoinDetailDto = coinInfoApi.getCoinDetails(coinId)
}