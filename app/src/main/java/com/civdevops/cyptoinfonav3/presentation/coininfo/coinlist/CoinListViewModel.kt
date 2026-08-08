package com.civdevops.cyptoinfonav3.presentation.coininfo.coinlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.civdevops.cyptoinfonav3.common.Resource
import com.civdevops.cyptoinfonav3.domain.usecase.GetCoinListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val coinListUseCase: GetCoinListUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(CoinListState())
    val state = _state.asStateFlow()

    init {
        getCoinList()
    }

    fun getCoinList(){
        coinListUseCase().onEach { results ->
            _state.value = _state.value.copy(
                isLoading = results is Resource.Loading,
                error = results.message,
                data = results.data
            )
        }.launchIn(viewModelScope)
    }
}