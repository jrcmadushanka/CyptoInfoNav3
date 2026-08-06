package com.civdevops.cyptoinfonav3.data.remote.dto

import com.civdevops.cyptoinfonav3.domain.model.Team

data class TeamDto(
    val id: String?,
    val name: String?,
    val position: String?
)

fun TeamDto.toTeam(): Team = Team(
    id = id,
    name = name,
    position = position
)