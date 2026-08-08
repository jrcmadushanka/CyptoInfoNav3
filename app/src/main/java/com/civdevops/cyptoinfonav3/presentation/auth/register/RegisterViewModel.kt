package com.civdevops.cyptoinfonav3.presentation.auth.register

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(): ViewModel() {

    private val _state = MutableStateFlow(0)
    val state = _state.asStateFlow()

    fun updateCounter() {
       _state.value++
    }
}