package com.civdevops.cyptoinfonav3.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.civdevops.cyptoinfonav3.presentation.coininfo.coindetail.CoinDetailsScreen
import com.civdevops.cyptoinfonav3.presentation.coininfo.coinlist.CoinListScreen

@Composable
fun CoinInfoNavigation() {

    val coinInfoBackStack = rememberNavBackStack(NavigationKey.CoinInfo.CoinListKey)

    NavDisplay(
        entryDecorators = listOf(
            rememberViewModelStoreNavEntryDecorator(),
            rememberSaveableStateHolderNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<NavigationKey.CoinInfo.CoinListKey> {
                CoinListScreen(
                ) { coinId ->
                    coinInfoBackStack.add(NavigationKey.CoinInfo.CoinDetailsKey(coinId))
                }
            }

            entry<NavigationKey.CoinInfo.CoinDetailsKey> { key ->
                CoinDetailsScreen(
                    coinId = key.id,
                )
            }
        },
        backStack = coinInfoBackStack
    )
}