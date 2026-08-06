package com.civdevops.cyptoinfonav3.domain.model


import kotlinx.serialization.Serializable

@Serializable
data class Team(
    val id: String?,
    val name: String?,
    val position: String?
)