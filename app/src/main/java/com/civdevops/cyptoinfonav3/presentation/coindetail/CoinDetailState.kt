package com.civdevops.cyptoinfonav3.presentation.coindetail

import com.civdevops.cyptoinfonav3.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val data: CoinDetail? = null,
    val error: String? = null
)