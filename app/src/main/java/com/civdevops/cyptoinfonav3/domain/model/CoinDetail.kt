package com.civdevops.cyptoinfonav3.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class CoinDetail(
    val contract: String?,
    val contracts: List<Contract>,
    val description: String?,
    val developmentStatus: String?,
    val id: String,
    val isActive: Boolean,
    val isNew: Boolean,
    val logo: String,
    val name: String,
    val openSource: Boolean,
    val platform: String?,
    val rank: Int,
    val startedAt: String?,
    val symbol: String,
    val tags: List<String>?,
    val team: List<Team>?,
    val whitepaper: Whitepaper,
    val title: String,
    val infoList: List<String>
)