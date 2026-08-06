package com.civdevops.cyptoinfonav3.domain.usecases

import com.civdevops.cyptoinfonav3.common.Resource
import com.civdevops.cyptoinfonav3.common.toResourceFlow
import com.civdevops.cyptoinfonav3.data.remote.dto.toCoin
import com.civdevops.cyptoinfonav3.domain.models.Coin
import com.civdevops.cyptoinfonav3.domain.repository.CoinInfoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoinListUseCase @Inject constructor(
    private val coinInfoRepository: CoinInfoRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = toResourceFlow {
        coinInfoRepository.getCoinList().map { it.toCoin() }
    }
}