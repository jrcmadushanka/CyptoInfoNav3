package com.civdevops.cyptoinfonav3.presentation.coinlist

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.civdevops.cyptoinfonav3.common.Resource
import com.civdevops.cyptoinfonav3.domain.usecases.GetCoinListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.selects.whileSelect
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val coinListUseCase: GetCoinListUseCase
) : ViewModel() {
    private val _state = mutableStateOf(CoinListState())
    val state = _state

    init {
        getCoinList()
    }

    fun getCoinList(){
        coinListUseCase().onEach { results ->
            when(results){
                is Resource.Error -> {
                    _state.value = CoinListState(error = results.message)
                }
                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = CoinListState(data = results.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}