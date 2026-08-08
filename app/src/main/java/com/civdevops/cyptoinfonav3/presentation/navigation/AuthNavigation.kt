package com.civdevops.cyptoinfonav3.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.civdevops.cyptoinfonav3.presentation.auth.AuthViewModel
import com.civdevops.cyptoinfonav3.presentation.auth.login.LoginScreen
import com.civdevops.cyptoinfonav3.presentation.auth.register.RegisterScreen

@Composable
fun AuthNavigation(
    onLogin: () -> Unit
) {
    val authNavigationBackStack = rememberNavBackStack(NavigationKey.Auth.Login)
    val authViewModel: AuthViewModel = hiltViewModel()

    NavDisplay(
        entryDecorators = listOf(
            rememberViewModelStoreNavEntryDecorator(),
            rememberSaveableStateHolderNavEntryDecorator()
        ),
        backStack = authNavigationBackStack,
        entryProvider = entryProvider {
            entry<NavigationKey.Auth.Login> {
                LoginScreen(
                    loginViewModel = hiltViewModel(),
                    authViewModel = authViewModel,
                    onLogin = onLogin,
                    onRegister = {
                    authNavigationBackStack.add(NavigationKey.Auth.Register)
                })
            }
            entry<NavigationKey.Auth.Register> {
                RegisterScreen(
                    registerViewModel = hiltViewModel(),
                    authViewModel = authViewModel,
                )
            }
        },
    )
}