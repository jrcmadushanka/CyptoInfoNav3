package com.civdevops.cyptoinfonav3.domain.model


import kotlinx.serialization.Serializable

@Serializable
data class Whitepaper(
    val link: String?,
    val thumbnail: String?
)