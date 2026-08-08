package com.civdevops.cyptoinfonav3.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.civdevops.cyptoinfonav3.presentation.coindetail.CoinDetailsScreen
import com.civdevops.cyptoinfonav3.presentation.coinlist.CoinListScreen

@Composable
fun NavigationRoot(
    modifier: Modifier
){
    val backStack = rememberNavBackStack(NavigationKey.CoinListKey)

    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<NavigationKey.CoinListKey> {
                CoinListScreen(
                    modifier = Modifier,
                    onClickItem = { coinId ->
                        backStack.add(NavigationKey.CoinDetailsKey(id = coinId))
                    }
                )
            }
            entry<NavigationKey.CoinDetailsKey> { key ->
                CoinDetailsScreen(
                    modifier = Modifier,
                    coinId = key.id
                )
            }
        }
    )
}