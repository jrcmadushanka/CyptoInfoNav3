package com.civdevops.cyptoinfonav3.domain.model


import kotlinx.serialization.Serializable

@Serializable
data class Contract(
    val contract: String,
    val platform: String,
    val type: String
)