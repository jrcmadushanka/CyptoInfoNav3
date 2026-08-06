package com.civdevops.cyptoinfonav3.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Coin(
    val id: String,
    val isActive: Boolean,
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String
)