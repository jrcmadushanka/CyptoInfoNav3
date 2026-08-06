package com.civdevops.cyptoinfonav3.data.remote.dto

import com.civdevops.cyptoinfonav3.domain.model.Contract

data class ContractDto(
    val contract: String?,
    val platform: String?,
    val type: String?
)

fun ContractDto.toContract(): Contract =
    Contract(
        contract = contract ?: "",
        platform = platform ?: "",
        type = type ?: ""
    )