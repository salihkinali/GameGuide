package com.salihkinali.gameguide.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salihkinali.gameguide.R
import com.salihkinali.gameguide.data.NetworkResponse
import com.salihkinali.gameguide.data.mapper.GameMapper
import com.salihkinali.gameguide.domain.entity.SingleGameEntity
import com.salihkinali.gameguide.domain.usecase.GetSingleGameUseCase
import com.salihkinali.gameguide.ui.common.UiResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val singleGameUseCase: GetSingleGameUseCase,
    private val singleGameMapper: GameMapper<SingleGameEntity, SingleGameUiData>
) : ViewModel() {

    private val _detailUiData =
        MutableStateFlow<UiResponseState<SingleGameUiData>>(UiResponseState.Loading)
    val detailUiData: StateFlow<UiResponseState<SingleGameUiData>> get() = _detailUiData


    fun getDataFromSource(id: Int) {
        viewModelScope.launch {
            singleGameUseCase.invoke(id).collectLatest {

                // Burada Kaldım.
                when (it) {
                    is NetworkResponse.Error -> {
                        _detailUiData.emit(UiResponseState.Error(R.string.error_message))
                    }
                    is NetworkResponse.Loading -> _detailUiData.emit(UiResponseState.Loading)

                    is NetworkResponse.Success -> {

                    }
                }
            }
        }
    }
}

