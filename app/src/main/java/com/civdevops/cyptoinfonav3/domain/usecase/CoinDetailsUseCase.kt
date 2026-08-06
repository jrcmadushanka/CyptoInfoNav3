package com.civdevops.cyptoinfonav3.domain.usecase

import com.civdevops.cyptoinfonav3.domain.model.CoinDetail
import com.civdevops.cyptoinfonav3.common.Resource
import com.civdevops.cyptoinfonav3.common.toResourceFlow
import com.civdevops.cyptoinfonav3.data.remote.dto.toCoinDetail
import com.civdevops.cyptoinfonav3.domain.repository.CoinInfoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CoinDetailsUseCase @Inject constructor(
    private val repository: CoinInfoRepository
){
    operator fun invoke(): Flow<Resource<CoinDetail>> = toResourceFlow {
        repository.getCoinDetails("code5-eigencode").toCoinDetail()
    }
}