package com.civdevops.cyptoinfonav3.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay

@Composable
fun NavigationRoot(
    modifier: Modifier
){
    val rootBackStack = rememberNavBackStack(NavigationKey.Auth)

    NavDisplay(
        modifier = modifier,
        backStack = rootBackStack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry< NavigationKey.Auth> {
                AuthNavigation(onLogin = {
                    rootBackStack.add(NavigationKey.CoinInfo)
                    rootBackStack.remove(NavigationKey.Auth)
                })
            }

            entry< NavigationKey.CoinInfo> {
                CoinInfoNavigation()
            }
        }
    )
}