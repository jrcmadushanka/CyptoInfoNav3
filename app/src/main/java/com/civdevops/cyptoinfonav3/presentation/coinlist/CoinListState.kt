package com.civdevops.cyptoinfonav3.presentation.coinlist

import com.civdevops.cyptoinfonav3.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val data: List<Coin>? = null,
    val error: String? = null
)