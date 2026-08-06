package com.civdevops.cyptoinfonav3.data.remote.dto

import com.civdevops.cyptoinfonav3.domain.model.Whitepaper

data class WhitepaperDto(
    val link: String?,
    val thumbnail: String?
)

fun WhitepaperDto.toWhitePaper(): Whitepaper = Whitepaper(
    link = link,
    thumbnail = thumbnail
)