package com.civdevops.cyptoinfonav3.data.remote.dto

import com.civdevops.cyptoinfonav3.domain.model.CoinDetail
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName

data class CoinDetailDto(
    @SerializedName("contract")
    val contract: String?,
    val contracts: List<ContractDto>?,
    val description: String?,
    @SerializedName("development_status")
    val developmentStatus: String?,
    @SerializedName("first_data_at")
    val firstDataAt: String,
    @SerializedName("hardware_wallet")
    val hardwareWallet: Boolean,
    @SerializedName("hash_algorithm")
    val hashAlgorithm: String?,
    @SerialName("id")
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("last_data_at")
    val lastDataAt: String,
    val linksDto: LinksDto?,
    @SerializedName("links_extended")
    val linksExtendedDto: List<LinksExtendedDto>?,
    val logo: String,
    val message: String,
    val name: String,
    @SerializedName("open_source")
    val openSource: Boolean,
    @SerializedName("org_structure")
    val orgStructure: String?,
    val parentDto: ParentDto?,
    val platform: String?,
    @SerializedName("proof_type")
    val proofType: String?,
    val rank: Int,
    @SerializedName("started_at")
    val startedAt: String?,
    val symbol: String,
    val tags: List<TagDto>?,
    val team: List<TeamDto>?,
    val type: String,
    val whitepaper: WhitepaperDto?
)

fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        contract = contract,
        contracts = contracts?.map { it.toContract() },
        description = description,
        developmentStatus = developmentStatus,
        id = id,
        isActive = isActive,
        isNew = isNew,
        logo = logo,
        name = name,
        openSource = openSource,
        platform = platform,
        rank = rank,
        startedAt = startedAt,
        symbol = symbol,
        tags = tags?.map { it.name },
        team = team?.map { it.toTeam() },
        whitepaper = whitepaper?.toWhitePaper(),
        title = "$rank. $name ($symbol)",
        infoList = getInfoList()
    )
}

private fun CoinDetailDto.getInfoList(): List<String> = buildList {
    if (isActive) add("Active")
    if (isNew) add("New")
    if (openSource) add("Open Source")
    if (hardwareWallet) add("Hardware Wallet")
}