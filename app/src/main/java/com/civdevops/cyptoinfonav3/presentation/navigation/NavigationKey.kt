package com.civdevops.cyptoinfonav3.presentation.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface NavigationKey: NavKey  {
    @Serializable
    data object CoinListKey: NavigationKey, NavKey
    @Serializable
    data class CoinDetailsKey(val id: String): NavigationKey, NavKey
}