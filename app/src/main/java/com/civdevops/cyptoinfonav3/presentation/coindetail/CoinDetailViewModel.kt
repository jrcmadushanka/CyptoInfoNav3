package com.civdevops.cyptoinfonav3.presentation.coindetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.civdevops.cyptoinfonav3.common.Resource
import com.civdevops.cyptoinfonav3.domain.usecase.CoinDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val useCase: CoinDetailsUseCase
): ViewModel() {

    private val _state: MutableStateFlow<CoinDetailState> = MutableStateFlow(CoinDetailState())
    val state = _state.asStateFlow()

    init {
        getCoinDetail()
    }

    private fun getCoinDetail(){
        useCase().onEach { resource ->
            _state.value = _state.value.copy(
                isLoading = resource is Resource.Loading,
                error = resource.message,
                data = resource.data
            )
        }.launchIn(viewModelScope)
    }
}