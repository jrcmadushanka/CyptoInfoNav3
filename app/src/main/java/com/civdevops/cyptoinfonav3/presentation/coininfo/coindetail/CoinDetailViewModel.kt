package com.civdevops.cyptoinfonav3.presentation.coininfo.coindetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.civdevops.cyptoinfonav3.common.Resource
import com.civdevops.cyptoinfonav3.domain.usecase.GetCoinDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinDetailsUseCase: GetCoinDetailsUseCase,
): ViewModel() {

    private val _state: MutableStateFlow<CoinDetailState> = MutableStateFlow(CoinDetailState())
    val state = _state.asStateFlow()

    fun getCoinDetail(coinId: String){
        getCoinDetailsUseCase(coinId).onEach { resource ->
            _state.update { currentState ->
                currentState.copy(
                    isLoading = resource is Resource.Loading,
                    data = resource.data ?: currentState.data,
                    error = resource.message
                )
            }
        }.launchIn(viewModelScope)
    }
}